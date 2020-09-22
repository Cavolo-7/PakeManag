package com.auc.util;



import com.auc.pojo.Admin;
import com.auc.pojo.Log;
import com.auc.service.TimingService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;


/**
 * @author zx
 * @desc 切点类
 */

@Aspect
@Component
public class SystemLogAspect {

    @Autowired
    TimingService timingService;

    @Pointcut("execution(* com.auc.service.impl.*.*(..))")
    public void controllerAspect() {
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
//        System.out.println("==========执行controller前置通知===============");

    }

    //配置controller环绕通知,使用在方法aspect()上注册的切入点 需要有返回值
    @Around("controllerAspect()")
    public Object around(JoinPoint joinPoint) {
//        System.out.println("==========开始执行controller环绕通知===============");
        long start = System.currentTimeMillis();
        Object object = null;
        String methodName = joinPoint.getSignature().getName();

        try {
            object = ((ProceedingJoinPoint) joinPoint).proceed();
            long end = System.currentTimeMillis();

            System.out.println("==========结束执行controller环绕通知===============");
        } catch (Throwable e) {
            System.out.println("环绕通知中的异常--------------------------------" + methodName + "-------" + e.getMessage());
            long end = System.currentTimeMillis();

        }
        return object;
    }

    /**
     * 后置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @After("controllerAspect()")
    public void after(JoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        HttpSession session = request.getSession();
//        读取session中的用户
        Admin admin = (Admin) session.getAttribute("admin");
        if (admin == null) {
            admin = new Admin();
        }
//        请求的IP
        String ip = request.getRemoteAddr();
        try {
            String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();
            Class targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();
            String operationType = "";
            String operationName = "";
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();
                    if (clazzs.length == arguments.length) {
                        operationType = method.getAnnotation(com.auc.util.Log.class).operationType();
                        operationName = method.getAnnotation(com.auc.util.Log.class).operationName();
                        break;
                    }
                }
            }
            //*========控制台输出=========*//
            System.out.println("=====controller后置通知开始=====");
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()") + "." + operationType);
            System.out.println("方法描述:" + operationName);
            System.out.println("请求人:" + admin.getWorkerName());
            System.out.println("请求IP:" + ip);
            //*========数据库日志=========*//

            if (operationName!=null&&!operationName.equals("")) {
                Log log = new Log();
                log.setLogEvent(operationName);
                log.setLogWorker(admin.getWorkerName());
                //保存数据库
                timingService.AddLog(log);
                System.out.println("=====controller后置通知结束=====");
            }
        } catch (Exception e) {
            //记录本地异常日志

            throw e;
        }
    }

    //配置后置返回通知,使用在方法aspect()上注册的切入点
//      @AfterReturning("controllerAspect()")
//      public void afterReturn(JoinPoint joinPoint){
//          System.out.println("=====执行controller后置返回通知=====----");
//              if(logger.isInfoEnabled()){
//                  logger.info("afterReturn " + joinPoint);
//              }
//      }

    /**
     * 异常通知 用于拦截记录异常日志
     *
     * @param joinPoint
     * @param e
     */
}