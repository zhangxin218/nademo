/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
/*
 * File Name: com.huawei.iom.iocm.app.data.v1.dto.QueryApplicationDTOCloud2Inner.java
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

import javax.validation.constraints.Size;

/**
 * simple introduction
 *
 * <p>detailed comment
 * @author g00345683 Create on 2016年1月8日
 * @see
 * @since 1.0.0
 */
public class QueryApplicationDTOCloud2Inner
{
    @Size(max=256)
    private String user;
    
    @Size(max=256)
    private String name;
    
    @Size(max=256)
    private String description;
    
    @Size(max=256)
    private String industry;
    
    @Size(max=256)
    private String status;

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getIndustry()
    {
        return industry;
    }

    public void setIndustry(String industry)
    {
        this.industry = industry;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "QueryApplicationDTOCloud2Inner [user=" + user + ", name=" + name
                + ", description=" + description + ", industry=" + industry
                + ", status=" + status + "]";
    }          
}
