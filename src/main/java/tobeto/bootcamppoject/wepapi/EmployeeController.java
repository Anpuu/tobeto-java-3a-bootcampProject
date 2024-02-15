package tobeto.bootcamppoject.wepapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tobeto.bootcamppoject.dataAccess.abstracts.EmployeeRepository;
import tobeto.bootcamppoject.entity.Employee;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping("/save")
    public Employee employee() {
        Employee employee = new Employee();
        employee.setUserName("ismail");
        employee.setFirstName("ismail");
        employee.setLastName("bayraktar");
        employee.setEmail("ismail@gmail.com");
        employee.setPosition("Dev.");
        employee.setPassword("888888888");
        employeeRepository.save(employee);
        return employee;
    }

    @RequestMapping("/getall")
    public List<Employee> findAll(){
        return  employeeRepository.findAll();
    }

}
