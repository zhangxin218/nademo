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
package com.huawei.iom.nademo.service.data;

import static com.huawei.iom.nademo.exception.ExpandExceptionEnum.APP_NA_QUERY_All_DEVICES_FAILED;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huawei.iom.component.httpclient.exception.HttpRequestException;
import com.huawei.iom.component.httpclient.exception.HttpResponseException;
import com.huawei.iom.component.httpclient.util.HttpUtil;
import com.huawei.iom.component.util.JsonUtil;
import com.huawei.iom.component.util.StringUtil;
import com.huawei.iom.intf.app.data.v1.dto.QueryDeviceCapabilitiesDTOCloud2NA;
import com.huawei.iom.intf.app.data.v1.dto.QueryDeviceDataHistoryDTOCloud2NA;
import com.huawei.iom.intf.app.dm.v1.dto.QueryDeviceDTOCloud2NA;
import com.huawei.iom.intf.app.dm.v1.dto.QueryDevicesDTOCloud2NA;
import com.huawei.iom.nademo.common.login.AuthHttpClient;
import com.huawei.iom.nademo.common.url.UrlConfiguration;
import com.huawei.iom.nademo.exception.ServiceException;

public class DataService {
    /**
     * 日志工具
     */
    private static final Logger log = LoggerFactory.getLogger(DataService.class);
    

    /**
     * 按条件批量查询设备信息列表
     *
     * @param gatewayId 网关型设备ID
     * @param nodeType 设备类型，为null则查询所有类型
     * @param pageNo 查询页数，缺省为0
     * @param pageSize 查询每页数据量，缺省为1，一般传递全局常量
     * @return 查询nscl返回设备列表
     * @throws IOException
     * @throws HttpResponseNotOKException
     * @throws URISyntaxException
     * @throws ServiceException
     */
    public static QueryDevicesDTOCloud2NA queryDevicesInfo(String appId, String gatewayId, String status, String nodeType,
            Integer pageNo, Integer pageSize, String startTime, String endTime,  String sort)
            throws IOException, HttpRequestException, HttpResponseException, URISyntaxException, ServiceException
    {

        String url = UrlConfiguration.getDataDevicesUrl();
//        HttpClientUtil httpClient = new HttpClientUtil();

        Map<String, String> param = new HashMap<>();
        if (!StringUtil.strIsNullOrEmpty(appId))
        {
            param.put("appId", appId);
        }

        if (!StringUtil.strIsNullOrEmpty(gatewayId))
        {
            param.put("gatewayId", gatewayId);
        }

        if (pageNo != null)
        {
            param.put("pageNo", pageNo.toString());
        }

        if (pageSize != null)
        {
            param.put("pageSize", pageSize.toString());
        }
        
        if (!StringUtil.strIsNullOrEmpty(status))
        {
            param.put("status", status);
        }
        
        if (!StringUtil.strIsNullOrEmpty(nodeType))
        {
            param.put("nodeType", nodeType);
        }
        
        if (!StringUtil.strIsNullOrEmpty(startTime))
        {
            param.put("startTime", startTime);
        }
        
        if (!StringUtil.strIsNullOrEmpty(endTime))
        {
            param.put("endTime", endTime);
        }
        
        if (!StringUtil.strIsNullOrEmpty(sort))
        {
            param.put("sort", sort);
        }

        log.info("The param to query all devices info is :{},url:{}.", param,url);
        
        String body = HttpUtil.doGetWithParasForString(url, param, AuthHttpClient.getInstance().getAuthHeader());
        
        QueryDevicesDTOCloud2NA response = JsonUtil.jsonString2SimpleObj(body, QueryDevicesDTOCloud2NA.class);

        // 判断接收到空数据的场景下是否包含错误码，防止数据误删，前者为平台回的错误码，后者为apiGW回的错误码
        if (response != null && response.getDevices() == null && ((body.contains("error_code") || body.contains(
                "resultcode"))))
        {
            log.error("Failed to get deviceInfo from IoT platform, body is {}", body);
            throw new ServiceException(APP_NA_QUERY_All_DEVICES_FAILED);
        }
        else
        {
            log.info("success to get devices info from iocm.");
            return response;
        }
    }

