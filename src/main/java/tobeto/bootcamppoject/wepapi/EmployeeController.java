package tobeto.bootcamppoject.wepapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcamppoject.business.abstracts.EmployeeService;
import tobeto.bootcamppoject.business.dto.create.employee.request.CreateEmployeeRequest;
import tobeto.bootcamppoject.business.dto.update.employee.request.UpdateEmployeeRequest;
import tobeto.bootcamppoject.core.aspects.logging.Loggable;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController extends BaseController {

    private final EmployeeService employeeService;

    @Loggable
    @PostMapping
    public ResponseEntity<?> create(
            @RequestBody final CreateEmployeeRequest createEmployeeRequest
    ) {
        return handleDataResult(employeeService.create(createEmployeeRequest));
    }

    @Loggable
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(
            @PathVariable Integer id
    ) {
        return handleDataResult(employeeService.getById(id));
    }

    @Loggable
    @GetMapping(value = "/getall")
    public ResponseEntity<?> getAll() {
        return handleDataResult(employeeService.getAll());
    }

    @Loggable
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateByIdEmployee(
           @RequestBody final UpdateEmployeeRequest updateEmployeeRequest,
           @PathVariable final Integer id
    ) {

        return handleDataResult(employeeService.updateByIdEmployee(updateEmployeeRequest, id));
    }

    @Loggable
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletedEmployeeById(@PathVariable final Integer id){
        return handleDataResult(employeeService.deleteEmployeeById(id));
    }

    @Loggable
    @GetMapping(value = "/position/{position}")
    public ResponseEntity<?> getEmployeesByPositions(
            @PathVariable final String position
    ){
        return handleDataResult(employeeService.getEmployeeByPosition(position));
    }

}
