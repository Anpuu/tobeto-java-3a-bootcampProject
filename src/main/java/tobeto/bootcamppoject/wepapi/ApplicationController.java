package tobeto.bootcamppoject.wepapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcamppoject.business.abstracts.ApplicationService;
import tobeto.bootcamppoject.business.dto.create.application.request.CreateApplicationRequest;
import tobeto.bootcamppoject.business.dto.update.application.request.UpdateApplicationRequest;

@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class ApplicationController extends BaseController{

    private final ApplicationService applicationService;


    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody final CreateApplicationRequest createApplicationRequest
    ){
        return handleDataResult(applicationService.create(createApplicationRequest));

    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(
            @PathVariable final Integer id
    ){
        return handleDataResult(applicationService.getById(id));
    }


    @GetMapping(value = "/getall")
    public ResponseEntity<?> getAll(){
        return handleDataResult(applicationService.getAll());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateById(
            @RequestBody final UpdateApplicationRequest updateApplicationRequest,
            @PathVariable final Integer id
    ){
        return handleDataResult(applicationService.updateApplication(updateApplicationRequest,id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(
            @PathVariable final Integer id
    ){
        return handleDataResult(applicationService.deletedByIdApplication(id));
    }
}
