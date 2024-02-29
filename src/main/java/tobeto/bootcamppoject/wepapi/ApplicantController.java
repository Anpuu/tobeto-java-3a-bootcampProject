package tobeto.bootcamppoject.wepapi;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcamppoject.business.abstracts.ApplicantService;
import tobeto.bootcamppoject.business.dto.create.applicant.request.ApplicantCreatRequest;
import tobeto.bootcamppoject.business.dto.create.applicant.response.ApplicantCreateResponse;
import tobeto.bootcamppoject.business.dto.get.applicant.ApplicantGetAllResponse;
import tobeto.bootcamppoject.business.dto.get.applicant.ApplicantGetByIdResponse;

import java.util.List;

@RestController
@RequestMapping("/applicants")
@AllArgsConstructor
public class ApplicantController {

    private ApplicantService applicantService;

    @PostMapping
    public ApplicantCreateResponse create(
            @RequestBody ApplicantCreatRequest applicantCreatRequest
    ) {

        return applicantService.create(applicantCreatRequest);

    }

    @GetMapping(value = "/{id}")
    public ApplicantGetByIdResponse getById(
            @PathVariable Integer id
    ) {

        return applicantService.getById(id);
    }

    @GetMapping(value = "/getall")
    public List<ApplicantGetAllResponse> getAll(){
        return applicantService.getAll();
    }
}
