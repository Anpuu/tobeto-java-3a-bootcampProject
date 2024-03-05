package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.create.applicationstate.request.CreateApplicationStateRequest;
import tobeto.bootcamppoject.business.dto.create.applicationstate.response.CreateApplicationStateResponse;
import tobeto.bootcamppoject.business.dto.get.applicationState.GetAllApplicationStateResponse;
import tobeto.bootcamppoject.business.dto.get.applicationState.GetByIdApplicationStateResponse;
import tobeto.bootcamppoject.business.dto.update.applicationState.request.UpdateApplicationStateRequest;
import tobeto.bootcamppoject.business.dto.update.applicationState.response.UpdateApplicationStateResponse;
import tobeto.bootcamppoject.core.results.DataResult;

import java.util.List;

public interface ApplicationStateService {

    DataResult<CreateApplicationStateResponse> create(CreateApplicationStateRequest createApplicationStateRequest);

    DataResult<UpdateApplicationStateResponse> updateApplicantState(UpdateApplicationStateRequest updateApplicationStateRequest, Integer applicantStateId);

    DataResult<GetByIdApplicationStateResponse> getById(Integer applicationId);

    DataResult<List<GetAllApplicationStateResponse>> getAll();

    DataResult<?> deletedApplication(Integer id);
}
