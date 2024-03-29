package tobeto.bootcamppoject.business.dto.get.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByPositionEmployeeResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
}
