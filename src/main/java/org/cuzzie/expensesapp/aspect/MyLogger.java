package org.cuzzie.expensesapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLogger {

    private final Logger logger = LoggerFactory.getLogger(MyLogger.class);

    public MyLogger() {
    }

    @Before("execution( * org.cuzzie.expensesapp.controller..*.*(..) )")
    public void logMethodBefore(JoinPoint joinPoint) {
        logger.info("Start method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution( * org.cuzzie.expensesapp.controller..*.*(..) )")
    public void logMethodAfter(JoinPoint joinPoint) {
        logger.info("End method: " + joinPoint.getSignature().getName());
    }

}
