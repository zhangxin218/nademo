/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
package com.huawei.iom.intf.app.signaltrans.v1.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EventHeaderNA2Cloud {
    
    @Size(max = 32)
    private String requestId;
    
    @NotNull
    @Size(max = 32)
    private String category;
    
    @NotNull
    @Size(max = 32)
    private String notifyType;

    @Pattern(regexp = "(NOACK|ACK)")
    private String mode;

    @Size(max = 128)
    private String from;

    @NotNull
    @Size(max = 32)
    private String timestamp;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EventHeaderNA2Cloud [requestId=");
        builder.append(requestId);
        builder.append(", category=");
        builder.append(category);
        builder.append(", notifyType=");
        builder.append(notifyType);
        builder.append(", mode=");
        builder.append(mode);
        builder.append(", from=");
        builder.append(from);
        builder.append(", timestamp=");
        builder.append(timestamp);
        builder.append("]");
        return builder.toString();
    }

    
}
