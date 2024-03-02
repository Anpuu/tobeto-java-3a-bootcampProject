package tobeto.bootcamppoject.business.dto.update.employee.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private Date dateOfBirthday;
    private String nationalIdentity;
    private String position;
}
