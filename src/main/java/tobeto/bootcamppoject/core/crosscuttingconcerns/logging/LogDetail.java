package tobeto.bootcamppoject.core.crosscuttingconcerns.logging;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "log_details")
public class LogDetail {

    @Id
    private String id;

    @Field(name = "method_name")
    private String methodName;

    @Field(name = "user")
    private String user;

    @Field(name = "parameters_list")
    private List<LogParameter> parametersList;
}
