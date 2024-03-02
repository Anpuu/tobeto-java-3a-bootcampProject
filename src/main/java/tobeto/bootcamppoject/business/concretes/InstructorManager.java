package tobeto.bootcamppoject.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.InstructorService;
import tobeto.bootcamppoject.business.dto.create.instructor.request.InstructorCreateRequest;
import tobeto.bootcamppoject.business.dto.create.instructor.response.InstructorCreateResponse;
import tobeto.bootcamppoject.business.dto.get.instructor.InstructorGetAllResponse;
import tobeto.bootcamppoject.business.dto.get.instructor.InstructorGetByIdResponse;
import tobeto.bootcamppoject.business.dto.update.instructor.request.InstructorUpdateRequest;
import tobeto.bootcamppoject.business.dto.update.instructor.response.InstructorUpdateResponse;
import tobeto.bootcamppoject.core.results.DataResult;
import tobeto.bootcamppoject.core.results.success.SuccessDataResult;
import tobeto.bootcamppoject.core.utilities.modelmapper.ModelMapperService;
import tobeto.bootcamppoject.dataAccess.abstracts.InstructorRepository;
import tobeto.bootcamppoject.entity.Instructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InstructorManager implements InstructorService {

    private final InstructorRepository instructorRepository;

    private final ModelMapperService modelMapperService;

    @Override
    public DataResult<InstructorCreateResponse> create(
            final InstructorCreateRequest instructorCreateRequest
    ) {
        Instructor instructorToBeSave = modelMapperService.forRequest()
                .map(instructorCreateRequest, Instructor.class);

        instructorRepository.save(instructorToBeSave);

        InstructorCreateResponse response = modelMapperService.forResponse()
                .map(instructorToBeSave, InstructorCreateResponse.class);

        return new SuccessDataResult<InstructorCreateResponse>(response,"Eğitmen kaydedildi.");
    }

    @Override
    public DataResult<InstructorGetByIdResponse> getById(
            final Integer instructorID
    ) {

        Instructor gettingById = instructorRepository.findById(instructorID)
                .orElseThrow(() -> new RuntimeException("Bu ID'e sahip bir Eğitmen bulunamadı...!"));

        InstructorGetByIdResponse response = modelMapperService
                .forResponse().map(gettingById, InstructorGetByIdResponse.class);

        return new SuccessDataResult<InstructorGetByIdResponse>(response,"ID'e Sahip eğitmen getirildi.");
    }

    @Override
    public DataResult<List<InstructorGetAllResponse>> getAll() {

        List<Instructor> instructors = instructorRepository.findAll();

        List<InstructorGetAllResponse> instructorGetAllResponses =
                instructors.stream().map(instructor -> modelMapperService
                        .forResponse().map(instructor,InstructorGetAllResponse.class))
                        .collect(Collectors.toList());

        return new SuccessDataResult<List<InstructorGetAllResponse>>(instructorGetAllResponses,"Tüm eğitmenler listelendi.");
    }

    @Override
    public DataResult<InstructorUpdateResponse> updateInstructor(
           final InstructorUpdateRequest request,
           final Integer id
    ) {
        Instructor foundInstructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bu ID'e sahip Eğitmen bulunamadı."));

        Instructor instructorToUpdate = modelMapperService.forResponse().map(request,Instructor.class);

        foundInstructor.setId(id);
        foundInstructor.setUpdateTime(LocalDateTime.now());
        foundInstructor.setUserName(instructorToUpdate.getUserName() != null ? instructorToUpdate.getUserName() : foundInstructor.getUserName());
        foundInstructor.setFirstName(instructorToUpdate.getFirstName() != null ? instructorToUpdate.getFirstName() : foundInstructor.getFirstName());
        foundInstructor.setLastName(instructorToUpdate.getLastName() != null ? instructorToUpdate.getLastName() : foundInstructor.getLastName());
        foundInstructor.setCompanyName(instructorToUpdate.getCompanyName() != null ? instructorToUpdate.getCompanyName() : foundInstructor.getCompanyName());
        foundInstructor.setNationalIdentity(instructorToUpdate.getCompanyName() != null ? instructorToUpdate.getCompanyName() : foundInstructor.getCompanyName());
        foundInstructor.setDateOfBirth(instructorToUpdate.getDateOfBirth() != null ? instructorToUpdate.getDateOfBirth() : foundInstructor.getDateOfBirth());

        instructorRepository.save(instructorToUpdate);
        InstructorUpdateResponse instructorResponse = modelMapperService.forResponse().map(foundInstructor,InstructorUpdateResponse.class);

        return new SuccessDataResult<InstructorUpdateResponse>(instructorResponse,"Eğitmen güncellendi.");
    }

    @Override
    public DataResult<?> deletedInstructorById(Integer id) {
        instructorRepository.deleteById(id);
        return new SuccessDataResult("Eğitmen başarılı şekilde silindi.");
    }
}
