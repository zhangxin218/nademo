/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
package com.huawei.iom.intf.app.signaltrans.v1.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import net.sf.json.JSONObject;

public class CommandDTONA2Cloud {

    @Valid
    @NotNull
    CommandNA2CloudHeader header;
    
    JSONObject body;

    public JSONObject getBody() {
        return body;
    }

    public void setBody(JSONObject body) {
        this.body = body;
    }

    public CommandNA2CloudHeader getHeader() {
        return header;
    }

    public void setHeader(CommandNA2CloudHeader header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return "CommandDTONA2Cloud [header=" + header + "]";
    }
}
