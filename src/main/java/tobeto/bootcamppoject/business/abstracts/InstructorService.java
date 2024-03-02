package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.create.instructor.request.InstructorCreateRequest;
import tobeto.bootcamppoject.business.dto.create.instructor.response.InstructorCreateResponse;
import tobeto.bootcamppoject.business.dto.get.instructor.InstructorGetAllResponse;
import tobeto.bootcamppoject.business.dto.get.instructor.InstructorGetByIdResponse;
import tobeto.bootcamppoject.business.dto.update.instructor.request.InstructorUpdateRequest;
import tobeto.bootcamppoject.business.dto.update.instructor.response.InstructorUpdateResponse;
import tobeto.bootcamppoject.core.results.DataResult;

import java.util.List;

public interface InstructorService {
    DataResult<InstructorCreateResponse> create(InstructorCreateRequest instructorCreateRequest);

    DataResult<InstructorGetByIdResponse> getById(Integer instructorID);

    DataResult<List<InstructorGetAllResponse>> getAll();

    DataResult<InstructorUpdateResponse> updateInstructor(InstructorUpdateRequest request,Integer id);

    DataResult<?> deletedInstructorById(Integer id);
}
