package com.ikyxxs.timecount.autoconfigure;

import com.ikyxxs.timecount.annotation.TimeCount;
import com.ikyxxs.timecount.aop.TimeCountInterceptor;
import org.aopalliance.aop.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class TimeCountConfiguration extends AbstractPointcutAdvisor {

    private Logger logger = LoggerFactory.getLogger(TimeCountConfiguration.class);

    private Pointcut pointcut;

    private Advice advice;

    @PostConstruct
    public void init() {
        logger.info("init LogAutoConfiguration start");
        this.pointcut = new AnnotationMatchingPointcut(null, TimeCount.class);
        this.advice = new TimeCountInterceptor();
        logger.info("init LogAutoConfiguration end");
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public Advice getAdvice() {
        return this.advice;
    }
}