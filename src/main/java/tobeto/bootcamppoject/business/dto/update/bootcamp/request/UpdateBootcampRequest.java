package tobeto.bootcamppoject.business.dto.update.bootcamp.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBootcampRequest {
    private int id;
    private String name;
    private int instructorId;
    private LocalDate startDate;
    private LocalDate endDate;
    private int bootcampStateId;
}
