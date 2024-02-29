package tobeto.bootcamppoject.wepapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcamppoject.business.abstracts.EmployeeService;
import tobeto.bootcamppoject.business.dto.create.employee.request.EmployeeCreateRequest;
import tobeto.bootcamppoject.business.dto.get.employee.EmployeeGetAllResponse;
import tobeto.bootcamppoject.business.dto.get.employee.EmployeeGetByIdResponse;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController extends BaseController{

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody final EmployeeCreateRequest employeeCreateRequest
    ){
        return handleDataResult(employeeService.create(employeeCreateRequest));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(
            @PathVariable  Integer id
    ){
        return handleDataResult(employeeService.getById(id));
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<?> getAll(){
        return handleDataResult(employeeService.getAll());
    }

}
