package tobeto.bootcamppoject.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.InstructorService;
import tobeto.bootcamppoject.business.dto.create.instructor.request.InstructorCreateRequest;
import tobeto.bootcamppoject.business.dto.create.instructor.response.InstructorCreateResponse;
import tobeto.bootcamppoject.business.dto.get.instructor.InstructorGetByIdResponse;
import tobeto.bootcamppoject.core.utilities.modelmapper.ModelMapperService;
import tobeto.bootcamppoject.dataAccess.abstracts.InstructorRepository;
import tobeto.bootcamppoject.entity.Instructor;

@Service
@RequiredArgsConstructor
public class InstructorManager implements InstructorService {

    private final InstructorRepository instructorRepository;

    private final ModelMapperService modelMapperService;

    @Override
    public InstructorCreateResponse create(
            final InstructorCreateRequest instructorCreateRequest
    ) {
        Instructor instructorToBeSave = modelMapperService.forRequest()
                .map(instructorCreateRequest, Instructor.class);

        instructorRepository.save(instructorToBeSave);

        InstructorCreateResponse response = modelMapperService.forResponse()
                .map(instructorToBeSave, InstructorCreateResponse.class);

        return response;
    }

    @Override
    public InstructorGetByIdResponse getById(
            final Integer instructorID
    ) {

        Instructor gettingById = instructorRepository.findById(instructorID)
                .orElseThrow(() -> new RuntimeException("Bu ID'e sahip bir Eğitmen bulunamadı...!"));

        InstructorGetByIdResponse response = modelMapperService
                .forResponse().map(gettingById, InstructorGetByIdResponse.class);

        return response;
    }
}
