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
package com.huawei.iom.nademo.common.url;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huawei.iom.component.httpclient.exception.HttpResponseException;
import com.huawei.iom.component.httpclient.util.HttpUtil;
import com.huawei.iom.component.util.StringUtil;
import com.huawei.iom.nademo.common.consts.CommonConst;
import com.huawei.iom.nademo.common.login.AuthHttpClient;

public class RegisterUrlInit {
    /**
     * 日志工具
     */
    private static final Logger log = LoggerFactory.getLogger(RegisterUrlInit.class);
    
    private void regUrltoIoCM(JSONObject message, String sendUrl)
    {
        log.info("reg url:{},message:{}", sendUrl, message);

        int count = 0;
        Long sleepTime = CommonConst.REGISTER_URL_MIN_PERIOD;

        while (true)
        {
            log.debug("The count is {}, sleepTime is {}", count, sleepTime);

            ++count;

            if(sleepTime < CommonConst.REGISTER_URL_MAX_PERIOD)
            {
                sleepTime = Math.round(Math.pow(2, count)) * CommonConst.SECOND_TO_MILLISECOND;
            }
            else
            {
                sleepTime = CommonConst.REGISTER_URL_MAX_PERIOD;
            }

            try
            {
                HttpResponse httpResponse = HttpUtil.doPostJson(sendUrl, AuthHttpClient.getInstance().getAuthHeader(), message.toString());

                String result = HttpUtil.getHttpResponseBody(httpResponse);

                if ((httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK
                        || httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED)
                        && (StringUtil.strIsNullOrEmpty(result)))
                {
                    log.info("success to register callback url: {}", message);
                    break;
                }
                else
                {
                    log.warn("reg fail, message:{}, response:{} {}",message,httpResponse.getStatusLine().getStatusCode(),result);
                }
            }
            catch (HttpResponseException e)
            {
                log.error("this is a HttpResponseException:", e);
            }
            catch (Exception e)
            {
                log.error("fail to register url", e);
            }

            try
            {
                Thread.sleep(sleepTime);
            }
            catch (InterruptedException e)
            {
                log.error("this is a java.lang.InterruptedException:", e);
            }
        }
    }

    private void startThread(JSONObject message, String url)
    {
        Thread regUrl = new Thread()
        {
            @Override
            public void run()
            {
                regUrltoIoCM(message, url);
            }
        };

        //TemporaryThreadService.getInstance().submit(regUrl);
        regUrl.start();
    }

    public void init()
    {
        regActDeviceUrl();
        regAddDeviceUrl();
        regDropDeviceUrl();
        regUpdDeviceInfoUrl();
        regUpdDeviceDataUrl();
        regUpdSrvInfoUrl();
        regCmdConfirmUrl();
        regCmdRspUrl();
        regDeviceEventUrl();
    }


    // ---------------------------------------below 1.1------------------------------------

    private void regActDeviceUrl()
    {
        JSONObject message = new JSONObject();
        message.put("notifyType", CommonConst.NOTIFY_TYPE_ACTIVE_DEVICE);
        message.put("callbackurl", UrlConfiguration.getActDevCallbackUrl());

        startThread(message, UrlConfiguration.getDataSubscriptionUrl());
    }

    private void regAddDeviceUrl()
    {
        JSONObject message = new JSONObject();
        message.put("notifyType", CommonConst.NOTIFY_TYPE_ADD_DEVICE);
        message.put("callbackurl", UrlConfiguration.getAddDevCallbackUrl());

        startThread(message, UrlConfiguration.getDataSubscriptionUrl());
    }

    private void regDropDeviceUrl()
    {
        JSONObject message = new JSONObject();
        message.put("notifyType", CommonConst.NOTIFY_TYPE_DROP_DEVICE);
        message.put("callbackurl", UrlConfiguration.getDropDevCallbackUrl());

        startThread(message, UrlConfiguration.getDataSubscriptionUrl());
    }

    private void regUpdDeviceInfoUrl()
    {
        JSONObject message = new JSONObject();
        message.put("notifyType", CommonConst.NOTIFY_TYPE_UPDATE_DEVICEINFO);
        message.put("callbackurl", UrlConfiguration.getUpdDevInfoCallbackUrl());

        startThread(message, UrlConfiguration.getDataSubscriptionUrl());
    }

    private void regUpdSrvInfoUrl()
    {
        JSONObject message = new JSONObject();
        message.put("notifyType", CommonConst.NOTIFY_TYPE_UPDATE_SERVICEINFO);
        message.put("callbackurl", UrlConfiguration.getUpdSrvInfoCallbackUrl());

        startThread(message, UrlConfiguration.getDataSubscriptionUrl());
    }

    private void regUpdDeviceDataUrl()
    {
        JSONObject message = new JSONObject();
        message.put("notifyType", CommonConst.NOTIFY_TYPE_UPDATE_DEVICEDATA);
        message.put("callbackurl", UrlConfiguration.getUpdDevDataCallbackUrl());

        startThread(message, UrlConfiguration.getDataSubscriptionUrl());
    }

    private void regCmdConfirmUrl()
    {
        JSONObject message = new JSONObject();
        message.put("notifyType", CommonConst.NOTIFY_TYPE_MESSAGE_CONFIRM);
        message.put("callbackurl", UrlConfiguration.getCmdConfirmCallbackUrl());

        startThread(message, UrlConfiguration.getDataSubscriptionUrl());
    }

    private void regCmdRspUrl()
    {
        JSONObject message = new JSONObject();
        message.put("notifyType", CommonConst.NOTIFY_TYPE_COMMAND_RSP);
        message.put("callbackurl", UrlConfiguration.getCmdRspCallbackUrl());

        startThread(message, UrlConfiguration.getDataSubscriptionUrl());
    }

    private void regDeviceEventUrl()
    {
        JSONObject message = new JSONObject();
        message.put("notifyType", CommonConst.NOTIFY_TYPE_DEVICE_EVENT);
        message.put("callbackurl", UrlConfiguration.getDeviceEventCallbackUrl());

        startThread(message, UrlConfiguration.getDataSubscriptionUrl());
    }

}
