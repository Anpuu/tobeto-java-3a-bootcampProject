package tobeto.bootcamppoject.wepapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcamppoject.business.abstracts.ApplicationService;
import tobeto.bootcamppoject.business.dto.create.application.request.ApplicationCreateRequest;

@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class ApplicationController extends BaseController{

    private final ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody final ApplicationCreateRequest applicationCreateRequest
    ){
        return handleDataResult(applicationService.create(applicationCreateRequest));

    }
}
