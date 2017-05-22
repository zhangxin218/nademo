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
package com.huawei.iom.nademo.common.login;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huawei.iom.component.httpclient.exception.HttpRequestException;
import com.huawei.iom.component.httpclient.exception.HttpResponseException;
import com.huawei.iom.component.httpclient.util.HttpUtil;
import com.huawei.iom.component.util.JsonUtil;
import com.huawei.iom.intf.app.sec.v1.dto.AppLoginDTOCloud2NA;
import com.huawei.iom.nademo.common.url.UrlConfiguration;

public class AuthHttpClient {
    /**
     * 日志工具
     */
    private static final Logger log = LoggerFactory.getLogger(AuthHttpClient.class);

    private static final long SECOND_2_MILLIS = 1000L;
    
    public static final String TOKEN_MAP_KEY = "access_token";
    
    private static AuthHttpClient instance;
    
    private AppLoginDTOCloud2NA token;
    
    private long tokenExpiresTime = 0L;
    public String tokenValue = null;
    
    private long timeout = 3600 * SECOND_2_MILLIS;
    
    private static String key;
    
    private static String secret;
    
    public Map<String, Object> deviceMap = new HashMap<String, Object>();
    
    public List<String> messageList = new ArrayList<String>();
    
    private AuthHttpClient(){
        
    }
    
    public static synchronized AuthHttpClient getInstance(){
        if(instance == null){
            instance = new AuthHttpClient();
        }
        return instance;
    }
    
    /**
     * 验证token是否合法
     *
     * @return
     */
    private boolean isValidToken()
    {
        if (token == null)
        {
            return false;
        }
        long currTime = System.currentTimeMillis();

        if (tokenExpiresTime < (currTime + timeout))
        {
            return false;
        }

        return true;
    }
    
    public String getAccessToken(){
        if (isValidToken())
        {
            tokenValue = token.getAccessToken();
            return tokenValue;
        }

        if (!getNewToken())
        {
            tokenValue = token.getAccessToken();
            return tokenValue;
        }

        log.error("Got invalid accessToken for AppId {}", getKey());
        return null;
    }
    
    /**
     * 重新获取一个新的token
     *
     * @return true 获取成功, false 获取失败
     */
    private boolean getNewToken()
    {
        try
        {
            token = executeHttpRequest();
        }
        catch (Exception e)
        {
            log.error("getNewToken failed.", e);
            token = null;
            tokenExpiresTime = 0;
            return false;
        }

        tokenExpiresTime = System.currentTimeMillis() + token.getExpiresIn() * SECOND_2_MILLIS;
        return true;
    }
    
    public Map<String, String> getAuthHeader(){
        Map<String, String> header = new HashMap<>();
        header.put("app_key", getKey());
        header.put("Authorization", "Bearer " + getAccessToken());

        return header;
    }
    
    /**
     * 向平台发送http请求，获取token
     *
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    private AppLoginDTOCloud2NA executeHttpRequest()
            throws IOException, URISyntaxException, HttpRequestException, HttpResponseException
    {
        String httpRequestUrl = UrlConfiguration.getLoginUrl();

        Map<String, String> param = new HashMap<String, String>();
        param.put("appId", getKey());
        param.put("secret", getSecret());
        
        String body =  HttpUtil.doPostFormUrlEncodedForString(httpRequestUrl, param);        

        AppLoginDTOCloud2NA response = JsonUtil.jsonString2SimpleObj(body, AppLoginDTOCloud2NA.class);

        return response;
    }

    public static String getKey() {
        return key;
    }

    public void setKey(String key) {
        AuthHttpClient.key = key;
    }

    public static String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        AuthHttpClient.secret = secret;
    }

}
