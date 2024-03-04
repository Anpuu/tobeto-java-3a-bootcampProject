package tobeto.bootcamppoject.wepapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tobeto.bootcamppoject.business.abstracts.BootcampService;
import tobeto.bootcamppoject.business.dto.create.bootcamp.request.BootcampCreateRequest;

@RestController
@RequestMapping("/bootcamps")
@RequiredArgsConstructor
public class BootcampController  extends BaseController{

    private final BootcampService bootcampService;

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody final BootcampCreateRequest bootcampCreateRequest
    ){

        return handleDataResult(bootcampService.createBootcamp(bootcampCreateRequest));
    }
}
