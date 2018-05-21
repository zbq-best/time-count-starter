package com.ikyxxs.timecount.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeCountInterceptor implements MethodInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String methodName = invocation.getMethod().getName();

        //获取开始时间
        long startTime = System.currentTimeMillis();

        Object result = invocation.proceed();

        //获取结束时间
        long endTime = System.currentTimeMillis();

        logger.info("spend time in " + methodName + " : " + (endTime - startTime) + "ms");

        return result;
    }
}