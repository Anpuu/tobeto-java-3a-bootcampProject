package tobeto.bootcamppoject.business.dto.get.applicant;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantGetAllResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String about;
    private LocalDateTime createdTime;
}
