package cn.wqk.blog.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 吴青珂
 * @Date: 2020/07/21/11:15
 * @Description: 日志切面
 */
@Aspect
@Component
public class LoggerAspect {
    private static Logger log=Logger.getLogger(LoggerAspect.class);

    /**
     * 定义切点为service包里的所有方法
     */
    @Pointcut("execution(* cn.wqk.blog.controller..*.*(..))")
    public void pointCut(){}

    @After("pointCut()")
    public void after(){
        //从解析器里获得request请求
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        //从request请求中获得ip地址
        String ipAddress = request.getRemoteAddr();
        log.debug("ip:"+ipAddress);
    }
}
