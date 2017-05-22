/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
package com.huawei.iom.intf.app.signaltrans.v1.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class EventDTONA2Cloud {

    @Valid
    @NotNull
    private EventHeaderNA2Cloud header;

    @NotNull
    private List<ObjectNode> body;

    public List<ObjectNode> getBody() {
        return body;
    }

    public void setBody(List<ObjectNode> body) {
        this.body = body;
    }

    public EventHeaderNA2Cloud getHeader() {
        return header;
    }

    public void setHeader(EventHeaderNA2Cloud header) {
        this.header = header;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EventDTONA2Cloud [header=");
        builder.append(header);
        builder.append(", body=");
        builder.append(body);
        builder.append("]");
        return builder.toString();
    }
}
