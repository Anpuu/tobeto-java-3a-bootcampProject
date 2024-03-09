package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.create.instructor.request.CreateInstructorRequest;
import tobeto.bootcamppoject.business.dto.create.instructor.response.CreateInstructorResponse;
import tobeto.bootcamppoject.business.dto.get.instructor.GetAllInstructorResponse;
import tobeto.bootcamppoject.business.dto.get.instructor.GetByIdInstructorResponse;
import tobeto.bootcamppoject.business.dto.update.instructor.request.UpdateInstructorRequest;
import tobeto.bootcamppoject.business.dto.update.instructor.response.UpdateInstructorResponse;
import tobeto.bootcamppoject.core.utilities.results.DataResult;

import java.util.List;

public interface InstructorService {
    DataResult<CreateInstructorResponse> create(CreateInstructorRequest createInstructorRequest);

    DataResult<GetByIdInstructorResponse> getById(Integer instructorID);

    DataResult<List<GetAllInstructorResponse>> getAll();

    DataResult<UpdateInstructorResponse> updateInstructor(UpdateInstructorRequest request, Integer id);

    DataResult<?> deletedInstructorById(Integer id);
}
