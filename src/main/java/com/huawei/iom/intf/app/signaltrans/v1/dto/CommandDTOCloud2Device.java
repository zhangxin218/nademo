/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
package com.huawei.iom.intf.app.signaltrans.v1.dto;

import net.sf.json.JSONObject;

public class CommandDTOCloud2Device {
	CommandCloud2DeviceHeader header;

	JSONObject body;
	public CommandCloud2DeviceHeader getHeader() {
		return header;
	}
	public void setHeader(CommandCloud2DeviceHeader header) {
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
		return "CommandDTOCloud2Device [header="
				+ header + ", body=" + body + "]";
	}

}
