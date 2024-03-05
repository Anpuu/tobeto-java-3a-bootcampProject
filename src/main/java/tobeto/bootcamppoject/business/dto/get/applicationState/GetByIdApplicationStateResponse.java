package tobeto.bootcamppoject.business.dto.get.applicationState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdApplicationStateResponse {
    private int id;
    private String name;
}
