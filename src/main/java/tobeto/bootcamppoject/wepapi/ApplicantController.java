package tobeto.bootcamppoject.wepapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcamppoject.business.abstracts.ApplicantService;
import tobeto.bootcamppoject.business.dto.create.applicant.request.ApplicantCreatRequest;
import tobeto.bootcamppoject.business.dto.get.applicant.ApplicantGetAllResponse;
import tobeto.bootcamppoject.business.dto.get.applicant.ApplicantGetByIdResponse;
import tobeto.bootcamppoject.business.dto.update.applicant.request.ApplicantUpdateRequest;
import tobeto.bootcamppoject.core.results.DataResult;

import java.util.List;

@RestController
@RequestMapping("/applicants")
@RequiredArgsConstructor
public class ApplicantController extends BaseController {

    private final ApplicantService applicantService;

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody final ApplicantCreatRequest applicantCreatRequest
    ) {
        return handleDataResult(applicantService.
                create(applicantCreatRequest));
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
            @RequestBody final ApplicantUpdateRequest applicantUpdateRequest,
            @PathVariable final int id
    ) {
        return handleDataResult(
                applicantService.updateByIDApplicant(applicantUpdateRequest, id)
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
