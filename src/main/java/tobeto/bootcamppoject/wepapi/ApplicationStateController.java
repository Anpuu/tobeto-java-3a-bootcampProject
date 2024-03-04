package tobeto.bootcamppoject.wepapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tobeto.bootcamppoject.business.abstracts.ApplicationStateService;
import tobeto.bootcamppoject.business.dto.create.applicationstate.request.ApplicationStateCreateRequest;

@RestController
@RequestMapping("/applicationstate")
@RequiredArgsConstructor
public class ApplicationStateController extends BaseController{

    private final ApplicationStateService applicationStateService;

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody final ApplicationStateCreateRequest applicationStateCreateRequest
    ){
        return handleDataResult(applicationStateService.create(applicationStateCreateRequest));
    }
}
