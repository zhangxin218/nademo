/*
 * Copyright Notice:
 *      Copyright  1998-2008, Huawei Technologies Co., Ltd.  ALL Rights Reserved.
 *
 *      Warning: This computer software source code is protected by copyright law
 *      and international treaties. Unauthorized reproduction or distribution
 *      of this source code, or any portion of it, may result in severe civil and
 *      criminal penalties, and will be prosecuted to the maximum extent
 *      possible under the law.
 */
package com.huawei.iom.nademo.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class SpringContextHelper implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        initApplicationContext(applicationContext);
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    private static void initApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

}
