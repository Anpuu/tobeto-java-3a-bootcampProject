package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.create.employee.request.EmployeeCreateRequest;
import tobeto.bootcamppoject.business.dto.create.employee.response.EmployeeCreateResponse;
import tobeto.bootcamppoject.business.dto.get.employee.EmployeeGetByIdResponse;

public interface EmployeeService {
    EmployeeCreateResponse create(EmployeeCreateRequest employeeCreateRequest);

    EmployeeGetByIdResponse getById(Integer employeeID);
}
