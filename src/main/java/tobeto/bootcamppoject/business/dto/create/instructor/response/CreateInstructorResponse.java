package tobeto.bootcamppoject.business.dto.create.instructor.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String companyName;
}
