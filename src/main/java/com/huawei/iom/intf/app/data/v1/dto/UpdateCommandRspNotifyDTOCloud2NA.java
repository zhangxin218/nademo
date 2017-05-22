/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
/*
 * File Name: com.huawei.iom.iocm.app.data.v1.dto.UpdateDeviceCommandRspDTOCloud2NA.java
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

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.huawei.iom.component.util.StringUtil;
import com.huawei.iom.intf.app.sub.v1.dto.NotifyDTOCloud2NA;

import net.sf.json.JSONObject;

/**
 * simple introduction
 *
 * <p>detailed comment
 * @author g00345683 Create on 2015年12月18日
 * @see
 * @since 1.0.0
 */
public class UpdateCommandRspNotifyDTOCloud2NA extends NotifyDTOCloud2NA
{
    @Valid
    @NotNull
    private Header header;
    
    @NotNull
    private JSONObject body;
    
    public class Header
    {
        @Size(max=256)
        @NotNull
        private String requestId;  
        
        @Size(max=256)
        @NotNull
        private String from;
        
        @Size(max=256)
        @NotNull
        private String to;
        
        @Size(max=256)
        @NotNull
        private String deviceId;
        
        @Size(max=256)
        @NotNull
        private String serviceType;
        
        @Size(max=256)
        @NotNull
        private String method;
        
        public String getRequestId()
        {
            return requestId;
        }
        public void setRequestId(String requestId)
        {
            this.requestId = requestId;
        }
        public String getFrom()
        {
            return from;
        }
        public void setFrom(String from)
        {
            this.from = from;
        }
        public String getTo()
        {
            return to;
        }
        public void setTo(String to)
        {
            this.to = to;
        }
        public String getDeviceId()
        {
            return deviceId;
        }
        public void setDeviceId(String deviceId)
        {
            this.deviceId = deviceId;
        }
        public String getServiceType()
        {
            return serviceType;
        }
        public void setServiceType(String serviceType)
        {
            this.serviceType = serviceType;
        }
        public String getMethod()
        {
            return method;
        }
        public void setMethod(String method)
        {
            this.method = method;
        }
     
    }

    public Header getHeader()
    {
        return header;
    }

    public void setHeader(Header header)
    {
        this.header = header;
    }

    public JSONObject getBody()
    {
        return body;
    }

    public void setBody(JSONObject body)
    {
        this.body = body;
    }

    @Override
    public String toString()
    {
        return "UpdateCommandRspNotifyDTOCloud2NA [header=" + header + ", body="
                + body + ", notifyType()=" + getNotifyType() + "]";
    }    
}
