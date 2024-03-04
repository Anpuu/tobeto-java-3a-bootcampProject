package tobeto.bootcamppoject.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.BootcampService;
import tobeto.bootcamppoject.business.dto.create.bootcamp.request.BootcampCreateRequest;
import tobeto.bootcamppoject.business.dto.create.bootcamp.response.BootcampCreateResponse;
import tobeto.bootcamppoject.core.results.DataResult;
import tobeto.bootcamppoject.core.results.success.SuccessDataResult;
import tobeto.bootcamppoject.core.utilities.modelmapper.ModelMapperService;
import tobeto.bootcamppoject.dataAccess.abstracts.BootcampRepository;
import tobeto.bootcamppoject.entity.Bootcamp;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BootcampManager implements BootcampService {

    private final BootcampRepository bootcampRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public DataResult<BootcampCreateResponse> createBootcamp(
            final BootcampCreateRequest bootcampCreateRequest
    ) {

        Bootcamp mappedBootcampForRequest = modelMapperService.forRequest()
                .map(bootcampCreateRequest, Bootcamp.class);

        mappedBootcampForRequest.setCreatedTime(LocalDateTime.now());

        bootcampRepository.save(mappedBootcampForRequest);

        BootcampCreateResponse bootcampResponse = modelMapperService.forResponse()
                .map(mappedBootcampForRequest, BootcampCreateResponse.class);

        return new SuccessDataResult<BootcampCreateResponse>
                (bootcampResponse, "Bootcamp başarılı bir şekilde oluşturuldu.");
    }
}
