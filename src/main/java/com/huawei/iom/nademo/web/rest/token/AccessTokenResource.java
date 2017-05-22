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
package com.huawei.iom.nademo.web.rest.token;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei.iom.nademo.common.login.AuthHttpClient;
import com.huawei.iom.nademo.common.url.RegisterUrlInit;
import com.huawei.iom.nademo.common.url.UrlConfiguration;
import com.huawei.iom.nademo.service.config.ConfigService;

@Controller
public class AccessTokenResource {

    private static final Logger log = LoggerFactory.getLogger(AccessTokenResource.class);
    
    @Autowired
    private ConfigService ConfigService;
    
    @RequestMapping(value = "/appdemo/portal/v1.0/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> accessTokenFromPortal(
            @RequestParam(value = "username", required = true) String clientId,
            @RequestParam(value = "password", required = true) String clientSecret, 
            HttpServletRequest request) {

    	// set platform IP and port
        UrlConfiguration.setIotIp(ConfigService.getIotServerIp());
        UrlConfiguration.setIotPort(ConfigService.getIotServerPort());
        
        //set NADemo IP and port
        UrlConfiguration.setNaAddressIp(request.getServerName());
        UrlConfiguration.setNaAddressPort(String.valueOf(request.getServerPort()));

        // get auth token
        AuthHttpClient authHttpClient = AuthHttpClient.getInstance();
        authHttpClient.setKey(clientId);
        authHttpClient.setSecret(clientSecret);
        authHttpClient.getAccessToken();
        log.info("access token: " + authHttpClient.tokenValue);

        //subscribe to notifications from IoT Platform
        RegisterUrlInit registerUrlInit = new RegisterUrlInit();
        registerUrlInit.init();

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/appdemo/portal/v1.0/checkAuth", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HttpStatus> checkAuth(){
        AuthHttpClient authHttpClient = AuthHttpClient.getInstance();
        
        try {
            authHttpClient.getAccessToken();
        } catch (Exception e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        log.info("access token"+authHttpClient.tokenValue);
        
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
    
    
}
