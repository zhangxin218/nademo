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
package com.huawei.iom.nademo.common.url;

public class UrlConfiguration {
    
    public static final String HTTP = "http://";
    public static final String HTTPS = "https://";
    
    private static String iotIp;
    
    private static String iotPort;
    
    private static String naAddressIp;
    
    private static String naAddressPort;

    //鉴权
    public static final String LOGIN = "/iocm/app/sec/v1.1.0/login";
    //注册直连设备
    public static final String DEVICE_REGISTER = "/iocm/app/reg/v1.1.0/devices";
    //发现非直连设备
    public static final String DEVICE_CONTROL = "/iocm/app/signaltrans/v1.1.0/devices/%s/services/%s/sendCommand";
    //查询设备激活状态
    public static final String DEVICE_ACTIVE_STATUS = "/iocm/app/reg/v1.1.0/devices/%s";
    //删除设备
    public static final String DEVICE_DELETE = "/iocm/app/dm/v1.1.0/devices/%s";
    //修改设备信息
    public static final String DEVICE_UPDATE = "/iocm/app/dm/v1.1.0/devices/%s";
    
    //按条件批量查询设备信息列表
    public static final String DATA_DEVICES = "/iocm/app/dm/v1.1.0/devices";
    //查询单个设备信息
    public static final String DATA_DEVICE = "/iocm/app/dm/v1.1.0/devices/%s";
    //application订阅平台信息数据
    public static final String DATA_SUBSCRIPTION = "/iocm/app/sub/v1.1.0/subscribe";
    //查询设备历史数据
    public static final String DATA_DEVICE_HISTORY = "/iocm/app/data/v1.1.0/deviceDataHistory";
    //查询设备能力
    public static final String DATA_DEVICE_CAPABILITIES = "/iocm/app/data/v1.1.0/deviceCapabilities";
    
    //创建规则
    public static final String RULE_ADD = "/iocm/app/rule/v1.2.0/rules";
    //更新规则
    public static final String RULE_UPDATE = "/iocm/app/rule/v1.2.0/rules";
    //修改规则状态
    public static final String RULE_MODIFY_STATUS = "/iocm/app/rule/v1.2.0/rules/{ruleId}";
    //删除规则
    public static final String RULE_DELETE = "/iocm/app/rule/v1.2.0/rules/{ruleId}";
    //查找规则
    public static final String RULE_QUERY = "/iocm/app/v1.2.0/rules";
    
    //消息通知url
    public static final String NSCL_ACTIVE_DEVICE_CALLBACK = "/na/iocm/devNotify/v1.1.0/activeDevice";
    public static final String NSCL_ADD_DEVICE_CALLBACK = "/na/iocm/devNotify/v1.1.0/addDevice";
    public static final String NSCL_UPDATE_DEVICE_INFO_CALLBACK = "/na/iocm/devNotify/v1.1.0/updateDeviceInfo";
    public static final String NSCL_UPDATE_DEVICE_DATA_CALLBACK = "/na/iocm/devNotify/v1.1.0/updateDeviceData";
    public static final String NSCL_DROP_DEVICE_CALLBACK = "/na/iocm/devNotify/v1.1.0/dropDevice";
    public static final String NSCL_DEVICE_CMD_CONFIRM_CALLBACK = "/na/iocm/devNotify/v1.1.0/commandConfirmData";
    public static final String NSCL_DEVICE_CMD_RSP_CALLBACK = "/na/iocm/devNotify/v1.1.0/commandRspData";
    public static final String NSCL_DEVICE_EVENT_CALLBACK = "/na/iocm/devNotify/v1.1.0/event";
    public static final String NSCL_UPDATE_SERVICE_INFO_CALLBACK = "/na/iocm/devNotify/v1.1.0/updateServiceInfo";
    
    // 获取API Server的详细地址
    public static String getIoTIp() {
        // url="http://186.25.1.56:8543"
        String url = new StringBuilder(HTTP)
                .append(iotIp)
                .append(":")
                .append(iotPort)
                .toString();

        return url;
    }
    
    private static String getNaAddress() {
        String url = new StringBuilder("http://").append(naAddressIp)
                .append(":")
                .append(naAddressPort)
                .toString();

        return url;
    }

    
    /**
     * 获取登录URL
     * @return
     */
    public static String getLoginUrl(){
        return getIoTIp() + LOGIN;
    }
    
    /**
     * 获取注册设备URL
     * @return
     */
    public static String getDeviceRegisterUrl(){
        return getIoTIp() + DEVICE_REGISTER;
    }
    
    /**
     * 获取发现非直连设备URL
     * @return
     */
    public static String getDeviceControlUrl(String deviceId, String serviceId){
        return getIoTIp() + String.format(DEVICE_CONTROL, deviceId, serviceId);
    }

