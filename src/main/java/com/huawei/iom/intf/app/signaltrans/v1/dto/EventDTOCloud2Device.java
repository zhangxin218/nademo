/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
package com.huawei.iom.intf.app.signaltrans.v1.dto;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class EventDTOCloud2Device {
    
    private EventHeaderCloud2Device header;

    private List<ObjectNode> body;
    
    public EventHeaderCloud2Device getHeader() {
        return header;
    }
    
    public void setHeader(EventHeaderCloud2Device header) {
        this.header = header;
    }
    
    public List<ObjectNode> getBody() {
        return body;
    }
    
    public void setBody(List<ObjectNode> body) {
        this.body = body;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EventDTOCloud2Device [header=");
        builder.append(header);
        builder.append(", body=");
        builder.append(body);
        builder.append("]");
        return builder.toString();
    }

}
