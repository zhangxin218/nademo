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
import javax.validation.constraints.Size;

/**
 * simple introduction
 *
 * <p>detailed comment
 * @author g00345683 Create on 2015年11月17日
 * @see
 * @since 1.0.0
 */
public class SubscribeDTONA2Cloud
{
    //method = POST, for outer service through API Server, for example SmartHome NA
    public static final String URL = "/iocm/app/sub/v1.1.0/subscribe";
    
    //method = POST, for inner service, for example IoDM, IoBS
    public static final String URL_INNER = "/iocm/inner/sub/v1.1.0/subscribe";
    
    //inner service must add a "AppAuth.X_APP_KEY" header to indicate itself
    //for example IoDM may a "AppAuth.X_APP_KEY" header with a value "iodm"
    
    @Pattern(regexp = "(appDeleted|serviceInfoChanged|deviceInfoChanged|deviceDataChanged|deviceAdded|deviceDeleted|bindDevice|messageConfirm|commandRsp|deviceEvent|ruleEvent)")
    @NotNull
    private String notifyType;
    
    @Size(max=1024)
    @NotNull
    private String callbackurl;
    
    public String getNotifyType()
    {
        return notifyType;
    }

    public void setNotifyType(String notifyType)
    {
        this.notifyType = notifyType;
    }

    public String getCallbackurl()
    {
        return callbackurl;
    }

    public void setCallbackurl(String callbackurl)
    {
        this.callbackurl = callbackurl;
    }

    public static String getURLForNA()
    {
        return URL;
    }
    
    @Override
    public String toString()
    {
        return "SubscribeDTONA2Cloud [notifyType=" + notifyType
                + ", callbackurl=" + callbackurl + "]";
    }    
}
