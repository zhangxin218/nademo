/*
 * Copyright Notice:
 *      Copyright  1998-2008, Huawei Technologies Co., Ltd.  ALL Rights Reserved.
 *
 *      Warning: This computer software sourcecode is protected by copyright law
 *      and international treaties. Unauthorized reproduction or distribution
 *      of this sourcecode, or any portion of it, may result in severe civil and
 *      criminal penalties, and will be prosecuted to the maximum extent
 *      possible under the law.
 */
package com.huawei.iom.nademo.service.device;


import static com.huawei.iom.nademo.exception.ExpandExceptionEnum.APP_NA_GENERATE_DEVICE_VERIFICATION_DEVICE_ACTIVED;
import static com.huawei.iom.nademo.exception.ExpandExceptionEnum.NA_NSCL_GENERATE_DEVICE_VERIFICATION_NSCL_INVALID;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huawei.iom.component.exception.ExceptionMsg;
import com.huawei.iom.component.httpclient.exception.HttpExceptionEnum;
import com.huawei.iom.component.httpclient.exception.HttpRequestException;
import com.huawei.iom.component.httpclient.exception.HttpResponseException;
import com.huawei.iom.component.httpclient.util.HttpUtil;
import com.huawei.iom.component.util.JsonUtil;
import com.huawei.iom.intf.app.dm.v1.dto.UpdateDeviceInfoDTONA2Cloud;
import com.huawei.iom.intf.app.reg.v1.dto.AddDeviceDTOCloud2NA;
import com.huawei.iom.intf.app.reg.v1.dto.AddDeviceDTONA2Cloud;
import com.huawei.iom.intf.app.reg.v1.dto.QueryDeviceRegStatusDTOCloud2NA;
import com.huawei.iom.intf.app.signaltrans.v1.dto.CommandDTODevice2CloudReply;
import com.huawei.iom.intf.app.signaltrans.v1.dto.CommandDTONA2Cloud;
import com.huawei.iom.nademo.common.login.AuthHttpClient;
import com.huawei.iom.nademo.common.url.UrlConfiguration;
import com.huawei.iom.nademo.exception.ExpandExceptionEnum;
import com.huawei.iom.nademo.exception.ServiceException;

public class DeviceService {
    /**
     * 日志工具
     */
    private static final Logger log = LoggerFactory.getLogger(DeviceService.class);

    private static final String DEVICE_ALREADY_BIND = "100416";

    private static final String DEVICE_NOTONLINE = "100428";

    private static final String DEVICE_COMMAND_MUTE = "100432";
    
    
    /**
     * 注册直连设备
     * @return
     * @throws IOException 
     * @throws ServiceException 
     * @throws HttpRequestException 
     * @throws HttpResponseException 
     */
    public static AddDeviceDTOCloud2NA registerDevice(String verifyCode, String nodeId) 
            throws IOException, HttpResponseException, ServiceException{
        AddDeviceDTONA2Cloud getVerifyRequest = new AddDeviceDTONA2Cloud();
        
        String url = UrlConfiguration.getDeviceRegisterUrl();

        getVerifyRequest.setVerifyCode(verifyCode.toUpperCase());
        getVerifyRequest.setNodeId(nodeId.toUpperCase());
        getVerifyRequest.setEndUserId("currentuser");
        getVerifyRequest.setTimeout(0);

        String jsonRequest = JsonUtil.jsonObj2Sting(getVerifyRequest);
                
        log.info("apply new gatewayid.url:{}, request:{}.",url,getVerifyRequest);
        
        String body = HttpUtil.doPostJsonForString(url, AuthHttpClient.getInstance().getAuthHeader(), jsonRequest);

        if(body == null)
        {
            log.error("body is null, fail to translate jsonResponse to String");
            throw new ServiceException(NA_NSCL_GENERATE_DEVICE_VERIFICATION_NSCL_INVALID);
        }

        log.info("nscl response string is :{}", body);

        // 判断是否为指定情况的错误信息
        if (body.contains("error_code"))
        {
            ExceptionMsg errorResponse = JsonUtil.jsonString2SimpleObj(body, ExceptionMsg.class);

            if(errorResponse.getError_code() != null && errorResponse.getError_code().equals(DEVICE_ALREADY_BIND))
            {
                log.error("This device has already been binded, can not been regist again");
                throw new ServiceException(APP_NA_GENERATE_DEVICE_VERIFICATION_DEVICE_ACTIVED);
            }
            else
            {
                log.error("Generate device id and verifyCode failed, cause bad nscl response, error message is : {}.", errorResponse);
                throw new ServiceException(NA_NSCL_GENERATE_DEVICE_VERIFICATION_NSCL_INVALID);
            }
        }

        // 返回正常的情况
        AddDeviceDTOCloud2NA response = JsonUtil.jsonString2SimpleObj(body, AddDeviceDTOCloud2NA.class);

        return response;
    }
    
