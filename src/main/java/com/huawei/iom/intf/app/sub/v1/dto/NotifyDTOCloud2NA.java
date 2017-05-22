/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
/*
 * File Name: com.huawei.iom.component.interfaceDTO.DeviceInfoSubDTO.java
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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * simple introduction
 *
 * <p>detailed comment
 * @author g00345683 Create on 2015年11月17日
 * @see
 * @since 1.0.0
 */
public abstract class NotifyDTOCloud2NA
{
    public static final String BIND_DEVICE = "bindDevice";
    
    public static final String SERVICE_INFO_CHANGED = "serviceInfoChanged";
    
    public static final String DEVICE_INFO_CHANGED = "deviceInfoChanged";
    
    public static final String DEVICE_DATA_CHANGED = "deviceDataChanged";
    
    public static final String DEVICE_ADDED = "deviceAdded";
    
    public static final String DEVICE_DELETED = "deviceDeleted";
    
    public static final String MESSAGE_CONFIRM = "messageConfirm";
    
    public static final String COMMAND_RSP = "commandRsp";
    
    public static final String DEVICE_EVENT = "deviceEvent";
    
    public static final String APP_DELETED = "appDeleted";
    
    //规则事件
    public static final String RULE_EVENT = "ruleEvent";
    
    @Pattern(regexp = "(appDeleted|serviceInfoChanged|deviceInfoChanged|deviceDataChanged|deviceAdded|deviceDeleted|bindDevice|messageConfirm|commandRsp|deviceEvent|ruleEvent)")   
    @NotNull
    private String notifyType;
    
    public String getNotifyType()
    {
        return notifyType;
    }

    public void setNotifyType(String notifyType)
    {
        this.notifyType = notifyType;
    }

    @Override
    public String toString()
    {
        return "NotifyDTOCloud2NA [notifyType=" + notifyType + "]";
    }    
}
