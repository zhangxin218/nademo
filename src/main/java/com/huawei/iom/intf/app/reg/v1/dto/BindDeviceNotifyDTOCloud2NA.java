/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
/*
 * File Name: com.huawei.iom.component.interfaceDTO.DeviceLoginInformCloud2NADTO.java
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
package com.huawei.iom.intf.app.reg.v1.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.huawei.iom.component.util.StringUtil;
import com.huawei.iom.intf.app.sub.v1.dto.NotifyDTOCloud2NA;
import com.huawei.iom.intf.dev.data.v1.dto.DeviceInfo;

/**
 * simple introduction
 *
 * <p>detailed comment
 * @author g00345683 Create on 2015年11月17日
 * @see
 * @since 1.0.0
 */
public class BindDeviceNotifyDTOCloud2NA extends NotifyDTOCloud2NA
{
    
    public static final String EXPIRED = "expired";
    
    public static final String SUCCEEDED = "succeeded";
    
    @Size(max=256)
    @NotNull
    private String deviceId;
    
    @Pattern(regexp = "(expired|succeeded)")
    @NotNull
    private String resultCode;
    
    @Valid
    @NotNull
    private DeviceInfo deviceInfo;

    public String getDeviceId()
    {
        return deviceId;
    }

    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }

    public String getResultCode()
    {
        return resultCode;
    }

    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }

    public DeviceInfo getDeviceInfo()
    {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo)
    {
        this.deviceInfo = deviceInfo;
    }
}
