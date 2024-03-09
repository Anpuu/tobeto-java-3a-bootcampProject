package tobeto.bootcamppoject.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.ApplicationService;
import tobeto.bootcamppoject.business.dto.create.application.request.CreateApplicationRequest;
import tobeto.bootcamppoject.business.dto.create.application.response.CreateApplicationResponse;
import tobeto.bootcamppoject.business.dto.get.application.GetAllApplicationResponse;
import tobeto.bootcamppoject.business.dto.get.application.GetByIdApplicationResponse;
import tobeto.bootcamppoject.business.dto.update.application.request.UpdateApplicationRequest;
import tobeto.bootcamppoject.business.dto.update.application.response.UpdateApplicationResponse;
import tobeto.bootcamppoject.core.utilities.results.DataResult;
import tobeto.bootcamppoject.core.utilities.results.success.SuccessDataResult;
import tobeto.bootcamppoject.core.utilities.modelmapper.ModelMapperService;
import tobeto.bootcamppoject.dataAccess.abstracts.ApplicationRepository;
import tobeto.bootcamppoject.entity.Application;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationManager implements ApplicationService {

    private final ModelMapperService modelMapperService;

    private final ApplicationRepository applicationRepository;

    @Override
    public SuccessDataResult<CreateApplicationResponse> create(
           final CreateApplicationRequest createApplicationRequest
    ) {
        Application mappedApplicationForRequest = modelMapperService.forRequest()
                .map(createApplicationRequest,Application.class);

        mappedApplicationForRequest.setCreatedTime(LocalDateTime.now());

        applicationRepository.save(mappedApplicationForRequest);

        CreateApplicationResponse response = modelMapperService.forResponse()
                .map(mappedApplicationForRequest, CreateApplicationResponse.class);

        return new SuccessDataResult<CreateApplicationResponse>
                (response,"Başvuru başarılı bir şekilde alınmıştır.");

    }

    @Override
    public DataResult<GetByIdApplicationResponse> getById(
           final Integer applicationId
    ) {
        Application foundApplicationById = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Bu ID'e sahip bir başvuru bulunamadı."));

        GetByIdApplicationResponse getByIdApplicationResponse = modelMapperService.forResponse()
                .map(foundApplicationById, GetByIdApplicationResponse.class);

        return new SuccessDataResult<GetByIdApplicationResponse>
                (getByIdApplicationResponse,"ID'e sahip başvuru getirilmiştir.");
    }

    @Override
    public DataResult<List<GetAllApplicationResponse>> getAll() {
        List<Application> applicationList = applicationRepository.findAll();

        List<GetAllApplicationResponse> applicationResponseList =
                applicationList.stream().map(application -> modelMapperService
                                .forResponse().map(application,GetAllApplicationResponse.class))
                        .collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllApplicationResponse>>(applicationResponseList,"Tüm başvuranlar listelendi.");
    }

  @Override
    public DataResult<UpdateApplicationResponse> updateApplication(
           final UpdateApplicationRequest updateApplicationRequest,
           final Integer applicationId
    ) {
        Application foundApplication = applicationRepository
                .findById(applicationId).orElseThrow(() -> new RuntimeException("Bu ID'e sahip başvuru bulunamamıştır."));

        Application applicationToUpdate = modelMapperService
                .forRequest().map(updateApplicationRequest,Application.class);

        foundApplication.setUpdateTime(LocalDateTime.now());
        foundApplication.setApplicant(applicationToUpdate.getApplicant() !=null ? applicationToUpdate.getApplicant() : foundApplication.getApplicant());
        foundApplication.setBootcamp(applicationToUpdate.getBootcamp() !=null ? applicationToUpdate.getBootcamp() : foundApplication.getBootcamp());
        foundApplication.setApplicationState(applicationToUpdate.getApplicationState() !=null ? applicationToUpdate.getApplicationState() : foundApplication.getApplicationState());

        applicationRepository.save(foundApplication);

        UpdateApplicationResponse response = modelMapperService.forResponse()
                .map(foundApplication,UpdateApplicationResponse.class);

        return new SuccessDataResult<UpdateApplicationResponse>
                (response,"Güncelleme başarıyla gerçekleşti.");
    }

    @Override
    public DataResult<?> deletedByIdApplication(Integer id) {
        applicationRepository.deleteById(id);
        return new SuccessDataResult("İlgili ID'e sahip başvuran silindi.");
    }
}
