package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.create.employee.request.EmployeeCreateRequest;
import tobeto.bootcamppoject.business.dto.create.employee.response.EmployeeCreateResponse;
import tobeto.bootcamppoject.business.dto.get.employee.EmployeeGetAllResponse;
import tobeto.bootcamppoject.business.dto.get.employee.EmployeeGetByIdResponse;
import tobeto.bootcamppoject.business.dto.get.employee.EmployeeGetByPositionResponse;
import tobeto.bootcamppoject.business.dto.update.employee.request.EmployeeUpdateRequest;
import tobeto.bootcamppoject.business.dto.update.employee.response.EmployeeUpdateResponse;
import tobeto.bootcamppoject.core.results.DataResult;

import java.util.List;

public interface EmployeeService {
    DataResult<EmployeeCreateResponse> create(EmployeeCreateRequest employeeCreateRequest);

    DataResult<EmployeeGetByIdResponse> getById(Integer employeeID);

    DataResult<List<EmployeeGetAllResponse>> getAll();

    DataResult<List<EmployeeGetByPositionResponse>> getEmployeeByPosition(String position);

    DataResult<EmployeeUpdateResponse> updateByIdEmployee(EmployeeUpdateRequest employeeUpdateRequest, Integer id);

    DataResult<?> deleteEmployeeById(Integer id);
}
