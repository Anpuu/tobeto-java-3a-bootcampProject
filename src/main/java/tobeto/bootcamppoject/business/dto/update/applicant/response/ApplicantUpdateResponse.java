package tobeto.bootcamppoject.business.dto.update.applicant.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantUpdateResponse {
    private int id;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String nationalIdentity;
    private String about;
    private LocalDateTime updateTime;
}
