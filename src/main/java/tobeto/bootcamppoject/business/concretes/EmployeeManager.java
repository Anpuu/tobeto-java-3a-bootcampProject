package tobeto.bootcamppoject.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.EmployeeService;
import tobeto.bootcamppoject.business.dto.Employee.request.EmployeeCreateRequest;
import tobeto.bootcamppoject.business.dto.Employee.response.EmployeeCreateResponse;
import tobeto.bootcamppoject.core.utilities.modelmapper.ModelMapperService;
import tobeto.bootcamppoject.dataAccess.abstracts.EmployeeRepository;
import tobeto.bootcamppoject.entity.Employee;

@Service
@RequiredArgsConstructor
public class EmployeeManager implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ModelMapperService modelMapperService;

    @Override
    public EmployeeCreateResponse create(final EmployeeCreateRequest employeeCreateRequest) {

        Employee employeeToBeCreat = modelMapperService.forRequest()
                .map(employeeCreateRequest,Employee.class);

        employeeRepository.save(employeeToBeCreat);

        EmployeeCreateResponse response = modelMapperService.forResponse()
                .map(employeeToBeCreat,EmployeeCreateResponse.class);

        return response;
    }
}
