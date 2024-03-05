package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.create.applicant.request.CreatApplicantRequest;
import tobeto.bootcamppoject.business.dto.create.applicant.response.CreateApplicantResponse;
import tobeto.bootcamppoject.business.dto.get.applicant.GetAllApplicantResponse;
import tobeto.bootcamppoject.business.dto.get.applicant.GetByIdApplicantResponse;
import tobeto.bootcamppoject.business.dto.update.applicant.request.UpdateApplicantRequest;
import tobeto.bootcamppoject.business.dto.update.applicant.response.UpdateApplicantResponse;
import tobeto.bootcamppoject.core.results.DataResult;

import java.util.List;


public interface ApplicantService {
    DataResult<CreateApplicantResponse> create(CreatApplicantRequest creatApplicantRequest);

    DataResult<GetByIdApplicantResponse> getById(Integer applicantID);

    DataResult<List<GetAllApplicantResponse>> getAll();

    DataResult<UpdateApplicantResponse> updateByIDApplicant(UpdateApplicantRequest updateApplicantRequest, Integer id);

    DataResult<?> deletedByIdApplicant(Integer id);

    DataResult<?> deletedAllApplicant();

}
