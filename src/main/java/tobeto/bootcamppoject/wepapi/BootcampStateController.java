package tobeto.bootcamppoject.wepapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tobeto.bootcamppoject.business.abstracts.BootcampStateService;
import tobeto.bootcamppoject.business.dto.create.bootcampstate.request.CreateBootcampStateRequest;
import tobeto.bootcamppoject.core.aspects.logging.Loggable;

@RestController
@RequestMapping("/bootcampstate")
@RequiredArgsConstructor
public class BootcampStateController extends BaseController{

    private final BootcampStateService bootcampStateService;

    @Loggable
    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody final CreateBootcampStateRequest createBootcampStateRequest
    ){
        return  handleDataResult(bootcampStateService.create(createBootcampStateRequest));
    }
}
