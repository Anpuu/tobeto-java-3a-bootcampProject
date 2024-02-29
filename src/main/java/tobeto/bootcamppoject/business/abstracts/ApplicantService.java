package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.create.applicant.request.ApplicantCreatRequest;
import tobeto.bootcamppoject.business.dto.create.applicant.response.ApplicantCreateResponse;
import tobeto.bootcamppoject.business.dto.get.applicant.ApplicantGetAllResponse;
import tobeto.bootcamppoject.business.dto.get.applicant.ApplicantGetByIdResponse;

import java.util.List;


public interface ApplicantService {
    ApplicantCreateResponse create(ApplicantCreatRequest applicantCreatRequest);

    ApplicantGetByIdResponse getById(Integer applicantID);

    List<ApplicantGetAllResponse> getAll();

}
