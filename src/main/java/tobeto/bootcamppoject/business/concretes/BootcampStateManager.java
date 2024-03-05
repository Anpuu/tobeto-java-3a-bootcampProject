package tobeto.bootcamppoject.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.BootcampStateService;
import tobeto.bootcamppoject.business.dto.create.bootcampstate.request.CreateBootcampStateRequest;
import tobeto.bootcamppoject.business.dto.create.bootcampstate.response.CreateBootcampStateResponse;
import tobeto.bootcamppoject.core.results.DataResult;
import tobeto.bootcamppoject.core.results.success.SuccessDataResult;
import tobeto.bootcamppoject.core.utilities.modelmapper.ModelMapperService;
import tobeto.bootcamppoject.dataAccess.abstracts.BootcampStateRepository;
import tobeto.bootcamppoject.entity.BootcampState;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BootcampStateManager implements BootcampStateService {

    private final ModelMapperService modelMapperService;
    private final BootcampStateRepository bootcampStateRepository;

    @Override
    public DataResult<CreateBootcampStateResponse> create(
           final CreateBootcampStateRequest createBootcampStateRequest
    ) {

        BootcampState mappedBootcampStateForRequest = modelMapperService.forRequest()
                .map(createBootcampStateRequest, BootcampState.class);

        mappedBootcampStateForRequest.setCreatedTime(LocalDateTime.now());

        bootcampStateRepository.save(mappedBootcampStateForRequest);

        CreateBootcampStateResponse response = modelMapperService.forResponse()
                .map(mappedBootcampStateForRequest, CreateBootcampStateResponse.class);

        return new SuccessDataResult<CreateBootcampStateResponse>
                (response, "Bootcamp durumu başarılı bir şekilde oluşturulmuştur.");
    }
}
