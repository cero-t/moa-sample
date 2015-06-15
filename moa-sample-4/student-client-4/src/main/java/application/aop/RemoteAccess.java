package application.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Aspect
@Component
public class RemoteAccess {
    @Around("execution(* service..*Service.*(..))")
    public Object callRemoteService(JoinPoint joinPoint) throws IllegalAccessException, InstantiationException {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        String className = methodSignature.getMethod()
                .getDeclaringClass()
                .getSimpleName()
                .toLowerCase();
        String path = className.substring(0, className.indexOf("service"));

        String url = "http://localhost:8080/" + path;
        System.out.println(url);
        Class<?> returnType = methodSignature.getReturnType();

        if (methodSignature.getMethod()
                .getName()
                .toLowerCase()
                .contains("get")) {
            return new RestTemplate().getForEntity(url, returnType, joinPoint.getArgs())
                    .getBody();
        } else if (methodSignature.getMethod()
                .getName()
                .toLowerCase()
                .contains("post")) {
            return new RestTemplate().postForEntity(url, joinPoint.getArgs()[0], returnType)
                    .getBody();
        }

        throw new RuntimeException("method name must contains 'get' or 'post'");
    }
}
