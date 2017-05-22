/*$$$!!Warning: Huawei key information asset. No spread without permission.$$$*/
/*CODEMARK:#*/
/*$$$!!Warning: Deleting or modifying the preceding information is prohibited.$$$*/
package com.huawei.iom.intf.app.event.v1.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.huawei.iom.component.util.StringUtil;
import com.huawei.iom.intf.app.sub.v1.dto.NotifyDTOCloud2NA;

public class DeviceReportEventNotifyDTOCloud2NA extends NotifyDTOCloud2NA{
	private Header header;
	
	private ObjectNode body;
	
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	public ObjectNode getBody() {
		return body;
	}
	public void setBody(ObjectNode body) {
		this.body = body;
	}
	
	@Override
	public String toString() {
		return "EventNotifyDTOCloud2NA [header=" + header.toString() + ", body=" + body
				+ ", getNotifyType()=" + getNotifyType() + "]";
	}
	
	public class Header {
		@Size(max=32)
	    @NotNull
	    private String eventType;
	    
	    @Size(max=128)
	    @NotNull
	    private String from;
	 
		@Size(max=32)
	    @NotNull
	    private String timestamp;
	    
		@Size(max=32)
	    @NotNull
	    private String eventTime;
	    
	    @NotNull
	    private String deviceId;
	    
	    @NotNull
	    private String serviceType;  
	    
		public String getEventType() {
			return eventType;
		}

		public void setEventType(String eventType) {
			this.eventType = eventType;
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

		public String getEventTime() {
			return eventTime;
		}

		public void setEventTime(String eventTime) {
			this.eventTime = eventTime;
		}

		public String getDeviceId() {
			return deviceId;
		}

		public void setDeviceId(String deviceId) {
			this.deviceId = deviceId;
		}

		public String getServiceType() {
			return serviceType;
		}

		public void setServiceType(String serviceType) {
			this.serviceType = serviceType;
		}
	}
}
