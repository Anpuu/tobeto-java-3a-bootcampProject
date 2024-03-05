package tobeto.bootcamppoject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcamppoject.entity.BootcampState;

public interface BootcampStateRepository extends JpaRepository<BootcampState,Integer> {
}
