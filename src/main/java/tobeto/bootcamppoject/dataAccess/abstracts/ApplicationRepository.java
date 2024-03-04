package tobeto.bootcamppoject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcamppoject.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application,Integer> {
}
