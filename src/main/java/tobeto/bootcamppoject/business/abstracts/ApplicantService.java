package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.create.applicant.request.ApplicantCreatRequest;
import tobeto.bootcamppoject.business.dto.create.applicant.response.ApplicantCreateResponse;
import tobeto.bootcamppoject.business.dto.get.applicant.ApplicantGetAllResponse;
import tobeto.bootcamppoject.business.dto.get.applicant.ApplicantGetByIdResponse;
import tobeto.bootcamppoject.core.results.DataResult;
import java.util.List;


public interface ApplicantService {
    DataResult<ApplicantCreateResponse> create(ApplicantCreatRequest applicantCreatRequest);

    DataResult<ApplicantGetByIdResponse> getById(Integer applicantID);

    DataResult<List<ApplicantGetAllResponse>> getAll();

}
