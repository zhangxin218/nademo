/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
/*
 * File Name: com.huawei.iom.iocm.dev.sec.v1.dto.DebiceLogoutDTOGW2Cloud.java
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

/**
 * simple introduction
 *
 * <p>
 * detailed comment
 * 
 * @author l00194214 Create on 2016年1月8日
 * @see
 * @since 1.0.0
 */
public class AppLogoutDTONA2Cloud {

    @Size(max = 256)
    @NotNull
    private String accessToken;
    
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
