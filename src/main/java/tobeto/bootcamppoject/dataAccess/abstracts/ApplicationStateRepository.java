package tobeto.bootcamppoject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcamppoject.entity.ApplicationState;

public interface ApplicationStateRepository extends JpaRepository<ApplicationState,Integer> {
}
