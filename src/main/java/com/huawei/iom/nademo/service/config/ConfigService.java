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
package com.huawei.iom.nademo.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {
    @Value(value = "${iot.server.ip:'127.0.0.1'}")
    private String iotServerIp;

    @Value(value = "${iot.server.port:'8080'}")
    private String iotServerPort;

    public String getIotServerIp() {
        return iotServerIp;
    }

    public String getIotServerPort() {
        return iotServerPort;
    }
    
}
