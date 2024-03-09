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
import tobeto.bootcamppoject.core.utilities.results.DataResult;
import tobeto.bootcamppoject.core.utilities.results.success.SuccessDataResult;
import tobeto.bootcamppoject.core.utilities.modelmapper.ModelMapperService;
import tobeto.bootcamppoject.dataAccess.abstracts.BootcampRepository;
import tobeto.bootcamppoject.entity.Bootcamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
    public DataResult<GetByIdBootcampResponse> getById(
            final Integer applicationId
    ) {
        Bootcamp foundBootcampGetById = bootcampRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Bu ID'e sahip bir bootcamp bulunamamıştır."));

        GetByIdBootcampResponse getByIdBootcampResponse = modelMapperService.forResponse()
                .map(foundBootcampGetById,GetByIdBootcampResponse.class);

        return new SuccessDataResult<GetByIdBootcampResponse>(getByIdBootcampResponse, "ID'e sahip bootcamp getirilmiştir.");
    }

    @Override
    public DataResult<List<GetAllBootcampResponse>> getAll() {
        List<Bootcamp> bootcampList = bootcampRepository.findAll();

        List<GetAllBootcampResponse> getAllBootcampResponseList = bootcampList.stream()
                .map(bootcamp -> modelMapperService.forResponse()
                        .map(bootcamp,GetAllBootcampResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllBootcampResponse>>
                (getAllBootcampResponseList,"Tüm bootcampler listelenmiştir.");
    }

    @Override
    public DataResult<UpdateBootcampResponse> updateBootcamp(
           final UpdateBootcampRequest updateBootcampRequest,
           final Integer applicationId
    ) {
        Bootcamp foundBootcamp = bootcampRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Bu ID'e sahip bootcamp bulunamamıştır."));

        Bootcamp bootcampToUpdate = modelMapperService.forRequest().map(foundBootcamp,Bootcamp.class);

        foundBootcamp.setName(bootcampToUpdate.getName() != null ? bootcampToUpdate.getName() : foundBootcamp.getName());
        foundBootcamp.setInstructor(bootcampToUpdate.getInstructor() != null ? bootcampToUpdate.getInstructor() : foundBootcamp.getInstructor());
        foundBootcamp.setStartDate(bootcampToUpdate.getStartDate() != null ? bootcampToUpdate.getStartDate() : foundBootcamp.getStartDate());
        foundBootcamp.setEndDate(bootcampToUpdate.getEndDate() != null ? bootcampToUpdate.getEndDate() : foundBootcamp.getEndDate());
        foundBootcamp.setBootcampState(bootcampToUpdate.getBootcampState() != null ? bootcampToUpdate.getBootcampState() : foundBootcamp.getBootcampState());
        foundBootcamp.setUpdateTime(LocalDateTime.now());
        bootcampRepository.save(foundBootcamp);

        bootcampRepository.save(bootcampToUpdate);

        UpdateBootcampResponse response = modelMapperService.forResponse()
                .map(foundBootcamp,UpdateBootcampResponse.class);

        return new SuccessDataResult<UpdateBootcampResponse>
                (response,"Güncelleme başarıyla gerçekleşti.");
    }

    @Override
    public DataResult<?> deletedByIdBootcamp(
            final Integer id
    ) {
        bootcampRepository.deleteById(id);
        return new SuccessDataResult("İlgili ID'e sahip başvuran silindi.");
    }
}
