package tobeto.bootcamppoject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcamppoject.entity.Application;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    Application getById(int id);

    List<Application> getAllByApplicationStateId(int id);
}
