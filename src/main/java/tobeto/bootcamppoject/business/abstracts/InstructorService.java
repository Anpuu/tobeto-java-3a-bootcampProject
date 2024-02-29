package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.create.instructor.request.InstructorCreateRequest;
import tobeto.bootcamppoject.business.dto.create.instructor.response.InstructorCreateResponse;
import tobeto.bootcamppoject.business.dto.get.instructor.InstructorGetByIdResponse;

public interface InstructorService {
    InstructorCreateResponse create(InstructorCreateRequest instructorCreateRequest);

    InstructorGetByIdResponse getById(Integer instructorID);
}
