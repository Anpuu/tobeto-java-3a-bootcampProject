package tobeto.bootcamppoject.core.crosscuttingconcerns.logging.configurations.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.core.crosscuttingconcerns.logging.LogDetail;
import tobeto.bootcamppoject.core.crosscuttingconcerns.logging.LogParameter;
import tobeto.bootcamppoject.core.crosscuttingconcerns.logging.LoggerServiceBase;
import java.util.List;
@Service
public class MongoDbLogger extends LoggerServiceBase {
    private MongoTemplate mongoTemplate;

    @Autowired
    public MongoDbLogger(MongoTemplate mongoTemplate){
        super(MongoDbLogger.class);
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void log(String methodName, List<LogParameter> logParameters, String userName) {
        LogDetail logDetail = new LogDetail();
        logDetail.setMethodName(methodName);
        logDetail.setParametersList(logParameters);
        logDetail.setUser(userName);
        info(logDetail.toString());
        mongoTemplate.save(logDetail);
    }
}
