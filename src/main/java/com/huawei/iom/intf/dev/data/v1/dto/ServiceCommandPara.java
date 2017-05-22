/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
/*
 * File Name: com.huawei.m2m.nscl.modules.service.ServiceCommandPara.java
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
package com.huawei.iom.intf.dev.data.v1.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * simple introduction
 *
 * <p>detailed comment
 * @author g00345683 Create on 2015年11月14日
 * @see
 * @since 1.0.0
 */
public class ServiceCommandPara
{
    @Size(max=256)
    @NotNull
    private String paraName;
    
    @Size(max=256)
    @NotNull
    private String dataType;
    
    private boolean required;
    
    private String min;
    
    private String max;
    
    private double step;
    
    private int maxLength;    
    
    private String unit;
    
    private List<String> enumList;

    public String getParaName()
    {
        return paraName;
    }

    public void setParaName(String paraName)
    {
        this.paraName = paraName;
    }

    public String getDataType()
    {
        return dataType;
    }

    public void setDataType(String dataType)
    {
        this.dataType = dataType;
    }

    public boolean isRequired()
    {
        return required;
    }

    public void setRequired(boolean required)
    {
        this.required = required;
    }

    public String getMin()
    {
        return min;
    }

    public void setMin(String min)
    {
        this.min = min;
    }

    public String getMax()
    {
        return max;
    }

    public void setMax(String max)
    {
        this.max = max;
    }

    public double getStep()
    {
        return step;
    }

    public void setStep(double step)
    {
        this.step = step;
    }

    public int getMaxLength()
    {
        return maxLength;
    }

    public void setMaxLength(int maxLength)
    {
        this.maxLength = maxLength;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public List<String> getEnumList()
    {
        return enumList;
    }

    public void setEnumList(List<String> enumList)
    {
        this.enumList = enumList;
    }

    @Override
    public String toString()
    {
        return "ServiceCommandPara [paraName=" + paraName + ", dataType="
                + dataType + ", required=" + required + ", min=" + min
                + ", max=" + max + ", step=" + step + ", maxLength=" + maxLength
                + ", unit=" + unit + ", enumList=" + enumList + "]";
    }    
}
