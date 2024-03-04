package tobeto.bootcamppoject.core.aspects.logging;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import tobeto.bootcamppoject.core.crosscuttingconcerns.logging.LogParameter;
import tobeto.bootcamppoject.core.crosscuttingconcerns.logging.LoggerServiceBase;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class LogAspects {

    private final LoggerServiceBase loggerServiceBase;

    private final HttpServletRequest httpServletRequest; // herhangi bir user varmı diye kontrol ediyor?


    public LogAspects(
            LoggerServiceBase loggerServiceBase,
            HttpServletRequest httpServletRequest
    ) {
        this.loggerServiceBase = loggerServiceBase;
        this.httpServletRequest = httpServletRequest;
    }

    // bu anatasyon diyo ki bu anatasyonun belirli bir aop işleminde nerede ve ne zaman gerçekleşeceğini gösteriyorum.
    @Pointcut("within(@org.springframework.stereotype.Repository *)" +
            "" + " || within(@org.springframework.stereotype.Service *)" +
            "" + " || within(@org.springframework.web.bind.annotation.RestController *)")
    public void springBeanPointcut() {
    }

    @Around("springBeanPointcut() && @annotation(tobeto.bootcamppoject.core.aspects.logging.Loggable)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        Object result = joinPoint.proceed();

        String methodName = joinPoint.getSignature().getDeclaringType()
                + "." + joinPoint.getSignature().getName();

        List<LogParameter> logParameters = new ArrayList<>();
        logParameters.add(new LogParameter(result));

        String userName = getUserName();

        loggerServiceBase.log(methodName, logParameters, userName);
        return result;
    }

    private String getUserName() {
        if (httpServletRequest.getUserPrincipal() != null) {
            return httpServletRequest.getUserPrincipal().getName();
        } else {
            return "?";
        }
    }
}
