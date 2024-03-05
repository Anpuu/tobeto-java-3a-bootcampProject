package tobeto.bootcamppoject.business.dto.update.instructor.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInstructorRequest {
    private String userName;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String nationalIdentity;
    private String email;
    private String password;
    private String companyName;
}
