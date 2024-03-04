package tobeto.bootcamppoject.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.ApplicationService;
import tobeto.bootcamppoject.business.dto.create.application.request.ApplicationCreateRequest;
import tobeto.bootcamppoject.business.dto.create.application.response.ApplicationCreateResponse;
import tobeto.bootcamppoject.core.results.success.SuccessDataResult;
import tobeto.bootcamppoject.core.utilities.modelmapper.ModelMapperService;
import tobeto.bootcamppoject.dataAccess.abstracts.ApplicationRepository;
import tobeto.bootcamppoject.entity.Application;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ApplicationManager implements ApplicationService {

    private final ModelMapperService modelMapperService;

    private final ApplicationRepository applicationRepository;

    @Override
    public SuccessDataResult<ApplicationCreateResponse> create(
           final ApplicationCreateRequest applicationCreateRequest
    ) {
        Application mappedApplicationForRequest = modelMapperService.forRequest()
                .map(applicationCreateRequest,Application.class);

        mappedApplicationForRequest.setCreatedTime(LocalDateTime.now());

        applicationRepository.save(mappedApplicationForRequest);

        ApplicationCreateResponse response = modelMapperService.forResponse()
                .map(mappedApplicationForRequest,ApplicationCreateResponse.class);

        return new SuccessDataResult<ApplicationCreateResponse>
                (response,"Başvuru başarılı bir şekilde alınmıştır.");

    }
}
