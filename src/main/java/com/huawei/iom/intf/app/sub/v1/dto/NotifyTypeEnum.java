/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
/*
 * File Name: com.huawei.iom.iocm.app.sub.v1.dto.NotifyTypeEnum.java
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
package com.huawei.iom.intf.app.sub.v1.dto;

/**
 * simple introduction
 *
 * <p>
 * detailed comment
 * @author l00194214 Create on 2015年12月1日
 * @see
 * @since 1.0.0
 */
public enum NotifyTypeEnum 
{
    //规则事件
    RULE_EVENT(NotifyDTOCloud2NA.RULE_EVENT),
    
    BIND_DEVICE(NotifyDTOCloud2NA.BIND_DEVICE),
    SERVICE_INFO_CHANGED(NotifyDTOCloud2NA.SERVICE_INFO_CHANGED),
    DEVICE_INFO_CHANGED(NotifyDTOCloud2NA.DEVICE_INFO_CHANGED),
    DEVICE_DATA_CHANGED(NotifyDTOCloud2NA.DEVICE_DATA_CHANGED),
    DEVICE_ADDED(NotifyDTOCloud2NA.DEVICE_ADDED),
    DEVICE_DELETED(NotifyDTOCloud2NA.DEVICE_DELETED),
    MESSAGE_CONFIRM(NotifyDTOCloud2NA.MESSAGE_CONFIRM),
    COMMAND_RSP(NotifyDTOCloud2NA.COMMAND_RSP),
    DEVICE_EVENT(NotifyDTOCloud2NA.DEVICE_EVENT),
    APP_DELETED(NotifyDTOCloud2NA.APP_DELETED);
    
    private String value;
    
    NotifyTypeEnum(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}
