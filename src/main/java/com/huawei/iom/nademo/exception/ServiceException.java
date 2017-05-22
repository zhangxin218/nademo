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
package com.huawei.iom.nademo.exception;

import org.springframework.http.HttpStatus;

import com.huawei.iom.component.exception.BaseException;
import com.huawei.iom.component.exception.IExceptionEnum;
import com.huawei.iom.component.exception.IExceptionEnumV1;

public class ServiceException extends BaseException {
    private static final long serialVersionUID = 1327165261458359392L;

    public ServiceException(IExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }

    public ServiceException(HttpStatus httpStatus, IExceptionEnum exceptionEnum) {
        super(httpStatus, exceptionEnum);
    }

    public ServiceException(IExceptionEnumV1 exceptionEnumV1) {
        super(exceptionEnumV1);
    }
    
    public ServiceException(IExceptionEnumV1 exceptionEnumV1, Object[] params) {
        super(exceptionEnumV1, params);
    }
}
