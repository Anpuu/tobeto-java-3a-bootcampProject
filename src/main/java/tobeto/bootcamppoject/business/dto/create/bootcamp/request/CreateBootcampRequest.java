package tobeto.bootcamppoject.business.dto.create.bootcamp.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBootcampRequest {

    private String name;
    private Date startDate;
    private Date endDate;
    private int instructorId;
    private int bootcampStateId;

}
