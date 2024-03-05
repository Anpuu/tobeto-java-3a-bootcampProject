package tobeto.bootcamppoject.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.ApplicationStateService;
import tobeto.bootcamppoject.business.dto.create.applicationstate.request.CreateApplicationStateRequest;
import tobeto.bootcamppoject.business.dto.create.applicationstate.response.CreateApplicationStateResponse;
import tobeto.bootcamppoject.business.dto.get.applicationState.GetAllApplicationStateResponse;
import tobeto.bootcamppoject.business.dto.get.applicationState.GetByIdApplicationStateResponse;
import tobeto.bootcamppoject.business.dto.update.applicationState.request.UpdateApplicationStateRequest;
import tobeto.bootcamppoject.business.dto.update.applicationState.response.UpdateApplicationStateResponse;
import tobeto.bootcamppoject.core.results.DataResult;
import tobeto.bootcamppoject.core.results.success.SuccessDataResult;
import tobeto.bootcamppoject.core.utilities.modelmapper.ModelMapperService;
import tobeto.bootcamppoject.dataAccess.abstracts.ApplicationStateRepository;
import tobeto.bootcamppoject.entity.ApplicationState;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationStateManager implements ApplicationStateService {

    private final ModelMapperService modelMapperService;
    private final ApplicationStateRepository applicationStateRepository;

    @Override
    public DataResult<CreateApplicationStateResponse> create(
            final CreateApplicationStateRequest createApplicationStateRequest
    ) {
        ApplicationState mappedApplicationStateForRequest = modelMapperService.forRequest()
                .map(createApplicationStateRequest, ApplicationState.class);

        mappedApplicationStateForRequest.setCreatedTime(LocalDateTime.now());

        applicationStateRepository.save(mappedApplicationStateForRequest);

        CreateApplicationStateResponse response = modelMapperService.forResponse()
                .map(mappedApplicationStateForRequest, CreateApplicationStateResponse.class);

        return new SuccessDataResult<CreateApplicationStateResponse>(response, "ApplicationState Başarılı bir şekil de belirlenmiştir.");
    }

    @Override
    public DataResult<UpdateApplicationStateResponse> updateApplicantState(
            final UpdateApplicationStateRequest updateApplicationStateRequest,
            final Integer applicantStateId
    ) {
        ApplicationState foundApplicationState = applicationStateRepository
                .findById(applicantStateId).orElseThrow(() -> new RuntimeException("Bu ID'e sahip bir başvuru durumu bulunamadı."));

        ApplicationState applicationStateToUpdate = modelMapperService.forRequest()
                .map(foundApplicationState, ApplicationState.class);

        foundApplicationState.setUpdateTime(LocalDateTime.now());
        foundApplicationState.setName(foundApplicationState.getName() != null ? foundApplicationState.getName() : applicationStateToUpdate.getName());
        applicationStateRepository.save(foundApplicationState);

        UpdateApplicationStateResponse response = modelMapperService
                .forResponse().map(foundApplicationState, UpdateApplicationStateResponse.class);
        return new SuccessDataResult<UpdateApplicationStateResponse>(response, "Güncelleme başarılı bir şekilde gerçekleşti.");
    }


    @Override
    public DataResult<GetByIdApplicationStateResponse> getById(
            final Integer applicationId
    ) {
        ApplicationState foundApplicationStateGetById = applicationStateRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Bu ID'e sahip bir başvuru durumu bulunamamıştır."));

        GetByIdApplicationStateResponse getByIdApplicationStateResponse = modelMapperService.forResponse()
                .map(foundApplicationStateGetById, GetByIdApplicationStateResponse.class);

        return new SuccessDataResult<GetByIdApplicationStateResponse>
                (getByIdApplicationStateResponse, "ID'e sahip başvuru sahibi getirilmiştir.");
    }

    @Override
    public DataResult<List<GetAllApplicationStateResponse>> getAll() {

        List<ApplicationState> applicationStateList = applicationStateRepository.findAll();

        List<GetAllApplicationStateResponse> getAllApplicationStateResponseList = applicationStateList.stream()
                .map(applicationState -> modelMapperService.forResponse()
                        .map(applicationState, GetAllApplicationStateResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllApplicationStateResponse>>
                (getAllApplicationStateResponseList, "Tüm başvuru durumları listelenmiştir.");
    }

    @Override
    public DataResult<?> deletedApplication(
            final Integer id
    ) {

        applicationStateRepository.deleteById(id);

        return new SuccessDataResult("İlgili ID'e sahip başvuru durumu silinmiştir.");
    }
}
