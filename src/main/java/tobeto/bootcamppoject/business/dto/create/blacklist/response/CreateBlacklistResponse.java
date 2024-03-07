package tobeto.bootcamppoject.business.dto.create.blacklist.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBlacklistResponse {
    private String reason;
    private LocalDateTime date;
    private int applicantId;
}
