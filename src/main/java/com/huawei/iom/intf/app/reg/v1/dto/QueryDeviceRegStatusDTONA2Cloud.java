/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
/*
 * File Name: com.huawei.iom.iocm.app.data.dto.QueryDeviceActiveDTOCloud2NA.java
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

/**
 * simple introduction
 *
 * <p>detailed comment
 * @author g00345683 Create on 2015年11月21日
 * @see
 * @since 1.0.0
 */
public class QueryDeviceRegStatusDTONA2Cloud
{
    //method = GET
    public static final String URL = "/iocm/app/reg/v1.1.0/devices/{deviceId}";
    
    public static String getURLForNA(String deviceId)
    {
        return URL.replace("{deviceId}", deviceId);
    }
}
