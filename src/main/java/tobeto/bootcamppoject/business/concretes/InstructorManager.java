package tobeto.bootcamppoject.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.InstructorService;
import tobeto.bootcamppoject.business.dto.create.instructor.request.CreateInstructorRequest;
import tobeto.bootcamppoject.business.dto.create.instructor.response.CreateInstructorResponse;
import tobeto.bootcamppoject.business.dto.get.instructor.GetAllInstructorResponse;
import tobeto.bootcamppoject.business.dto.get.instructor.GetByIdInstructorResponse;
import tobeto.bootcamppoject.business.dto.update.instructor.request.UpdateInstructorRequest;
import tobeto.bootcamppoject.business.dto.update.instructor.response.UpdateInstructorResponse;
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
    public DataResult<CreateInstructorResponse> create(
            final CreateInstructorRequest createInstructorRequest
    ) {
        Instructor instructorToBeSave = modelMapperService.forRequest()
                .map(createInstructorRequest, Instructor.class);

        instructorRepository.save(instructorToBeSave);

        CreateInstructorResponse response = modelMapperService.forResponse()
                .map(instructorToBeSave, CreateInstructorResponse.class);

        return new SuccessDataResult<CreateInstructorResponse>(response,"Eğitmen kaydedildi.");
    }

    @Override
    public DataResult<GetByIdInstructorResponse> getById(
            final Integer instructorID
    ) {

        Instructor gettingById = instructorRepository.findById(instructorID)
                .orElseThrow(() -> new RuntimeException("Bu ID'e sahip bir Eğitmen bulunamadı...!"));

        GetByIdInstructorResponse response = modelMapperService
                .forResponse().map(gettingById, GetByIdInstructorResponse.class);

        return new SuccessDataResult<GetByIdInstructorResponse>(response,"ID'e Sahip eğitmen getirildi.");
    }

    @Override
    public DataResult<List<GetAllInstructorResponse>> getAll() {

        List<Instructor> instructors = instructorRepository.findAll();

        List<GetAllInstructorResponse> getAllInstructorRespons =
                instructors.stream().map(instructor -> modelMapperService
                        .forResponse().map(instructor, GetAllInstructorResponse.class))
                        .collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllInstructorResponse>>(getAllInstructorRespons,"Tüm eğitmenler listelendi.");
    }

    @Override
    public DataResult<UpdateInstructorResponse> updateInstructor(
           final UpdateInstructorRequest request,
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

        instructorRepository.save(foundInstructor);
        UpdateInstructorResponse instructorResponse = modelMapperService.forResponse().map(foundInstructor, UpdateInstructorResponse.class);

        return new SuccessDataResult<UpdateInstructorResponse>(instructorResponse,"Eğitmen güncellendi.");
    }

    @Override
    public DataResult<?> deletedInstructorById(Integer id) {
        instructorRepository.deleteById(id);
        return new SuccessDataResult("Eğitmen başarılı şekilde silindi.");
    }
}
