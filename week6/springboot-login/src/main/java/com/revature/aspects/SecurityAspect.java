package com.revature.aspects;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.annotations.Secured;
import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.AuthorizationException;
import com.revature.models.User;

@Aspect
@Component
public class SecurityAspect {

    private HttpServletRequest request;

    @Autowired
    public SecurityAspect(HttpServletRequest req) {
        this.request = req;
    }

    @Around("@annotation(com.revature.annotations.Secured)")
    public Object secureEndpoint(ProceedingJoinPoint pjp) throws Throwable {

        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        Secured securedAnno = method.getAnnotation(Secured.class);

        List<String> allowedRoles = Arrays.asList(securedAnno.allowedRoles());
        User authUser = (User) request.getSession().getAttribute("authUser");

        if (authUser == null) {
            throw new AuthenticationException();
        }

        if(!allowedRoles.contains(authUser.getRole().toString())) {
            throw new AuthorizationException();
        }
        
        Object target = pjp.proceed();
        return target;

    }

}
