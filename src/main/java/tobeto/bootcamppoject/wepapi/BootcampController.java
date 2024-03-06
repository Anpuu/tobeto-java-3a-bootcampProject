package tobeto.bootcamppoject.wepapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tobeto.bootcamppoject.business.abstracts.BootcampService;
import tobeto.bootcamppoject.business.dto.create.bootcamp.request.CreateBootcampRequest;
import tobeto.bootcamppoject.core.aspects.logging.Loggable;

@RestController
@RequestMapping("/bootcamps")
@RequiredArgsConstructor
public class BootcampController  extends BaseController{

    private final BootcampService bootcampService;

    @Loggable
    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody final CreateBootcampRequest createBootcampRequest
    ){

        return handleDataResult(bootcampService.createBootcamp(createBootcampRequest));
    }
}
