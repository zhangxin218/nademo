/*
 * File Name: com.huawei.iom.iocm.app.dm.v1.dto.DeleteAppNotifyDTOCloud2Inner.java
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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.huawei.iom.component.util.StringUtil;
import com.huawei.iom.intf.app.sub.v1.dto.NotifyDTOCloud2NA;

/**
 * simple introduction
 *
 * <p>
 * detailed comment
 * 
 * @author yWX352533 Create on 2016年5月4日
 * @see
 * @since 1.0.0
 */
public class DeleteAppNotifyDTOCloud2Inner extends NotifyDTOCloud2NA {
    @Size(max = 256)
    @NotNull
    private String appId;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

}
