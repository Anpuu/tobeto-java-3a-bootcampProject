package tobeto.bootcamppoject.business.dto.create.applicant.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatApplicantRequest {
    private String userName;
    private String firstName;
    private String lastName;
    private LocalDateTime dateOfBirth;
    private String nationalIdentity;
    private String email;
    private String password;
    private String about;
}
