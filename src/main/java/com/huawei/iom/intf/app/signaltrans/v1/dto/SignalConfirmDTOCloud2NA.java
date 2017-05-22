/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
/*
 * File Name: com.huawei.iom.iocm.app.signaltrans.v1.dto.SignalConfirmCloud2NA.java
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
package com.huawei.iom.intf.app.signaltrans.v1.dto;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.huawei.iom.intf.app.sub.v1.dto.NotifyDTOCloud2NA;

/**
 * 信令响应接口
 *
 * <p>detailed comment
 * @author l00194214 Create on 2015年11月27日
 * @see
 * @since 1.0.0
 */
public class SignalConfirmDTOCloud2NA extends NotifyDTOCloud2NA
{
    /**
     * 信息响应头
     */
    private Header header;
    
    /**
     * 信令响应内容
     */
    private ObjectNode body;
    
    public Header getHeader()
    {
        return header;
    }

    public void setHeader(Header header)
    {
        this.header = header;
    }

    public ObjectNode getBody()
    {
        return body;
    }

    public void setBody(ObjectNode body)
    {
        this.body = body;
    }
    
    public static class Header
    {
        /**
         * 信令的序列号，唯一标识该消息
         */
        private String requestId;
        
        /**
         * 信令发布者的地址
         */
        private String from;
        
        /**
         * 信令接收者的地址
         */
        private String to;
        
        /**
         * 信令执行状态
         */
        private String status;
        
        /**
         * 时间戳
         */
        private String timestamp;

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

        public String getStatus()
        {
            return status;
        }

        public void setStatus(String status)
        {
            this.status = status;
        }

        public String getTimestamp()
        {
            return timestamp;
        }

        public void setTimestamp(String timestamp)
        {
            this.timestamp = timestamp;
        }
    }
}
