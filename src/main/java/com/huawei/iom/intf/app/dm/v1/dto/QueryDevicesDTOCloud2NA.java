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

import com.huawei.iom.intf.common.PageDTO;

/**
 * simple introduction
 *
 * <p>detailed comment
 * @author g00345683 Create on 2015年11月17日
 * @see
 * @since 1.0.0
 */
public class QueryDevicesDTOCloud2NA extends PageDTO
{
    @Valid
    @NotNull
    private List<QueryDeviceDTOCloud2NA> devices;

    public List<QueryDeviceDTOCloud2NA> getDevices()
    {
        return devices;
    }

    public void setDevices(List<QueryDeviceDTOCloud2NA> devices)
    {
        this.devices = devices;
    }

    @Override
    public String toString()
    {
        return "QueryDevicesDTOCloud2NA [devices=" + devices
                + ", totalCount=" + getTotalCount() + ", pageNo()="
                + getPageNo() + ", pageSize=" + getPageSize() + "]";
    }

}
