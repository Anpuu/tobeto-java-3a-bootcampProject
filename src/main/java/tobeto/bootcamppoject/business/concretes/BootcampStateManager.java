package tobeto.bootcamppoject.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.BootcampStateService;
import tobeto.bootcamppoject.business.dto.create.bootcampstate.request.BootcampStateCreateRequest;
import tobeto.bootcamppoject.business.dto.create.bootcampstate.response.BootcampStateCreateResponse;
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
    public DataResult<BootcampStateCreateResponse> create(
           final BootcampStateCreateRequest bootcampStateCreateRequest
    ) {

        BootcampState mappedBootcampStateForRequest = modelMapperService.forRequest()
                .map(bootcampStateCreateRequest, BootcampState.class);

        mappedBootcampStateForRequest.setCreatedTime(LocalDateTime.now());

        bootcampStateRepository.save(mappedBootcampStateForRequest);

        BootcampStateCreateResponse response = modelMapperService.forResponse()
                .map(mappedBootcampStateForRequest, BootcampStateCreateResponse.class);

        return new SuccessDataResult<BootcampStateCreateResponse>
                (response, "Bootcamp durumu başarılı bir şekilde oluşturulmuştur.");
    }
}
