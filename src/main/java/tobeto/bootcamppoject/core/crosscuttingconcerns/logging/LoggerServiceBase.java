package tobeto.bootcamppoject.core.crosscuttingconcerns.logging;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

// yapılandırmalar için abstract kullanılabilir. daha hızlı adepte olabilmesi için.

public abstract class LoggerServiceBase {

    protected final Logger logger;

    public LoggerServiceBase(Class<?> logClazz){
        this.logger = LoggerFactory.getLogger(logClazz);
    }

    public void verbose(String message){
        logger.trace(message);
    }
    public void fatal(String message){
        logger.error(message);
    }
    public void info(String message){
        logger.info(message);
    }
    public void warning(String message){
        logger.warn(message);
    }
    public void debug(String message){
        logger.debug(message);
    }
    public void error(String message){
        logger.error(message);
    }

    public abstract void log(String methodName, List<LogParameter> logParameters,String userName);
}
