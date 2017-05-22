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
package com.huawei.iom.nademo.util;

import org.joda.time.DateTime;

public class ProtalMessageUtil {

    public static String buildMsg(String opType,String msgDesc){
        StringBuffer msgStr = new StringBuffer();
        msgStr.append(new DateTime()).append("\r\n");
        msgStr.append("--------------------------------------");
        msgStr.append(opType);
        msgStr.append("--------------------------------------");
        msgStr.append("\r\n");
        msgStr.append(msgDesc);
        msgStr.append("\r\n");
        return msgStr.toString();
    }

}
