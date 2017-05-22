/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
/*
 * File Name: com.huawei.iom.iocm.app.data.v1.dto.DeviceCapabilityDTO.java
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
package com.huawei.iom.intf.app.data.v1.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.huawei.iom.component.util.StringUtil;

/**
 * simple introduction
 *
 * <p>detailed comment
 * @author g00345683 Create on 2015年12月14日
 * @see
 * @since 1.0.0
 */
public class DeviceCapabilityDTO
{
    @Size(max=256)
    @NotNull
    private String deviceId;
    
    @Valid
    private List<ServiceCapabilityDTO> serviceCapabilities;

    public String getDeviceId()
    {
        return deviceId;
    }

    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }

    public List<ServiceCapabilityDTO> getServiceCapabilities()
    {
        return serviceCapabilities;
    }

    public void setServiceCapabilities(
            List<ServiceCapabilityDTO> serviceCapabilities)
    {
        this.serviceCapabilities = serviceCapabilities;
    }
}
