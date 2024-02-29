package tobeto.bootcamppoject.business.dto.create.applicant.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantCreateResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String about;
    private LocalDateTime createdTime;
}
