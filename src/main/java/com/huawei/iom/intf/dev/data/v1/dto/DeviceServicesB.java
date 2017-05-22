/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
/*
 * File Name: com.huawei.iom.iocm.dev.data.v1.dto.DeviceServicesB.java
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
package com.huawei.iom.intf.dev.data.v1.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.huawei.iom.component.util.StringUtil;

/**
 * simple introduction
 *
 * <p>detailed comment
 * @author g00345683 Create on 2015年12月17日
 * @see
 * @since 1.0.0
 */
public class DeviceServicesB
{
    @Size(max=256)
    @NotNull
    private String deviceId;
    
    @Valid
    List<DeviceServiceA> addedServices;
    
    @Valid
    List<DeviceServiceA> modifiedServices;
    
    @Valid  
    List<DeviceServiceA> deletedServices;

    public String getDeviceId()
    {
        return deviceId;
    }

    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }

    public List<DeviceServiceA> getAddedServices()
    {
        return addedServices;
    }

    public void setAddedServices(List<DeviceServiceA> addedServices)
    {
        this.addedServices = addedServices;
    }

    public List<DeviceServiceA> getModifiedServices()
    {
        return modifiedServices;
    }

    public void setModifiedServices(List<DeviceServiceA> modifiedServices)
    {
        this.modifiedServices = modifiedServices;
    }

    public List<DeviceServiceA> getDeletedServices()
    {
        return deletedServices;
    }

    public void setDeletedServices(List<DeviceServiceA> deletedServices)
    {
        this.deletedServices = deletedServices;
    }
}
