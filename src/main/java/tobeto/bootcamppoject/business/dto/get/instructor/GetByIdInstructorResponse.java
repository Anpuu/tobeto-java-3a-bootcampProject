package tobeto.bootcamppoject.business.dto.get.instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdInstructorResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String companyName;
    private LocalDateTime dateOfBirth;
}
