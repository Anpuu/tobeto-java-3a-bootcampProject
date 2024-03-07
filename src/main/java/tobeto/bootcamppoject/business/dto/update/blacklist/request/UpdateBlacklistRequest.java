package tobeto.bootcamppoject.business.dto.update.blacklist.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBlacklistRequest {
    private int id;
    private String reason;
    private LocalDateTime date;
    private int applicantId;
}
