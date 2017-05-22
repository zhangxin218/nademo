/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
package com.huawei.iom.intf.app.signaltrans.v1.dto;

public class CommandCloud2DeviceHeader {
	String method;
	String from;
	String to;
	String requestId;
	String replyToTopic;
	String timestamp;
	String msghdl;
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
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
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getReplyToTopic() {
		return replyToTopic;
	}
	public void setReplyToTopic(String replyToTopic) {
		this.replyToTopic = replyToTopic;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getMsghdl() {
		return msghdl;
	}
	public void setMsghdl(String msghdl) {
		this.msghdl = msghdl;
	}
	@Override
	public String toString() {
		return "CommandCloud2DeviceHeader [method=" + method + ", from=" + from
				+ ", to=" + to + ", requestId=" + requestId + ", replyToTopic="
				+ replyToTopic + ", timestamp=" + timestamp + ", msghdl="
				+ msghdl + "]";
	}
}
