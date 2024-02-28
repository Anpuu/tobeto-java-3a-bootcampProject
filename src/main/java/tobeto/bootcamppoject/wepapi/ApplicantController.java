package tobeto.bootcamppoject.wepapi;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tobeto.bootcamppoject.business.abstracts.ApplicantService;
import tobeto.bootcamppoject.business.dto.Applicant.request.ApplicantCreatRequest;
import tobeto.bootcamppoject.business.dto.Applicant.response.ApplicantCreateResponse;

@RestController
@RequestMapping("/applicants")
@AllArgsConstructor
public class ApplicantController {

    private ApplicantService applicantService;

    @PostMapping
    public ApplicantCreateResponse create(@RequestBody ApplicantCreatRequest applicantCreatRequest){

        return applicantService.create(applicantCreatRequest);

    }

/*
    @PostMapping
    ApplicantCreatRequest create(@RequestBody ApplicantCreatRequest applicantCreatRequest){
       return applicantService.create(applicantCreatRequest);
    }

    ApplicantCreatRequest getByID(Integer applicantID){
        return applicantService.getById(applicantID);
    }
*/

}
