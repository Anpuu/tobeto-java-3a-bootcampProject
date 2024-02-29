package tobeto.bootcamppoject.wepapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcamppoject.business.abstracts.InstructorService;
import tobeto.bootcamppoject.business.dto.create.instructor.request.InstructorCreateRequest;
import tobeto.bootcamppoject.business.dto.create.instructor.response.InstructorCreateResponse;
import tobeto.bootcamppoject.business.dto.get.instructor.InstructorGetAllResponse;
import tobeto.bootcamppoject.business.dto.get.instructor.InstructorGetByIdResponse;

import java.util.List;

@RestController
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorController extends BaseController {

    private final InstructorService instructorService;

    @PostMapping
    public ResponseEntity<?> create(
          @RequestBody final InstructorCreateRequest instructorCreateRequest
    ){
        return handleDataResult(instructorService.create(instructorCreateRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(
           @PathVariable Integer id
    ){
       return handleDataResult(instructorService.getById(id));
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<?> getAll(){
        return handleDataResult(instructorService.getAll());
    }
}
