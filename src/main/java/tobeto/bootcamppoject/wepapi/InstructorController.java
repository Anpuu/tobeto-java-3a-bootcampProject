package tobeto.bootcamppoject.wepapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcamppoject.business.abstracts.InstructorService;
import tobeto.bootcamppoject.business.dto.create.instructor.request.CreateInstructorRequest;
import tobeto.bootcamppoject.business.dto.update.instructor.request.UpdateInstructorRequest;

@RestController
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorController extends BaseController {

    private final InstructorService instructorService;

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody final CreateInstructorRequest createInstructorRequest
    ) {
        return handleDataResult(instructorService.create(createInstructorRequest));
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
           @RequestBody final UpdateInstructorRequest request,
           @PathVariable final Integer id
    ) {
        return handleDataResult(instructorService.updateInstructor(request,id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletedInstructorById(@PathVariable final Integer id){
        return handleDataResult(instructorService.deletedInstructorById(id));
    }
}
