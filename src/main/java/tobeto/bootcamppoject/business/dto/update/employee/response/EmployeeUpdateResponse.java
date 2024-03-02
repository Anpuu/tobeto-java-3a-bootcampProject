package tobeto.bootcamppoject.business.dto.update.employee.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private Date dateOfBirthday;
    private String nationalIdentity;
    private String position;
}
