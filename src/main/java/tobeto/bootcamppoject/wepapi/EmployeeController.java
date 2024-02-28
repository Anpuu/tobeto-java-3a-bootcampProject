package tobeto.bootcamppoject.wepapi;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tobeto.bootcamppoject.business.abstracts.EmployeeService;
import tobeto.bootcamppoject.business.concretes.EmployeeManager;
import tobeto.bootcamppoject.business.dto.Employee.request.EmployeeCreateRequest;
import tobeto.bootcamppoject.business.dto.Employee.response.EmployeeCreateResponse;
import tobeto.bootcamppoject.core.utilities.modelmapper.ModelMapperService;
import tobeto.bootcamppoject.dataAccess.abstracts.EmployeeRepository;
import tobeto.bootcamppoject.entity.Employee;

import java.util.List;

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

}
