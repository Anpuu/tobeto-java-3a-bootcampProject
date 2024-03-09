package tobeto.bootcamppoject.wepapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcamppoject.business.abstracts.BootcampStateService;
import tobeto.bootcamppoject.business.dto.create.bootcampstate.request.CreateBootcampStateRequest;
import tobeto.bootcamppoject.business.dto.update.bootcamp.request.UpdateBootcampRequest;
import tobeto.bootcamppoject.business.dto.update.bootcampState.request.UpdateBootcampStateRequest;
import tobeto.bootcamppoject.core.aspects.logging.Loggable;

@RestController
@RequestMapping("/bootcampstate")
@RequiredArgsConstructor
public class BootcampStateController extends BaseController{

    private final BootcampStateService bootcampStateService;


    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody final CreateBootcampStateRequest createBootcampStateRequest
    ){
        return  handleDataResult(bootcampStateService.create(createBootcampStateRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBootcampState(
            final UpdateBootcampStateRequest updateBootcampStateRequest,
            final Integer id
    ){
        return handleDataResult(bootcampStateService.updateBootcampState(updateBootcampStateRequest,id));
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> gettByID(
            final Integer id
    ){
        return handleDataResult(bootcampStateService.getById(id));
    }


    @GetMapping
    public ResponseEntity<?> getAll(){
        return handleDataResult(bootcampStateService.getAll());
    }


    @DeleteMapping
    public ResponseEntity<?> delete(
            final Integer id
    ){
        return handleDataResult(bootcampStateService.delete(id));
    }
}
