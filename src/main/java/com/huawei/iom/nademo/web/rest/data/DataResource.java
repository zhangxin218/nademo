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
package com.huawei.iom.nademo.web.rest.data;

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

import com.huawei.iom.intf.app.data.v1.dto.QueryDeviceCapabilitiesDTOCloud2NA;
import com.huawei.iom.intf.app.data.v1.dto.QueryDeviceDataHistoryDTOCloud2NA;
import com.huawei.iom.intf.app.dm.v1.dto.QueryDeviceDTOCloud2NA;
import com.huawei.iom.intf.app.dm.v1.dto.QueryDevicesDTOCloud2NA;
import com.huawei.iom.nademo.service.data.DataService;

@Controller
public class DataResource {
    /**
     * 日志工具
     */
    private static final Logger log = LoggerFactory.getLogger(DataResource.class);
    
    @RequestMapping(value = "/appdemo/portal/v1.0/data/query/devices", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<QueryDevicesDTOCloud2NA> queryDevice(
            @RequestParam(value = "appId", required = false) String appId,
            @RequestParam(value = "gatewayId", required = false) String gatewayId,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "nodeType", required = false) String nodeType,
            @RequestParam(value = "pageNo", required = false) Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = "1", required = false) Integer pageSize,
            @RequestParam(value = "startTime", required = false) String startTime,
            @RequestParam(value = "endTime", required = false) String endTime,
            @RequestParam(value = "sort", required = false, defaultValue = "DESC") String sort) {
        QueryDevicesDTOCloud2NA response = null;
        try{
            response = DataService.queryDevicesInfo(appId, gatewayId, status, nodeType,
                pageNo, pageSize, startTime, endTime,  sort);
        }catch(Exception e){
            
        }
        
        log.info("queryDevice response:{}", response);
        return new ResponseEntity<QueryDevicesDTOCloud2NA>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/appdemo/portal/v1.0/data/query/history/devices", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<QueryDeviceDataHistoryDTOCloud2NA> queryDeviceHistory(
            @RequestParam(value = "deviceId", required = true) String deviceId,
            @RequestParam(value = "gatewayId", required = true) String gatewayId,
            @RequestParam(value = "serviceId", required = false) String serviceId,
            @RequestParam(value = "pageNo", required = false) Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = "1", required = false) Integer pageSize,
            @RequestParam(value = "startTime", required = false) String startTime,
            @RequestParam(value = "endTime", required = false) String endTime) {
        
        QueryDeviceDataHistoryDTOCloud2NA response = null;
        try{
            response = DataService.getDeviceHistory
                (deviceId, gatewayId, serviceId, pageNo, pageSize, startTime, endTime);
        }catch(Exception e){
            
        }
        
        log.info("queryDevice response:{}",response);
        return new ResponseEntity<QueryDeviceDataHistoryDTOCloud2NA>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/appdemo/portal/v1.0/data/query/device/{deviceId}", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<QueryDeviceDTOCloud2NA> queryDeviceById(@PathVariable String deviceId,
            @RequestParam(value = "appId", required = false) String accessAppId) {
        
        QueryDeviceDTOCloud2NA response = null;
        try {
            response = DataService.queryOneDeviceInfo(deviceId, accessAppId);
        } catch (Exception e) {

        }
        
        log.info("queryDevice response:{}",response);
        return new ResponseEntity<QueryDeviceDTOCloud2NA>(response, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/appdemo/portal/v1.0/data/query/capabilities", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<QueryDeviceCapabilitiesDTOCloud2NA> queryDeviceCapabilities(
            @RequestParam(value = "deviceId", defaultValue = "", required = false) String deviceId,
            @RequestParam(value = "gatewayId", defaultValue = "", required = false) String gatewayId) {
        
        QueryDeviceCapabilitiesDTOCloud2NA response = null;
        try{
            response = DataService.queryDeviceServiceCapabilities(deviceId, gatewayId);
        }catch(Exception e){
            
        }
        
        log.info("queryDevice response:{}",response);
        return new ResponseEntity<QueryDeviceCapabilitiesDTOCloud2NA>(response, HttpStatus.OK);
    }
}
