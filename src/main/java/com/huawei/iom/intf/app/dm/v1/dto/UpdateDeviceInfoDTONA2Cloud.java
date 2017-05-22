/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
/*
 * File Name: com.huawei.iom.iocm.app.data.v1.dto.ModifyDeviceDTONA2Cloud.java
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
package com.huawei.iom.intf.app.dm.v1.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.huawei.iom.component.util.StringUtil;

/**
 * simple introduction
 *
 * <p>
 * detailed comment
 * 
 * @author g00345683 Create on 2015年11月22日
 * @see
 * @since 1.0.0
 */
public class UpdateDeviceInfoDTONA2Cloud {
    // method = PUT
    public static final String URL = "/iocm/app/dm/v1.1.0/devices/{deviceId}";

    @Size(min = 1, max = 256)
    private String name;

    @Size(min = 1, max = 256)
    private String endUser;

    @Pattern(regexp = "(TRUE|FALSE)")
    private String mute;

    public static String getURLForNA(String deviceId) {
        return URL.replace("{deviceId}", deviceId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndUser() {
        return endUser;
    }

    public void setEndUser(String endUser) {
        this.endUser = endUser;
    }

    public String getMute() {
        return mute;
    }

    public void setMute(String mute) {
        this.mute = mute;
    }
}
