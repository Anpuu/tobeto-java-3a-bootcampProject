package tobeto.bootcamppoject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import tobeto.bootcamppoject.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByPosition(String position);

    Employee getByEmail(@Param("email") String email);
}
