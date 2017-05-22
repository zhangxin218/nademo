/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
package com.huawei.iom.intf.app.signaltrans.v1.dto;

import javax.validation.constraints.Size;

public class CommandDTODevice2CloudReply {

    @Size(max = 128)
    private String requestId;

    @Size(max = 128)
    private String status;

    @Size(max = 128)
    private String timeStamp;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "CommandDTODevice2CloudReply [requestId=" + requestId + ", status=" + status
                + ", timeStamp=" + timeStamp + "]";
    }
}
