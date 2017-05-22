package com.huawei.iom.nademo.exception;

import org.springframework.http.HttpStatus;

import com.huawei.iom.component.exception.IExceptionEnumV1;

public enum ExpandExceptionEnum implements IExceptionEnumV1
{
      APP_NA_GENERATE_DEVICE_VERIFICATION_DEVICE_ACTIVED("203402", "Generate device id and verification failed, cause this device is already actived.", HttpStatus.OK),
      NA_NSCL_GENERATE_DEVICE_VERIFICATION_NSCL_INVALID("203407", "Generate device id and verification failed, cause invalid nscl response.", HttpStatus.INTERNAL_SERVER_ERROR),

      APP_NA_QUERY_All_DEVICES_FAILED("203900","Query all devices failed, cause bad southbound interactive.", HttpStatus.INTERNAL_SERVER_ERROR),
    
      APP_NA_COMMAND_DEVICE_FAILED("204100", "Send device command failed, cause bad southbound interactive.", HttpStatus.INTERNAL_SERVER_ERROR),
      APP_NA_COMMAND_DEVICE_NOTONLINE("204101", "The device is not online.", HttpStatus.OK),
      APP_NA_COMMAND_DEVICE_MUTED("204102", "The device command is muted.", HttpStatus.OK),
      APP_NA_COMMAND_DEVICE_SEND_FAILED("204103", "The device command send failed.", HttpStatus.OK);

    private String errorCode;

    private String errorDesc;

    private HttpStatus httpStatus;

    private ExpandExceptionEnum(String errorCode, String errorDesc, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
        this.httpStatus = httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        String message = this.getErrorCode() + "-" + this.getErrorDesc();
        return message;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
