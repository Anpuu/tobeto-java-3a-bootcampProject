package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.create.application.request.CreateApplicationRequest;
import tobeto.bootcamppoject.business.dto.create.application.response.CreateApplicationResponse;
import tobeto.bootcamppoject.business.dto.get.application.GetAllApplicationResponse;
import tobeto.bootcamppoject.business.dto.get.application.GetByIdApplicationResponse;
import tobeto.bootcamppoject.business.dto.update.application.request.UpdateApplicationRequest;
import tobeto.bootcamppoject.business.dto.update.application.response.UpdateApplicationResponse;
import tobeto.bootcamppoject.core.results.DataResult;

import java.util.List;

public interface ApplicationService {
    DataResult<CreateApplicationResponse> create(CreateApplicationRequest createApplicationRequest);

    DataResult<GetByIdApplicationResponse> getById(Integer applicationId);

    DataResult<List<GetAllApplicationResponse>> getAll();

    DataResult<UpdateApplicationResponse> updateApplication(UpdateApplicationRequest updateApplicantRequest, Integer applicationId);

    DataResult<?> deletedByIdApplication(Integer id);



}
