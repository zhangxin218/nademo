/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
/*
 * File Name: com.huawei.m2m.nscl.modules.device.ServiceCommand.java
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

import javax.validation.Valid;
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
public class ServiceCommand 
{  
    @Size(max=256)
    @NotNull
    private String commandName;
    
    @Valid
    private List<ServiceCommandPara> paras;
    
    @Valid
    private List<ServiceCommandResponse> responses;
 
    public List<ServiceCommandResponse> getResponses() {
		return responses;
	}

	public void setResponses(List<ServiceCommandResponse> responses) {
		this.responses = responses;
	}

	public String getCommandName()
    {
        return commandName;
    }

    public void setCommandName(String commandName)
    {
        this.commandName = commandName;
    }

    public List<ServiceCommandPara> getParas()
    {
        return paras;
    }

    public void setParas(List<ServiceCommandPara> paras)
    {
        this.paras = paras;
    }

    @Override
	public String toString() {
		return "ServiceCommand [commandName=" + commandName + ", paras="
				+ paras + ", responses=" + responses + "]";
	}
}
