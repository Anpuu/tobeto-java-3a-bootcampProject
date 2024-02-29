package tobeto.bootcamppoject.wepapi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcamppoject.business.abstracts.InstructorService;
import tobeto.bootcamppoject.business.dto.create.instructor.request.InstructorCreateRequest;
import tobeto.bootcamppoject.business.dto.create.instructor.response.InstructorCreateResponse;
import tobeto.bootcamppoject.business.dto.get.instructor.InstructorGetByIdResponse;

@RestController
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @PostMapping
    public InstructorCreateResponse create(
          @RequestBody final InstructorCreateRequest instructorCreateRequest
    ){
        return instructorService.create(instructorCreateRequest);
    }

    @GetMapping("/{id}")
    public InstructorGetByIdResponse getById(
           @PathVariable Integer id
    ){
       return instructorService.getById(id);
    }
}
