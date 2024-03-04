package tobeto.bootcamppoject.business.dto.create.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationCreateResponse {

    private int id;
    private int applicantId;
    private int bootcampId;
    private int applicationStateId;
}