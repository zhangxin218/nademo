/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
package com.huawei.iom.intf.app.signaltrans.v1.dto;

import net.sf.json.JSONObject;

public class CommandDTOCloud2NAReply {
	String notifyType;
	CommandCloud2NAReplyHeader header;
	JSONObject body;
	public String getNotifyType() {
		return notifyType;
	}
	public void setNotifyType(String notifyType) {
		this.notifyType = notifyType;
	}
	public CommandCloud2NAReplyHeader getHeader() {
		return header;
	}
	public void setHeader(CommandCloud2NAReplyHeader header) {
		this.header = header;
	}
	public JSONObject getBody() {
		return body;
	}
	public void setBody(JSONObject body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "CommandDTOCloud2NAReply [notifyType=" + notifyType
				+ ", header=" + header + ", body=" + body + "]";
	}

}
