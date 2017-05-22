/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
/*
 * File Name: com.huawei.iom.iocm.app.reg.GetVerifyCodeDTONA2Cloud.java
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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.huawei.iom.component.util.StringUtil;

/**
 * simple introduction
 *
 * <p>detailed comment
 * @author g00345683 Create on 2015年11月19日
 * @see
 * @since 1.0.0
 */
public class AddDeviceDTONA2Cloud
{
    //method = POST
    public static final String URL = "/iocm/app/reg/v1.1.0/devices";

    @Size(max=256)
    private String verifyCode;
    
    @Size(max=256)
    @NotNull
    private String nodeId;
    
    @Size(max=256)
    private String endUserId;
    
    private Integer timeout;
    
    public String getVerifyCode()
    {
        return verifyCode;
    }


    public void setVerifyCode(String verifyCode)
    {
        this.verifyCode = verifyCode;
    }


    public String getNodeId()
    {
        return nodeId;
    }


    public void setNodeId(String nodeId)
    {
        this.nodeId = nodeId;
    }

    public String getEndUserId()
    {
        return endUserId;
    }


    public void setEndUserId(String endUserId)
    {
        this.endUserId = endUserId;
    }


    public Integer getTimeout()
    {
        return timeout;
    }


    public void setTimeout(Integer timeout)
    {
        this.timeout = timeout;
    }

}
