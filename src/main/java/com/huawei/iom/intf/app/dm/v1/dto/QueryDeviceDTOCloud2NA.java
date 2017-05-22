/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
/*
 * File Name: com.huawei.iom.component.interfaceDTO.DeviceQueryNA2Cloud.java
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

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.huawei.iom.component.util.StringUtil;
import com.huawei.iom.intf.dev.data.v1.dto.DeviceInfo;
import com.huawei.iom.intf.dev.data.v1.dto.DeviceService;

/**
 * simple introduction
 *
 * <p>detailed comment
 * @author g00345683 Create on 2015年11月17日
 * @see
 * @since 1.0.0
 */
public class QueryDeviceDTOCloud2NA
{
    @Size(max=256)
    @NotNull
    private String deviceId;
        
    @Size(max=256)
    private String gatewayId;
    
    @Pattern(regexp = "(ENDPOINT|GATEWAY|UNKNOWN)")
    @NotNull
    private String nodeType;
    
    @Size(max=256)
    @NotNull
    private String createTime;
    
    @Size(max=256)
    @NotNull
    private String lastModifiedTime;
    
    @Valid
    @NotNull
    private DeviceInfo deviceInfo;
    
    @Valid
    private List<DeviceService> services;   
    
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
    
    public String getNodeType()
    {
        return nodeType;
    }

    public void setNodeType(String nodeType)
    {
        this.nodeType = nodeType;
    }

    public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(String lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public DeviceInfo getDeviceInfo()
    {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo)
    {
        this.deviceInfo = deviceInfo;
    }

    public List<DeviceService> getServices()
    {
        return services;
    }

    public void setServices(List<DeviceService> services)
    {
        this.services = services;
    }
    
    public QueryDeviceDTOCloud2NA()
    {}
    
    public QueryDeviceDTOCloud2NA(String deviceId, String gatewayId, String nodeType,
            DeviceInfo deviceInfo, List<DeviceService> services)
    {
        this.deviceId = deviceId;
        this.gatewayId = gatewayId;
        this.nodeType = nodeType;
        this.deviceInfo = deviceInfo;
        this.services = services;
    }
   
}
