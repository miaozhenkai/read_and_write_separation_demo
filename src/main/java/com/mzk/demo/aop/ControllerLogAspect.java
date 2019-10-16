package com.mzk.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @program: read_and_write_separation_demo
 * @description: read_and_write_separation_demo
 * @author: miaozhenkai
 * @create: 2019-10-16 16:05
 */
@Aspect
@Component
@Slf4j
public class ControllerLogAspect {
    /**
     * 定义日志切入点
     */
    @Pointcut("execution(public * com.mzk.demo.controller.*.*(..))")
    public void logCut() {
    }

    /**
     * 统计请求的处理时间
     */
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 在切入点开始处切入内容
     *
     * @param joinPoint
     */
    @Before("logCut()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("LogAspect logBefore begin-------------------------------------------------------");
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        //获取所有参数
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = enu.nextElement();
            System.out.println(paraName + ": " + request.getParameter(paraName));
        }
    }

    /**
     * 在切入点return内容之后切入内容
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "logCut()")
    public void logAfterReturning(Object object) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("response : {}", object.toString());
        log.info(request.getRequestURL().toString() + "接口用时：" + (System.currentTimeMillis() - startTime.get()) + "ms");
        log.info("LogAspect logAfterReturning end------------------------------------------------");
    }
}
