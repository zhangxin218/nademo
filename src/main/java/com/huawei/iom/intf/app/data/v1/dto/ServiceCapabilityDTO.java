/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
/*
 * File Name: com.huawei.iom.iocm.app.data.v1.dto.deviceServiceCapability.java
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

import com.huawei.iom.intf.dev.data.v1.dto.ServiceCommand;
import com.huawei.iom.intf.dev.data.v1.dto.ServiceProperty;

/**
 * simple introduction
 *
 * <p>detailed comment
 * @author g00345683 Create on 2015年12月14日
 * @see
 * @since 1.0.0
 */
public class ServiceCapabilityDTO
{
    @Size(max=256)
    @NotNull
    private String serviceId;
    
    @Size(max=256)
    @NotNull
    private String serviceType;
    
    @Size(max=256)
    private String option;
    
    @Size(max=10240)
    private String description;
    
    @Valid
    private List<ServiceCommand> commands;
    
    @Valid
    private List<ServiceProperty> properties;

    public String getServiceId()
    {
        return serviceId;
    }

    public void setServiceId(String serviceId)
    {
        this.serviceId = serviceId;
    }

    public String getServiceType()
    {
        return serviceType;
    }

    public void setServiceType(String serviceType)
    {
        this.serviceType = serviceType;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public List<ServiceCommand> getCommands()
    {
        return commands;
    }

    public void setCommands(List<ServiceCommand> commands)
    {
        this.commands = commands;
    }

    public List<ServiceProperty> getProperties()
    {
        return properties;
    }

    public void setProperties(List<ServiceProperty> properties)
    {
        this.properties = properties;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ServiceCapabilityDTO [serviceId=");
        builder.append(serviceId);
        builder.append(", serviceType=");
        builder.append(serviceType);
        builder.append(", option=");
        builder.append(option);
        builder.append(", description=");
        builder.append(description);
        builder.append(", commands=");
        builder.append(commands);
        builder.append(", properties=");
        builder.append(properties);
        builder.append("]");
        return builder.toString();
    }
}
