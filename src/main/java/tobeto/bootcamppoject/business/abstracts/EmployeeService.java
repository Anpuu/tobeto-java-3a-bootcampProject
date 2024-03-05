package tobeto.bootcamppoject.business.abstracts;

import tobeto.bootcamppoject.business.dto.create.employee.request.CreateEmployeeRequest;
import tobeto.bootcamppoject.business.dto.create.employee.response.CreateEmployeeResponse;
import tobeto.bootcamppoject.business.dto.get.employee.GetAllEmployeeResponse;
import tobeto.bootcamppoject.business.dto.get.employee.GetByIdEmployeeResponse;
import tobeto.bootcamppoject.business.dto.get.employee.GetByPositionEmployeeResponse;
import tobeto.bootcamppoject.business.dto.update.employee.request.UpdateEmployeeRequest;
import tobeto.bootcamppoject.business.dto.update.employee.response.UpdateEmployeeResponse;
import tobeto.bootcamppoject.core.results.DataResult;

import java.util.List;

public interface EmployeeService {
    DataResult<CreateEmployeeResponse> create(CreateEmployeeRequest createEmployeeRequest);

    DataResult<GetByIdEmployeeResponse> getById(Integer employeeID);

    DataResult<List<GetAllEmployeeResponse>> getAll();

    DataResult<List<GetByPositionEmployeeResponse>> getEmployeeByPosition(String position);

    DataResult<UpdateEmployeeResponse> updateByIdEmployee(UpdateEmployeeRequest updateEmployeeRequest, Integer id);

    DataResult<?> deleteEmployeeById(Integer id);
}
