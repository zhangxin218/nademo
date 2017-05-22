/*
 * Copyright Notice:
 *      Copyright  1998-2008, Huawei Technologies Co., Ltd.  ALL Rights Reserved.
 *
 *      Warning: This computer software sourcecode is protected by copyright law
 *      and international treaties. Unauthorized reproduction or distribution
 *      of this sourcecode, or any portion of it, may result in severe civil and
 *      criminal penalties, and will be prosecuted to the maximum extent
 *      possible under the law.
 */
package com.huawei.iom.nademo.web.rest.device;

import java.util.List;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huawei.iom.component.util.JsonUtil;
import com.huawei.iom.intf.app.dm.v1.dto.UpdateDeviceInfoDTONA2Cloud;
import com.huawei.iom.intf.app.reg.v1.dto.AddDeviceDTOCloud2NA;
import com.huawei.iom.intf.app.reg.v1.dto.QueryDeviceRegStatusDTOCloud2NA;
import com.huawei.iom.intf.app.signaltrans.v1.dto.CommandDTODevice2CloudReply;
import com.huawei.iom.intf.app.signaltrans.v1.dto.CommandDTONA2Cloud;
import com.huawei.iom.intf.app.signaltrans.v1.dto.CommandNA2CloudHeader;
import com.huawei.iom.nademo.common.login.AuthHttpClient;
import com.huawei.iom.nademo.service.device.DeviceService;
import com.huawei.iom.nademo.util.ProtalMessageUtil;

@Controller
public class DeviceResource {
    private static final Logger log = LoggerFactory.getLogger(DeviceResource.class);
    
