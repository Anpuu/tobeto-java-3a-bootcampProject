package tobeto.bootcamppoject.business.dto.Applicant.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantCreateResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String about;
}
