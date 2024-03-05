package tobeto.bootcamppoject.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.BootcampService;
import tobeto.bootcamppoject.business.dto.create.bootcamp.request.CreateBootcampRequest;
import tobeto.bootcamppoject.business.dto.create.bootcamp.response.CreateBootcampResponse;
import tobeto.bootcamppoject.business.dto.get.bootcamp.GetAllBootcampResponse;
import tobeto.bootcamppoject.business.dto.get.bootcamp.GetByIdBootcampResponse;
import tobeto.bootcamppoject.business.dto.update.bootcamp.request.UpdateBootcampRequest;
import tobeto.bootcamppoject.business.dto.update.bootcamp.response.UpdateBootcampResponse;
import tobeto.bootcamppoject.core.results.DataResult;
import tobeto.bootcamppoject.core.results.success.SuccessDataResult;
import tobeto.bootcamppoject.core.utilities.modelmapper.ModelMapperService;
import tobeto.bootcamppoject.dataAccess.abstracts.BootcampRepository;
import tobeto.bootcamppoject.entity.Bootcamp;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BootcampManager implements BootcampService {

    private final BootcampRepository bootcampRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public DataResult<CreateBootcampResponse> createBootcamp(
            final CreateBootcampRequest createBootcampRequest
    ) {

        Bootcamp mappedBootcampForRequest = modelMapperService.forRequest()
                .map(createBootcampRequest, Bootcamp.class);

        mappedBootcampForRequest.setCreatedTime(LocalDateTime.now());

        bootcampRepository.save(mappedBootcampForRequest);

        CreateBootcampResponse bootcampResponse = modelMapperService.forResponse()
                .map(mappedBootcampForRequest, CreateBootcampResponse.class);

        return new SuccessDataResult<CreateBootcampResponse>
                (bootcampResponse, "Bootcamp başarılı bir şekilde oluşturuldu.");
    }

    @Override
    public DataResult<GetByIdBootcampResponse> getById(Integer applicationId) {
        return null;
    }

    @Override
    public DataResult<List<GetAllBootcampResponse>> getAll() {
        return null;
    }

    @Override
    public DataResult<UpdateBootcampResponse> updateApplication(UpdateBootcampRequest updateBootcampRequest, Integer applicationId) {
        return null;
    }

    @Override
    public DataResult<?> deletedByIdBootcamp(Integer id) {
        return null;
    }
}
