package tobeto.bootcamppoject.wepapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcamppoject.business.abstracts.InstructorService;
import tobeto.bootcamppoject.business.dto.create.instructor.request.InstructorCreateRequest;
import tobeto.bootcamppoject.business.dto.create.instructor.response.InstructorCreateResponse;
import tobeto.bootcamppoject.business.dto.get.instructor.InstructorGetAllResponse;
import tobeto.bootcamppoject.business.dto.get.instructor.InstructorGetByIdResponse;
import tobeto.bootcamppoject.business.dto.update.instructor.request.InstructorUpdateRequest;

import java.util.List;

@RestController
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorController extends BaseController {

    private final InstructorService instructorService;

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody final InstructorCreateRequest instructorCreateRequest
    ) {
        return handleDataResult(instructorService.create(instructorCreateRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(
            @PathVariable Integer id
    ) {
        return handleDataResult(instructorService.getById(id));
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<?> getAll() {
        return handleDataResult(instructorService.getAll());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updatedInstructor(
           @RequestBody final InstructorUpdateRequest request,
           @PathVariable final Integer id
    ) {
        return handleDataResult(instructorService.updateInstructor(request,id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletedInstructorById(@PathVariable final Integer id){
        return handleDataResult(instructorService.deletedInstructorById(id));
    }
}
