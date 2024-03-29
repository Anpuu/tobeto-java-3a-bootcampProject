package tobeto.bootcamppoject.wepapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcamppoject.business.abstracts.BootcampService;
import tobeto.bootcamppoject.business.dto.create.bootcamp.request.CreateBootcampRequest;
import tobeto.bootcamppoject.business.dto.update.bootcamp.request.UpdateBootcampRequest;
import tobeto.bootcamppoject.core.aspects.logging.Loggable;

@RestController
@RequestMapping("/bootcamps")
@RequiredArgsConstructor
public class BootcampController  extends BaseController{

    private final BootcampService bootcampService;


    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody final CreateBootcampRequest createBootcampRequest
    ){

        return handleDataResult(bootcampService.createBootcamp(createBootcampRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBootcamp(
           final UpdateBootcampRequest updateBootcampRequest,
           final Integer id
    ){
        return handleDataResult(bootcampService.updateBootcamp(updateBootcampRequest,id));
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> gettByID(
            final Integer id
    ){
        return handleDataResult(bootcampService.getById(id));
    }


    @GetMapping
    public ResponseEntity<?> getAll(){
        return handleDataResult(bootcampService.getAll());
    }


    @DeleteMapping
    public ResponseEntity<?> delete(
            final Integer id
    ){
        return handleDataResult(bootcampService.deletedByIdBootcamp(id));
    }

}
