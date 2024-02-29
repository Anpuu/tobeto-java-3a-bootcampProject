package tobeto.bootcamppoject.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.EmployeeService;
import tobeto.bootcamppoject.business.dto.create.employee.request.EmployeeCreateRequest;
import tobeto.bootcamppoject.business.dto.create.employee.response.EmployeeCreateResponse;
import tobeto.bootcamppoject.business.dto.get.applicant.ApplicantGetAllResponse;
import tobeto.bootcamppoject.business.dto.get.employee.EmployeeGetAllResponse;
import tobeto.bootcamppoject.business.dto.get.employee.EmployeeGetByIdResponse;
import tobeto.bootcamppoject.core.results.DataResult;
import tobeto.bootcamppoject.core.results.success.SuccessDataResult;
import tobeto.bootcamppoject.core.utilities.modelmapper.ModelMapperService;
import tobeto.bootcamppoject.dataAccess.abstracts.EmployeeRepository;
import tobeto.bootcamppoject.entity.Employee;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeManager implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ModelMapperService modelMapperService;

    @Override
    public DataResult<EmployeeCreateResponse> create(
            final EmployeeCreateRequest employeeCreateRequest
    ) {

        Employee employeeToBeCreat = modelMapperService.forRequest()
                .map(employeeCreateRequest,Employee.class);

        employeeRepository.save(employeeToBeCreat);

        EmployeeCreateResponse response = modelMapperService.forResponse()
                .map(employeeToBeCreat,EmployeeCreateResponse.class);

        return new SuccessDataResult<EmployeeCreateResponse>(response,"Çalışan başarılı bir şekilde oluşturulmuştur.");
    }

    @Override
    public DataResult<EmployeeGetByIdResponse> getById(
            Integer employeeID
    ) {

        Employee employeeGettingById = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new RuntimeException("Bu ID'e sahip bir çalışan bulunamamıştır...!"));

        EmployeeGetByIdResponse response = modelMapperService.forResponse()
                .map(employeeGettingById,EmployeeGetByIdResponse.class);

        return new SuccessDataResult
                <EmployeeGetByIdResponse>(response,"Bu ID'e ait bir çalışan bulunamadı.");
    }

    @Override
    public DataResult<List<EmployeeGetAllResponse>> getAll() {

        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeGetAllResponse> employeeGetAllResponses =
                employees.stream().map(employee -> modelMapperService
                                .forResponse().map(employee, EmployeeGetAllResponse.class))
                        .collect(Collectors.toList());

        return new SuccessDataResult<List<EmployeeGetAllResponse>>(employeeGetAllResponses,"Tüm çalışanlar listelendi.");
    }
}