    /**
     * 查询单个设备信息
     *
     * @param deviceId 网关型设备ID
     * @return 设备详细信息
     * @throws IOException
     * @throws HttpResponseNotOKException
     * @throws URISyntaxException
     * @throws ServiceException
     */
    public static QueryDeviceDTOCloud2NA queryOneDeviceInfo(String deviceId, String appId)
            throws IOException, HttpRequestException, HttpResponseException, URISyntaxException, ServiceException
    {

        String url = UrlConfiguration.getDataDeviceUrl(deviceId);
        
        Map<String, String> param = new HashMap<>();
        if (!StringUtil.strIsNullOrEmpty(appId))
        {
            param.put("appId", appId);
        }
        
        log.info("query one device info.url:{}.",url);
        String body = HttpUtil.doGetWithParasForString(url, param, AuthHttpClient.getInstance().getAuthHeader());

        QueryDeviceDTOCloud2NA response = JsonUtil.jsonString2SimpleObj(body, QueryDeviceDTOCloud2NA.class);


        return response;
    }
    

    /**
     * 查询Device历史数据
     *
     * @param deviceId 设备ID
     * @param serviceId serviceId
     * @param pageNo 分页参数-页码
     * @param pageSize 分页参数-每页大小
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 设备历史数据
     * @throws IOException
     * @throws HttpResponseNotOKException
     * @throws URISyntaxException
     */
    public static QueryDeviceDataHistoryDTOCloud2NA getDeviceHistory(String deviceId,String gatewayId, String serviceId, Integer pageNo, Integer pageSize,
            String startTime, String endTime)
            throws IOException, HttpRequestException, HttpResponseException, URISyntaxException, ServiceException
    {
        String url = UrlConfiguration.getDataDeviceHistoryUrl();
//        HttpClientUtil httpClient = new HttpClientUtil();

        Map<String, String> param = new HashMap<>();
        if (!StringUtil.strIsNullOrEmpty(deviceId))
        {
            param.put("deviceId", deviceId);
        }
        if (!StringUtil.strIsNullOrEmpty(gatewayId))
        {
            param.put("gatewayId", gatewayId);
        }
        if (!StringUtil.strIsNullOrEmpty(serviceId))
        {
            param.put("serviceId", serviceId);
        }
        if (pageNo != null)
        {
            param.put("pageNo", pageNo.toString());
        }
        if (pageSize != null)
        {
            param.put("pageSize", pageSize.toString());
        }
        if (!StringUtil.strIsNullOrEmpty(startTime))
        {
            param.put("startTime", startTime);
        }
        if (!StringUtil.strIsNullOrEmpty(endTime))
        {
            param.put("endTime", endTime);
        }
        log.info("get device history.url:{},param:{}.",url,param);
        String responseBody = HttpUtil.doGetWithParasForString(url, param, AuthHttpClient.getInstance().getAuthHeader());

        return JsonUtil.jsonString2SimpleObj(responseBody, QueryDeviceDataHistoryDTOCloud2NA.class);
    }
    
    /**
     * 查询指定设备的服务能力
     *
     * @param deviceId 选取利用设备Id查询方式
     * @param gatewayId 选取利用网关型设备Id查询方式
     * @return 设备服务能力列表
     * @throws IOException
     * @throws HttpResponseNotOKException
     * @throws URISyntaxException
     */
    public static QueryDeviceCapabilitiesDTOCloud2NA queryDeviceServiceCapabilities(String deviceId, String gatewayId)
            throws IOException, HttpRequestException, HttpResponseException, URISyntaxException, ServiceException
    {
        String url = UrlConfiguration.getDataDeviceCapabilitiesUrl();

        Map<String, String> param = new HashMap<>();
        if (!StringUtil.strIsNullOrEmpty(deviceId))
        {
            param.put("deviceId", deviceId);
        }
        
        if (!StringUtil.strIsNullOrEmpty(gatewayId))
        {
            param.put("gatewayId", gatewayId);
        }
        
        log.info("query device service capavilities.url:{},param:{}.",url,param);
        
        String body = HttpUtil.doGetWithParasForString(url, param, AuthHttpClient.getInstance().getAuthHeader());
                
        QueryDeviceCapabilitiesDTOCloud2NA response = JsonUtil.jsonString2SimpleObj(body,
                QueryDeviceCapabilitiesDTOCloud2NA.class);


        return response;
    }

}
