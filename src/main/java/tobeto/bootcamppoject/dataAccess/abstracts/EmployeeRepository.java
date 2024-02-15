package tobeto.bootcamppoject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcamppoject.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
