package tobeto.bootcamppoject.business.dto.update.instructor.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorUpdateResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String companyName;
}
