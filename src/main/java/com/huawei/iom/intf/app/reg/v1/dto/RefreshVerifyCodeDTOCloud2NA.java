/*
 * File Name: com.huawei.iom.iocm.app.reg.v1.dto.RefreshVerifyCodeDTOCloud2NA.java
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
 * <p>
 * detailed comment
 * 
 * @author g00345683 Create on 2016年6月14日
 * @see
 * @since 1.0.0
 */
public class RefreshVerifyCodeDTOCloud2NA {

    @NotNull
    @Size(max = 256)
    private String verifyCode;

    private Integer timeout;

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public RefreshVerifyCodeDTOCloud2NA() {
        super();
    }

    public RefreshVerifyCodeDTOCloud2NA(String verifyCode, Integer timeout) {
        super();
        this.verifyCode = verifyCode;
        this.timeout = timeout;
    }
}
