/*
 * File Name: com.huawei.m2m.nscl.web.rest.device.DeviceResource.java
 *
 * Copyright Notice:
 *      Copyright  1998-2008, Huawei Technologies Co., Ltd.  ALL Rights Reserved.
 *
 *      Warning: This computer software sourcecode is protected by copyright law
 *      and international treaties. Unauthorized reproduction or distribution
 *      of this sourcecode, or any portion of it, may result in severe civil and
 *      criminal penalties, and will be prosecuted to the maximum extent
 *      possible under the law.
 */
package com.huawei.iom.nademo.web.rest.subcribe;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.huawei.iom.component.util.JsonUtil;
import com.huawei.iom.intf.app.data.v1.dto.UpdateCommandRspNotifyDTOCloud2NA;
import com.huawei.iom.intf.app.data.v1.dto.UpdateDeviceDataNotifyDTOCloud2NA;
import com.huawei.iom.intf.app.dm.v1.dto.AddDeviceNotifyDTOCloud2NA;
import com.huawei.iom.intf.app.dm.v1.dto.DeleteDeviceNotifyDTOCloud2NA;
import com.huawei.iom.intf.app.dm.v1.dto.UpdateDeviceInfoNotifyDTOCloud2NA;
import com.huawei.iom.intf.app.dm.v1.dto.UpdateServiceInfoNotifyDTOCloud2NA;
import com.huawei.iom.intf.app.event.v1.dto.DeviceReportEventNotifyDTOCloud2NA;
import com.huawei.iom.intf.app.reg.v1.dto.BindDeviceNotifyDTOCloud2NA;
import com.huawei.iom.intf.app.signaltrans.v1.dto.SignalConfirmDTOCloud2NA;
import com.huawei.iom.intf.app.sub.v1.dto.NotifyDTOCloud2NA;
import com.huawei.iom.nademo.common.login.AuthHttpClient;
import com.huawei.iom.nademo.common.url.UrlConfiguration;
import com.huawei.iom.nademo.util.ProtalMessageUtil;

@Controller
public class SubscribeNotifyResource {
    private static final Logger log = LoggerFactory.getLogger(SubscribeNotifyResource.class);
    
    @RequestMapping(value = UrlConfiguration.NSCL_ACTIVE_DEVICE_CALLBACK, method = RequestMethod.POST, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> recvActiveDeviceNotify(
            @RequestBody BindDeviceNotifyDTOCloud2NA bindDeviceNotifyDTOCloud2NA) throws IOException {
        
        log.debug("request : {}", bindDeviceNotifyDTOCloud2NA);
        
        addNotify2MsgList(bindDeviceNotifyDTOCloud2NA);
        
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
    
    @RequestMapping(value = UrlConfiguration.NSCL_ADD_DEVICE_CALLBACK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> recvAddDeviceNotify(
            @RequestBody AddDeviceNotifyDTOCloud2NA addDeviceNotifyDTOCloud2NA) throws IOException {
        
        log.debug("request : {}", addDeviceNotifyDTOCloud2NA);
        
        addNotify2MsgList(addDeviceNotifyDTOCloud2NA);
        
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
    
    @RequestMapping(value = UrlConfiguration.NSCL_DROP_DEVICE_CALLBACK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> recvDropDeviceNotify(
            @RequestBody DeleteDeviceNotifyDTOCloud2NA deleteDeviceNotifyDTOCloud2NA) throws IOException {
        
        log.debug("request : {}", deleteDeviceNotifyDTOCloud2NA);
        
        addNotify2MsgList(deleteDeviceNotifyDTOCloud2NA);
        
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
    
    @RequestMapping(value = UrlConfiguration.NSCL_UPDATE_DEVICE_INFO_CALLBACK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> recvUpdateDeviceInfoNotify(
            @RequestBody UpdateDeviceInfoNotifyDTOCloud2NA updateDeviceInfoNotifyDTOCloud2NA) throws IOException {
        
        log.debug("request : {}", updateDeviceInfoNotifyDTOCloud2NA);
        
        addNotify2MsgList(updateDeviceInfoNotifyDTOCloud2NA);
        
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
    
    @RequestMapping(value = UrlConfiguration.NSCL_UPDATE_DEVICE_DATA_CALLBACK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> recvUpdateDeviceDataNotify(
            @RequestBody UpdateDeviceDataNotifyDTOCloud2NA updateDeviceDataNotifyDTOCloud2NA) throws IOException {
        
        log.debug("request : {}", updateDeviceDataNotifyDTOCloud2NA);
        
        addNotify2MsgList(updateDeviceDataNotifyDTOCloud2NA);
        
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
    
    @RequestMapping(value = UrlConfiguration.NSCL_UPDATE_SERVICE_INFO_CALLBACK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> recvUpdateServiceInfoNotify(
            @RequestBody UpdateServiceInfoNotifyDTOCloud2NA updateServiceInfoNotifyDTOCloud2NA) throws IOException {
        
        log.debug("request : {}", updateServiceInfoNotifyDTOCloud2NA);
        
        addNotify2MsgList(updateServiceInfoNotifyDTOCloud2NA);
        
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
    
    @RequestMapping(value = UrlConfiguration.NSCL_DEVICE_CMD_CONFIRM_CALLBACK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> recvDeviceCommandConfirmNotify(
            @RequestBody SignalConfirmDTOCloud2NA signalConfirmDTOCloud2NA) throws IOException {
        
        log.debug("request : {}", signalConfirmDTOCloud2NA);
        
        addNotify2MsgList(signalConfirmDTOCloud2NA);
        
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
    
    @RequestMapping(value = UrlConfiguration.NSCL_DEVICE_CMD_RSP_CALLBACK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> recvDeviceCommanddRspNotify(
            @RequestBody UpdateCommandRspNotifyDTOCloud2NA updateCommandRspNotifyDTOCloud2NA) throws IOException {
        
        log.debug("request : {}", updateCommandRspNotifyDTOCloud2NA);
        
        addNotify2MsgList(updateCommandRspNotifyDTOCloud2NA);
        
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
    
    @RequestMapping(value = UrlConfiguration.NSCL_DEVICE_EVENT_CALLBACK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> recvDeviceEventNotify(
            @RequestBody DeviceReportEventNotifyDTOCloud2NA deviceReportEventNotifyDTOCloud2NA) throws IOException {
        
        log.debug("request : {}", deviceReportEventNotifyDTOCloud2NA);
        
        addNotify2MsgList(deviceReportEventNotifyDTOCloud2NA);
        
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    private void addNotify2MsgList(NotifyDTOCloud2NA notifyDTOCloud2NA) throws IOException {
        String opType = String.format("Receive Notify [%s] from platform", notifyDTOCloud2NA.getNotifyType());
        String msgDesc = String.format("Receive Notify from platform, Notify data is: %s",
                JsonUtil.jsonObj2Sting(notifyDTOCloud2NA));
        AuthHttpClient.getInstance().messageList.add(ProtalMessageUtil.buildMsg(opType, msgDesc));
    }
}
