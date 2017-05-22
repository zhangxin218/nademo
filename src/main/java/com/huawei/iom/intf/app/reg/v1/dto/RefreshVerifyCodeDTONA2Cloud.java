/*
 * File Name: com.huawei.iom.iocm.app.reg.v1.dto.RefreshVerifyCodeDTONA2Cloud.java
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

import javax.validation.constraints.Size;

import com.huawei.iom.component.util.StringUtil;

/**
 * simple introduction
 *
 * <p>
 * detailed comment
 * 
 * @author g00345683 Create on 2016年6月14日
 * @see
 * @since 1.0.0
 */
public class RefreshVerifyCodeDTONA2Cloud {

    @Size(max = 256)
    private String verifyCode;

    @Size(max = 256)
    private String nodeId;

    private Integer timeout;

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
    
    public RefreshVerifyCodeDTONA2Cloud() {
        super();
    }

    public RefreshVerifyCodeDTONA2Cloud(String verifyCode, String nodeId, Integer timeout) {
        super();
        this.verifyCode = verifyCode;
        this.nodeId = nodeId;
        this.timeout = timeout;
    }
}
