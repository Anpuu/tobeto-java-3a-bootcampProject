package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.create.employee.request.EmployeeCreateRequest;
import tobeto.bootcamppoject.business.dto.create.employee.response.EmployeeCreateResponse;
import tobeto.bootcamppoject.business.dto.get.employee.EmployeeGetAllResponse;
import tobeto.bootcamppoject.business.dto.get.employee.EmployeeGetByIdResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeCreateResponse create(EmployeeCreateRequest employeeCreateRequest);

    EmployeeGetByIdResponse getById(Integer employeeID);

    List<EmployeeGetAllResponse> getAll();
}
