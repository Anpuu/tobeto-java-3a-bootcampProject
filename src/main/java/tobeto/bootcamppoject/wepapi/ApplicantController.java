package tobeto.bootcamppoject.wepapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcamppoject.business.abstracts.ApplicantService;
import tobeto.bootcamppoject.business.dto.create.applicant.request.CreatApplicantRequest;
import tobeto.bootcamppoject.business.dto.update.applicant.request.UpdateApplicantRequest;
import tobeto.bootcamppoject.core.aspects.logging.Loggable;

@RestController
@RequestMapping("/applicants")
@RequiredArgsConstructor
public class ApplicantController extends BaseController {

    private final ApplicantService applicantService;

    @Loggable
    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody final CreatApplicantRequest creatApplicantRequest
    ) {
        return handleDataResult(applicantService.
                create(creatApplicantRequest));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(
            @PathVariable final Integer id
    ) {
        return handleDataResult(applicantService.getById(id));
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<?> getAll() {
        return handleDataResult(applicantService.getAll());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateApplicantById(
            @RequestBody final UpdateApplicantRequest updateApplicantRequest,
            @PathVariable final int id
    ) {
        return handleDataResult(
                applicantService.updateByIDApplicant(updateApplicantRequest, id)
        );
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteApplicantByID(@PathVariable final Integer id){
        return handleDataResult(applicantService.deletedByIdApplicant(id));
    }

    @DeleteMapping(value = "/deleteall")
    public ResponseEntity<?> deleteAllApplicant(){
        return handleDataResult(applicantService.deletedAllApplicant());
    }
}
