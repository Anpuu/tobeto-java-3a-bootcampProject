package tobeto.bootcamppoject.business.dto.update.bootcampState.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBootcampStateRequest {
    private int id;
    private String name;
}
