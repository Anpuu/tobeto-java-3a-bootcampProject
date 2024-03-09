package tobeto.bootcamppoject.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.EmployeeService;
import tobeto.bootcamppoject.business.dto.create.employee.request.CreateEmployeeRequest;
import tobeto.bootcamppoject.business.dto.create.employee.response.CreateEmployeeResponse;
import tobeto.bootcamppoject.business.dto.get.employee.GetAllEmployeeResponse;
import tobeto.bootcamppoject.business.dto.get.employee.GetByIdEmployeeResponse;
import tobeto.bootcamppoject.business.dto.get.employee.GetByPositionEmployeeResponse;
import tobeto.bootcamppoject.business.dto.update.employee.request.UpdateEmployeeRequest;
import tobeto.bootcamppoject.business.dto.update.employee.response.UpdateEmployeeResponse;
import tobeto.bootcamppoject.core.utilities.results.DataResult;
import tobeto.bootcamppoject.core.utilities.results.success.SuccessDataResult;
import tobeto.bootcamppoject.core.utilities.modelmapper.ModelMapperService;
import tobeto.bootcamppoject.dataAccess.abstracts.EmployeeRepository;
import tobeto.bootcamppoject.entity.Employee;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeManager implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ModelMapperService modelMapperService;

    @Override
    public DataResult<CreateEmployeeResponse> create(final CreateEmployeeRequest createEmployeeRequest) {

        Employee employeeToBeCreat = modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);

        employeeRepository.save(employeeToBeCreat);

        CreateEmployeeResponse response = modelMapperService.forResponse().map(employeeToBeCreat, CreateEmployeeResponse.class);

        return new SuccessDataResult<CreateEmployeeResponse>(response, "Çalışan başarılı bir şekilde oluşturulmuştur.");
    }

    @Override
    public DataResult<GetByIdEmployeeResponse> getById(Integer employeeID) {

        Employee employeeGettingById = employeeRepository.findById(employeeID).orElseThrow(() -> new RuntimeException("İlgili ID'e sahip çalışan getirilmiştir."));

        GetByIdEmployeeResponse response = modelMapperService.forResponse().map(employeeGettingById, GetByIdEmployeeResponse.class);

        return new SuccessDataResult<GetByIdEmployeeResponse>(response, "Bu ID'e ait bir çalışan bulunamadı.");
    }

    @Override
    public DataResult<List<GetAllEmployeeResponse>> getAll() {

        List<Employee> employees = employeeRepository.findAll();

        List<GetAllEmployeeResponse> getAllEmployeeRespons = employees.stream().map(employee -> modelMapperService.forResponse().map(employee, GetAllEmployeeResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<>(getAllEmployeeRespons, "Tüm çalışanlar listelendi.");
    }

    @Override
    public DataResult<List<GetByPositionEmployeeResponse>> getEmployeeByPosition(
            final String position
    ) {

        List<Employee> listedEmployeeByPosition = employeeRepository.findAllByPosition(position);

        List<GetByPositionEmployeeResponse> response = listedEmployeeByPosition.stream()
                .map(employee -> modelMapperService.forResponse()
                        .map(employee, GetByPositionEmployeeResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<>(response, "Pozisyona göre employeler listelenmiştir.");
    }

    @Override
    public DataResult<UpdateEmployeeResponse> updateByIdEmployee(UpdateEmployeeRequest request, Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();

        Employee updatedEmployee = modelMapperService.forRequest().map(request, Employee.class);


        employee.setUpdateTime(LocalDateTime.now());
        employee.setFirstName(updatedEmployee.getFirstName() != null ? updatedEmployee.getFirstName() : employee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName() != null ? updatedEmployee.getLastName() : employee.getLastName());
        employee.setUserName(updatedEmployee.getUserName() != null ? updatedEmployee.getUserName() : employee.getUserName());
        employee.setNationalIdentity(updatedEmployee.getNationalIdentity() != null ? updatedEmployee.getNationalIdentity() : employee.getNationalIdentity());
        employee.setDateOfBirth((updatedEmployee.getDateOfBirth() != null ? updatedEmployee.getDateOfBirth() : employee.getDateOfBirth()));
        employee.setPosition(updatedEmployee.getPosition() != null ? updatedEmployee.getPosition() : employee.getPosition());

        employeeRepository.save(employee);
        UpdateEmployeeResponse response = modelMapperService.forResponse().map(employee, UpdateEmployeeResponse.class);

        return new SuccessDataResult<>(response, "Employee Updated");
    }

    @Override
    public DataResult<?> deleteEmployeeById(final Integer id) {

        employeeRepository.deleteById(id);
        return new SuccessDataResult("Employe Deleted");
    }


}
