/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
package com.huawei.iom.intf.dev.data.v1.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ServiceCommandResponse {  
    @Size(max=256)
    @NotNull
    private String responseName;
    
    @Valid
    private List<ServiceCommandPara> paras;
 
    public String getResponseName()
    {
        return responseName;
    }

    public void setResponseName(String responseName)
    {
        this.responseName = responseName;
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
    public String toString()
    {
        return "ServiceCommandResponse [responseName=" + responseName + ", paras=" + paras
                + "]";
    }
}
