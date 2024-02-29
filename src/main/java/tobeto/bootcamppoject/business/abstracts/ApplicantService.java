package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.Applicant.request.ApplicantCreatRequest;
import tobeto.bootcamppoject.business.dto.Applicant.response.ApplicantCreateResponse;


public interface ApplicantService {
    ApplicantCreateResponse create(ApplicantCreatRequest applicantCreatRequest);


}
