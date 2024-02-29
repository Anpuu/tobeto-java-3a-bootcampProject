package tobeto.bootcamppoject.wepapi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tobeto.bootcamppoject.business.abstracts.EmployeeService;
import tobeto.bootcamppoject.business.dto.create.employee.request.EmployeeCreateRequest;
import tobeto.bootcamppoject.business.dto.create.employee.response.EmployeeCreateResponse;
import tobeto.bootcamppoject.business.dto.get.employee.EmployeeGetByIdResponse;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeCreateResponse create(
            @RequestBody final EmployeeCreateRequest employeeCreateRequest
    ){
        return employeeService.create(employeeCreateRequest);
    }

    @GetMapping(value = "/{id}")
    public EmployeeGetByIdResponse getById(
            @PathVariable  Integer id
    ){
        return employeeService.getById(id);
    }

}
