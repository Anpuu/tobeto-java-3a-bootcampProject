package tobeto.bootcamppoject.business.dto.create.bootcamp.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BootcampCreateResponse {

    private int id;
    private String name;
    private Date startDate;
    private Date endDate;
    private int instructorId;
    private int bootcampStateId;
}
