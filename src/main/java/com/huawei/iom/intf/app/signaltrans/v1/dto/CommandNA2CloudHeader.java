/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
package com.huawei.iom.intf.app.signaltrans.v1.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CommandNA2CloudHeader {

    @NotNull
    @Pattern(regexp = "(ACK|NOACK)")
    private String mode;

    @Size(max = 128)
    private String from;

    @Size(max = 128)
    private String to;

    @Pattern(regexp = "(CLOUD|GATEWAY)")
    private String toType;

    @NotNull
    @Size(max = 32)
    private String method;

    @Size(max = 128)
    private String requestId;

    @Size(max = 1024)
    private String callbackURL;

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

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getToType() {
        return toType;
    }

    public void setToType(String toType) {
        this.toType = toType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCallbackURL() {
        return callbackURL;
    }

    public void setCallbackURL(String callbackURL) {
        this.callbackURL = callbackURL;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CommandNA2CloudHeader [mode=");
        builder.append(mode);
        builder.append(", from=");
        builder.append(from);
        builder.append(", to=");
        builder.append(to);
        builder.append(", toType=");
        builder.append(toType);
        builder.append(", method=");
        builder.append(method);
        builder.append(", requestId=");
        builder.append(requestId);
        builder.append(", callbackURL=");
        builder.append(callbackURL);
        builder.append("]");
        return builder.toString();
    }
}
