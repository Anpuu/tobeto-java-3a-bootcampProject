package tobeto.bootcamppoject.wepapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcamppoject.business.abstracts.EmployeeService;
import tobeto.bootcamppoject.business.dto.create.employee.request.EmployeeCreateRequest;
import tobeto.bootcamppoject.business.dto.update.employee.request.EmployeeUpdateRequest;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController extends BaseController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody final EmployeeCreateRequest employeeCreateRequest
    ) {
        return handleDataResult(employeeService.create(employeeCreateRequest));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(
            @PathVariable Integer id
    ) {
        return handleDataResult(employeeService.getById(id));
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<?> getAll() {
        return handleDataResult(employeeService.getAll());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateByIdEmployee(
           @RequestBody final EmployeeUpdateRequest employeeUpdateRequest,
           @PathVariable final Integer id
    ) {

        return handleDataResult(employeeService.updateByIdEmployee(employeeUpdateRequest, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletedEmployeeById(@PathVariable final Integer id){
        return handleDataResult(employeeService.deleteEmployeeById(id));
    }

    @GetMapping(value = "/position/{position}")
    public ResponseEntity<?> getEmployeesByPositions(
            @PathVariable final String position
    ){
        return handleDataResult(employeeService.getEmployeeByPosition(position));
    }

}