    /**
     * 获取查询设备激活状态URL
     * @return
     */
    public static String getDeviceActiveStatusUrl(String deviceId){
        return getIoTIp() + String.format(DEVICE_ACTIVE_STATUS, deviceId);
    }
    
    /**
     * 获取删除设备URL
     * @return
     */
    public static String getDeviceDeleteUrl(String deviceId){
        return getIoTIp() + String.format(DEVICE_DELETE, deviceId);
    }
    
    /**
     * 获取修改设备信息URL
     * @return
     */
    public static String getDeviceUpdateUrl(String deviceId){
        return getIoTIp() + String.format(DEVICE_UPDATE, deviceId);
    }
    
    /**
     * 获取按条件批量查询设备信息列表URL
     * @return
     */
    public static String getDataDevicesUrl(){
        return getIoTIp() + DATA_DEVICES;
    }
    
    /**
     * 获取查询单个设备信息URL
     * @return
     */
    public static String getDataDeviceUrl(String deviceId){
        return getIoTIp() + String.format(DATA_DEVICE, deviceId);
    }
    
    /**
     * 获取application订阅平台信息数据URL
     * @return
     */
    public static String getDataSubscriptionUrl(){
        return getIoTIp() + DATA_SUBSCRIPTION;
    }
    
    /**
     * 获取查询设备历史数据URL
     * @return
     */
    public static String getDataDeviceHistoryUrl(){
        return getIoTIp() + DATA_DEVICE_HISTORY;
    }
    
    /**
     * 获取查询设备URL
     * @return
     */
    public static String getDataDeviceCapabilitiesUrl(){
        return getIoTIp() + DATA_DEVICE_CAPABILITIES;
    }
    
    /**
     * 获取创建规则URL
     * @return
     */
    public static String getRuleDddUrl(){
        return getIoTIp() + RULE_ADD;
    }
    
    /**
     * 获取更新规则URL
     * @return
     */
    public static String getRuleUpdateUrl(){
        return getIoTIp() + RULE_UPDATE;
    }
    
    /**
     * 获取修改规则状态URL
     * @return
     */
    public static String getRuleModifyStatusUrl(){
        return getIoTIp() + RULE_MODIFY_STATUS;
    }
    
    /**
     * 获取删除规则URL
     * @return
     */
    public static String getRuleDeleteUrl(){
        return getIoTIp() + RULE_DELETE;
    }
    
    /**
     * 获取查找规则URL
     * @return
     */
    public static String getRuleQueryUrl(){
        return getIoTIp() + RULE_QUERY;
    }

    //消息通知
    
    public static String getActDevCallbackUrl() {
        return getNaAddress() + NSCL_ACTIVE_DEVICE_CALLBACK;
    }

    public static String getAddDevCallbackUrl() {
        return getNaAddress() + NSCL_ADD_DEVICE_CALLBACK;
    }

    public static String getUpdDevInfoCallbackUrl() {
        return getNaAddress() + NSCL_UPDATE_DEVICE_INFO_CALLBACK;
    }

    public static String getUpdDevDataCallbackUrl(){
        return getNaAddress() + NSCL_UPDATE_DEVICE_DATA_CALLBACK;
    }
    
    public static String getDropDevCallbackUrl(){
        return getNaAddress() + NSCL_DROP_DEVICE_CALLBACK;
    }

    public static String getCmdConfirmCallbackUrl(){
        return getNaAddress() + NSCL_DEVICE_CMD_CONFIRM_CALLBACK;
    }

    public static String getCmdRspCallbackUrl(){
        return getNaAddress() + NSCL_DEVICE_CMD_RSP_CALLBACK;
    }

    public static String getDeviceEventCallbackUrl(){
        return getNaAddress() + NSCL_DEVICE_EVENT_CALLBACK;
    }
    
    public static String getUpdSrvInfoCallbackUrl(){
        return getNaAddress() + NSCL_UPDATE_SERVICE_INFO_CALLBACK;
    }

    public static String getIotIp() {
        return iotIp;
    }

    public static void setIotIp(String iotIp) {
        UrlConfiguration.iotIp = iotIp;
    }

    public static String getIotPort() {
        return iotPort;
    }

    public static void setIotPort(String iotPort) {
        UrlConfiguration.iotPort = iotPort;
    }

    public static String getNaAddressIp() {
        return naAddressIp;
    }

    public static void setNaAddressIp(String naAddressIp) {
        UrlConfiguration.naAddressIp = naAddressIp;
    }

    public static String getNaAddressPort() {
        return naAddressPort;
    }

    public static void setNaAddressPort(String naAddressPort) {
        UrlConfiguration.naAddressPort = naAddressPort;
    }
    
}
