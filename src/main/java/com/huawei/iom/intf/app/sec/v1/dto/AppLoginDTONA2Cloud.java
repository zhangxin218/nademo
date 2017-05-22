/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
/*
 * File Name: com.huawei.iom.iocm.dev.reg.v1.dto.LoginDeviceDTOGW2Cloud.java
 *
 * Copyright Notice:
 *      Copyright  1998-2008, Huawei Technologies Co., Ltd.  ALL Rights Reserved.
 *
 *      Warning: This computer software sourcecode is protected by copyright law
 *      and international treaties. Unauthorized reproduction or distribution
 *      of this sourcecode, or any portion of it, may result in severe civil and
 *      criminal penalties, and will be prosecuted to the maximum extent
 *      possible under the law.
 */
package com.huawei.iom.intf.app.sec.v1.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.huawei.iom.component.util.StringUtil;

/**
 * simple introduction
 *
 * <p>
 * detailed comment
 * 
 * @author z00364826 Create on 2016年6月2日
 * @see
 * @since 1.0.0
 */
public class AppLoginDTONA2Cloud {
    // method = POST
    public static final String URL = "/iocm/app/sec/v1.1.0/login";

    @Size(max = 256)
    @NotNull
    private String appId;

    @Size(max = 256)
    @NotNull
    private String secret;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public static String getUrl() {
        return URL;
    }

}
