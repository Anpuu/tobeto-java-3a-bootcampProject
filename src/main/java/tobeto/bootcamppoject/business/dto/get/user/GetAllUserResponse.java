package tobeto.bootcamppoject.business.dto.get.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUserResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
}
