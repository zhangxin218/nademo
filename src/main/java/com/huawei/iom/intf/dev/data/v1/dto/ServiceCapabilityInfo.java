/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
/*
 * File Name: com.huawei.m2m.nscl.modules.device.ServiceProperty.java
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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ServiceCapabilityInfo {
    @Size(max=256)
    @NotNull
    private String serviceId;
    
    @Size(max=256)
    @NotNull
    private String serviceType;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ServiceCapabilityInfo [serviceId=");
        builder.append(serviceId);
        builder.append(", serviceType=");
        builder.append(serviceType);
        builder.append("]");
        return builder.toString();
    }
}
