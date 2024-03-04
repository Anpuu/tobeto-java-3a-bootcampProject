package tobeto.bootcamppoject.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.ApplicationStateService;
import tobeto.bootcamppoject.business.dto.create.applicationstate.request.ApplicationStateCreateRequest;
import tobeto.bootcamppoject.business.dto.create.applicationstate.response.ApplicationStateCreateResponse;
import tobeto.bootcamppoject.core.results.DataResult;
import tobeto.bootcamppoject.core.results.success.SuccessDataResult;
import tobeto.bootcamppoject.core.utilities.modelmapper.ModelMapperService;
import tobeto.bootcamppoject.dataAccess.abstracts.ApplicationStateRepository;
import tobeto.bootcamppoject.entity.ApplicationState;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ApplicationStateManager implements ApplicationStateService {

    private final ModelMapperService modelMapperService;
    private final ApplicationStateRepository applicationStateRepository;

    @Override
    public DataResult<ApplicationStateCreateResponse> create(
           final ApplicationStateCreateRequest applicationStateCreateRequest
    ) {
        ApplicationState mappedApplicationStateForRequest = modelMapperService.forRequest()
                .map(applicationStateCreateRequest,ApplicationState.class);

        mappedApplicationStateForRequest.setCreatedTime(LocalDateTime.now());

        applicationStateRepository.save(mappedApplicationStateForRequest);

        ApplicationStateCreateResponse response = modelMapperService.forResponse()
                .map(mappedApplicationStateForRequest,ApplicationStateCreateResponse.class);

        return new SuccessDataResult<ApplicationStateCreateResponse>(response,"ApplicationState Başarılı bir şekil de belirlenmiştir.");
    }
}
