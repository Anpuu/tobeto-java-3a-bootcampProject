package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.Employee.request.EmployeeCreateRequest;
import tobeto.bootcamppoject.business.dto.Employee.response.EmployeeCreateResponse;

public interface EmployeeService {
    EmployeeCreateResponse create(EmployeeCreateRequest employeeCreateRequest);
}
