/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
/*
 * File Name: com.huawei.iom.component.interfaceDTO.DeviceDropCloud2NA.java
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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.huawei.iom.component.util.StringUtil;
import com.huawei.iom.intf.app.sub.v1.dto.NotifyDTOCloud2NA;

/**
 * simple introduction
 *
 * <p>detailed comment
 * @author g00345683 Create on 2015年11月18日
 * @see
 * @since 1.0.0
 */
public class DeleteDeviceNotifyDTOCloud2NA extends NotifyDTOCloud2NA
{
    @Size(max=256)
    @NotNull
    private String deviceId;
    
    @Size(max=256)
    private String gatewayId;

    public DeleteDeviceNotifyDTOCloud2NA(String deviceId, String gatewayId) {
        super();
        this.deviceId = deviceId;
        this.gatewayId = gatewayId;
    }

    public DeleteDeviceNotifyDTOCloud2NA() {
        // TODO Auto-generated constructor stub
        super();
    }

    public String getDeviceId()
    {
        return deviceId;
    }

    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }
   
    public String getGatewayId()
    {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId)
    {
        this.gatewayId = gatewayId;
    }

}