    @RequestMapping(value = "/appdemo/portal/v1.0/reg/device", method = RequestMethod.POST, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<AddDeviceDTOCloud2NA> registerDevice(
            @RequestParam(value = "verifyCode", required = false) String verifyCode,
            @RequestParam(value = "nodeId", required = true) String nodeId) {
    	
        AuthHttpClient authHttpClient = AuthHttpClient.getInstance();
        authHttpClient.messageList.add(ProtalMessageUtil.buildMsg(String.format(
                "Register gateway, MAC is %s", verifyCode), "Register gateway ..."));
        AddDeviceDTOCloud2NA response = null;
        try{
            response = DeviceService.registerDevice(verifyCode, nodeId);
        }catch(Exception e){
            
        }
        
        log.info("registerDevice response:{}", JsonUtil.jsonObj2Sting(response));
        authHttpClient.messageList.add(ProtalMessageUtil.buildMsg(
                String.format("Register gateway, MAC is %s", verifyCode),
                String.format("The response is %s ", JsonUtil.jsonObj2Sting(response))));
        
        return new ResponseEntity<AddDeviceDTOCloud2NA>(response, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/appdemo/portal/v1.0/find/device", method = RequestMethod.POST, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<CommandDTODevice2CloudReply> findDevice(
            @RequestParam(value = "findDeviceId", required = true) String deviceId,
            @RequestParam(value = "protocolType", required = true) String protocolType) {
        
        AuthHttpClient authHttpClient = AuthHttpClient.getInstance();
        authHttpClient.messageList.add(ProtalMessageUtil.buildMsg(
                String.format("Discover sensors, gatewayId is %s", deviceId), "Discovering ..."));
        
        CommandDTONA2Cloud request = new CommandDTONA2Cloud();
        CommandNA2CloudHeader header = new CommandNA2CloudHeader();
        header.setMode("ACK");
        header.setMethod("DISCOVERY");
        header.setFrom("/user/"+AuthHttpClient.getKey());
        request.setHeader(header);
        JSONObject body = new JSONObject();
        body.put("protocolType", protocolType);
        body.put("mode", "ON");
        body.put("timeout", 300);
        request.setBody(body );
        CommandDTODevice2CloudReply response = null;
        try {
            response = DeviceService.sendDeviceCommand(deviceId, "Discovery", request);
            log.info("findDevice response: {}", JsonUtil.jsonObj2Sting(response));
        } catch (Exception e) {

        }
        
        authHttpClient.messageList.add(ProtalMessageUtil.buildMsg(
                String.format("Discover sensors, gatewayId is %s, protocolType is %s", deviceId, protocolType),
                String.format("The response is %s ", JsonUtil.jsonObj2Sting(response))));      
        
        return new ResponseEntity<CommandDTODevice2CloudReply>(response, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/appdemo/portal/v1.0/status/device/{deviceId}", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<QueryDeviceRegStatusDTOCloud2NA> queryDeviceStatus(@PathVariable String deviceId) {

        AuthHttpClient authHttpClient = AuthHttpClient.getInstance();
        authHttpClient.messageList.add(ProtalMessageUtil.buildMsg(
                String.format("Query the device status, deviceId is %s", deviceId), "Query the device status..."));
        
        QueryDeviceRegStatusDTOCloud2NA response = null;
        try{
            response = DeviceService.queryDeviceActiveStatus(deviceId);
        }catch(Exception e){
            
        }

        log.info("queryDeviceStatus response:{}", JsonUtil.jsonObj2Sting(response));
        authHttpClient.messageList.add(ProtalMessageUtil.buildMsg(
                String.format("Query the device status, deviceId is %s", deviceId),
                String.format("The response is %s ", JsonUtil.jsonObj2Sting(response))));
        
        return new ResponseEntity<QueryDeviceRegStatusDTOCloud2NA>(response, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/appdemo/portal/v1.0/delete/device/{deviceId}", method = RequestMethod.DELETE, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> delDevice(@PathVariable String deviceId) {

        AuthHttpClient authHttpClient = AuthHttpClient.getInstance();
        authHttpClient.messageList.add(ProtalMessageUtil.buildMsg(
                String.format("Remove Device, deviceId is %s", deviceId), "Remove Device..."));
        String response =  null;
        try{
            response = DeviceService.deleteDevice(deviceId);
        }catch(Exception e){
            
        }

        log.info("delete Device response:{}", JsonUtil.jsonObj2Sting(response));
        authHttpClient.messageList.add(ProtalMessageUtil.buildMsg(
                String.format("Remove Device, deviceId is %s", deviceId),
                String.format("The response is %s ", JsonUtil.jsonObj2Sting(response))));

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/appdemo/portal/v1.0/rename/device/{deviceId}", method = RequestMethod.PUT, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> modifyDevice(@PathVariable String deviceId,
            @RequestParam(value = "deviceName", required = true) String deviceName,
            @RequestParam(value = "endUser", required = false) String endUser) {

        AuthHttpClient authHttpClient = AuthHttpClient.getInstance();
        authHttpClient.messageList.add(ProtalMessageUtil.buildMsg(
                String.format("Modify the device name or endUser, deviceId is %s", deviceId),
                "Modify the device name or endUser..."));
        
        UpdateDeviceInfoDTONA2Cloud request = new UpdateDeviceInfoDTONA2Cloud();
        request.setName(deviceName);
        request.setEndUser(endUser);
        String response = null;
        try {
            response = DeviceService.renameDevice(deviceId, request);
        } catch (Exception e) {

        }

        log.info("renameDevice response:{}", JsonUtil.jsonObj2Sting(response));
        authHttpClient.messageList.add(ProtalMessageUtil.buildMsg(
                String.format("Modify the device name or endUser, deviceId is %s", deviceId),
                String.format("The response is %s ", JsonUtil.jsonObj2Sting(response))));

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/appdemo/portal/v1.0/send/command/device", method = RequestMethod.POST, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<CommandDTODevice2CloudReply> sendCommndToDevice(
            @RequestParam(value = "deviceId", required = true) String deviceId,
            @RequestParam(value = "serviceId", required = true) String serviceId,
            @RequestParam(value = "commandName", required = true) String commandName,
            @RequestParam(value = "commandPara", required = false) String commandPara) {

        AuthHttpClient authHttpClient = AuthHttpClient.getInstance();
        authHttpClient.messageList.add(ProtalMessageUtil.buildMsg(String.format(
                "Send commands to device, the deviceId is %s", deviceId), "Send commands..."));
        
        CommandDTONA2Cloud request = new CommandDTONA2Cloud();
        CommandNA2CloudHeader header = new CommandNA2CloudHeader();
        header.setMode("ACK");
        header.setMethod(commandName);
        header.setFrom("/"+AuthHttpClient.getKey());
        request.setHeader(header);
        try {
            request.setBody(JSONObject.fromObject(commandPara));
        } catch (Exception e) {
            log.debug(new StringBuilder("Set command parameter failed, command string is ").append(commandPara)
                    .toString());
            log.debug(new StringBuilder("JsonString Convert Exception, exception message is ").append(
                    e.getLocalizedMessage()).toString());
        }
        CommandDTODevice2CloudReply response = null;
        try {
            response = DeviceService.sendDeviceCommand(deviceId, serviceId, request);
        } catch (Exception e) {

        }
        log.info("findDevice response:{}", JsonUtil.jsonObj2Sting(response));
        authHttpClient.messageList.add(ProtalMessageUtil.buildMsg(String.format(
                "Send commands to device, the deviceId is %s, serviceId is %s, commandName is %s, commandPara is %s",
                deviceId, serviceId, commandName, commandPara), String.format("The response is %s ",
                JsonUtil.jsonObj2Sting(response))));

        return new ResponseEntity<CommandDTODevice2CloudReply>(response, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/appdemo/portal/v1.0/show/message", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> showMessage() {
        AuthHttpClient authHttpClient = AuthHttpClient.getInstance();
        List<String> response = authHttpClient.messageList;
        String responseStr = "";
        for (String string : response) {
            responseStr += string + "\r\n";
        }
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("message", responseStr);
        return new ResponseEntity<String>(jsonObj.toString(), HttpStatus.OK);
    }
}
