package tobeto.bootcamppoject.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.BootcampStateService;
import tobeto.bootcamppoject.business.dto.create.bootcampstate.request.CreateBootcampStateRequest;
import tobeto.bootcamppoject.business.dto.create.bootcampstate.response.CreateBootcampStateResponse;
import tobeto.bootcamppoject.business.dto.get.bootcampState.GetAllBootcampStateResponse;
import tobeto.bootcamppoject.business.dto.get.bootcampState.GetBootcampStateResponse;
import tobeto.bootcamppoject.business.dto.update.bootcampState.request.UpdateBootcampStateRequest;
import tobeto.bootcamppoject.business.dto.update.bootcampState.response.UpdateBootcampStateResponse;
import tobeto.bootcamppoject.core.utilities.results.DataResult;
import tobeto.bootcamppoject.core.utilities.results.success.SuccessDataResult;
import tobeto.bootcamppoject.core.utilities.modelmapper.ModelMapperService;
import tobeto.bootcamppoject.dataAccess.abstracts.BootcampStateRepository;
import tobeto.bootcamppoject.entity.BootcampState;

import java.time.LocalDateTime;
import java.util.List;

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

    @Override
    public DataResult<List<GetAllBootcampStateResponse>> getAll() {

        List<BootcampState> bootcampStates = bootcampStateRepository.findAll();
        List<GetAllBootcampStateResponse> bootcampStateResponses = bootcampStates.stream()
                .map(bootcampState -> modelMapperService.forResponse()
                        .map(bootcampState, GetAllBootcampStateResponse.class)).toList();

        return new SuccessDataResult<List<GetAllBootcampStateResponse>>
                (bootcampStateResponses, "Tüm BootcampStateler eklendi.");
    }

    @Override
    public DataResult<GetBootcampStateResponse> getById(
            final Integer id
    ) {

        BootcampState bootcampState = bootcampStateRepository.getById(id);
        GetBootcampStateResponse response = modelMapperService.forResponse()
                .map(bootcampState, GetBootcampStateResponse.class);

        return new SuccessDataResult<GetBootcampStateResponse>
                (response, "ID'e göre bootcamp getirilmiştir.");
    }

    @Override
    public DataResult<?> delete(int id) {

        bootcampStateRepository.deleteById(id);
        return new SuccessDataResult("ID'e sahip bootcamp silindi.");
    }

    @Override
    public DataResult<UpdateBootcampStateResponse> updateBootcampState(
            final UpdateBootcampStateRequest request,
            final Integer id
    ) {

        BootcampState foundBootcampState = bootcampStateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bu ID'e sahip bootcampstate bulunamamıştır."));

        BootcampState updatedBootcampState = modelMapperService.forRequest().map(request, BootcampState.class);

        foundBootcampState.setName(updatedBootcampState.getName() != null ? updatedBootcampState.getName() : foundBootcampState.getName());
        foundBootcampState.setUpdateTime(LocalDateTime.now());
        bootcampStateRepository.save(foundBootcampState);

        UpdateBootcampStateResponse response = modelMapperService.forResponse()
                .map(foundBootcampState, UpdateBootcampStateResponse.class);

        return new SuccessDataResult<UpdateBootcampStateResponse>
                (response, "BootcampState güncellenmiştir.");
    }
}
