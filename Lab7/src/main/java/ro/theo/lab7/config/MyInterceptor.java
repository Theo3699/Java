package ro.theo.lab7.config;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@MyInterceptorBinding
public class MyInterceptor {
    @AroundInvoke
    public Object log(InvocationContext context) throws Exception {
        System.out.println("Entering method: "
                + context.getMethod().getName() + " in class "
                + context.getMethod().getDeclaringClass().getName());
        return context.proceed();
    }
}