    /**
     * 发送device控制命令
     *
     * @param deviceId 设备Id
     * @param serviceId serviceId
     * @param request 控制命令参数包括header和body
     * @return 发送到平台的结果
     * @throws IOException
     * @throws HttpResponseNotOKException
     */
    public static CommandDTODevice2CloudReply sendDeviceCommand(String deviceId, String serviceId,
            CommandDTONA2Cloud request)
            throws IOException, HttpRequestException, HttpResponseException, ServiceException
    {
        String url = UrlConfiguration.getDeviceControlUrl(deviceId, serviceId);

        String jsonRequest = JsonUtil.jsonObj2Sting(request);
        log.info("send device command.url:{},request:{}.",url,jsonRequest);
        
        HttpResponse httpResponse = HttpUtil.doPostJson(url,
                AuthHttpClient.getInstance().getAuthHeader(), jsonRequest);
        
        String responseBody = HttpUtil.getHttpResponseBody(httpResponse);
        
        checkSendCommandReponseBody(responseBody, deviceId);

        return JsonUtil.jsonString2SimpleObj(responseBody, CommandDTODevice2CloudReply.class);
    }
    
    private static void checkSendCommandReponseBody(String responseBody, String deviceId) throws ServiceException
    {
        if(responseBody == null)
        {
            log.error("(responseBody is null, fail to translate jsonResponse to String");
            throw new ServiceException(NA_NSCL_GENERATE_DEVICE_VERIFICATION_NSCL_INVALID);
        }

        if ((responseBody.contains("error_code")) && (responseBody.contains(
                DEVICE_NOTONLINE)))
        {
            log.error("The device is not online. response body:{}", responseBody);
            throw new ServiceException(ExpandExceptionEnum.APP_NA_COMMAND_DEVICE_NOTONLINE);
        }
        else if ((responseBody.contains("error_code")) && (responseBody.contains(
                DEVICE_COMMAND_MUTE)))
        {
            log.error("The device command is muted. response body:{}", responseBody);
            throw new ServiceException(ExpandExceptionEnum.APP_NA_COMMAND_DEVICE_MUTED);
        }
        else if ((responseBody.contains("error_code")))
        {
            log.error("response fail when send device command to nscl. response body:{}", responseBody);
            throw new ServiceException(ExpandExceptionEnum.APP_NA_COMMAND_DEVICE_FAILED);
        }
    }
    
    /**
     * 查询设备激活状态
     *
     * @param deviceId 网关型设备ID
     * @return 包含激活状态的结构体
     * @throws IOException
     * @throws HttpResponseNotOKException
     * @throws URISyntaxException
     * @throws ServiceException
     */
    public static QueryDeviceRegStatusDTOCloud2NA queryDeviceActiveStatus(String deviceId)
            throws IOException, HttpRequestException, HttpResponseException, URISyntaxException, ServiceException
    {

        String url = UrlConfiguration.getDeviceActiveStatusUrl(deviceId);
        log.info("query device active status.url:{}.",url);
        String body = HttpUtil.doGetWithParasForString(url, null, AuthHttpClient.getInstance().getAuthHeader());

        QueryDeviceRegStatusDTOCloud2NA response = JsonUtil.jsonString2SimpleObj(body,
                QueryDeviceRegStatusDTOCloud2NA.class);

        return response;
    }

    /**
     * 删除设备, 包含网关类型设备和一般设备
     *
     * @param deviceId 设备ID
     * @throws IOException
     * @throws HttpResponseNotOKException
     * @throws URISyntaxException
     */
    public static String deleteDevice(String deviceId)
            throws IOException, HttpRequestException, HttpResponseException, URISyntaxException, ServiceException
    {
        String url = UrlConfiguration.getDeviceDeleteUrl(deviceId);
        log.info("delete device.url:{}.",url);
        String responseBody = HttpUtil.doDeleteForString(url, AuthHttpClient.getInstance().getAuthHeader());

        if ((responseBody != null) && (responseBody.contains("error_code")))
        {
            log.error("Delete device failed.");
            throw new HttpResponseException(HttpExceptionEnum.HTTP_RESPONSE_INVALID);
        }
        return responseBody;
    }

    /**
     * 修改设备信息
     *
     * @param deviceId 设备ID
     * @param request 改名body
     * @throws IOException
     * @throws HttpResponseNotOKException
     * @throws URISyntaxException
     */
    public static String renameDevice(String deviceId, UpdateDeviceInfoDTONA2Cloud request)
            throws IOException, HttpRequestException, HttpResponseException, URISyntaxException, ServiceException
    {

        String url = UrlConfiguration.getDeviceUpdateUrl(deviceId);

        String jsonRequest = JsonUtil.jsonObj2Sting(request);
        log.info("rename device.url:{},request:{}.",url,jsonRequest);
        String responseBody = HttpUtil.doPutJsonForString(url, AuthHttpClient.getInstance().getAuthHeader(), jsonRequest);

        if ((responseBody != null) && (responseBody.contains("error_code")))
        {
            log.error("The response is invalid.");
            throw new HttpResponseException(HttpExceptionEnum.HTTP_RESPONSE_INVALID);
        }
        return responseBody;
    }
}
