package tobeto.bootcamppoject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcamppoject.entity.Bootcamp;

public interface BootcampRepository extends JpaRepository<Bootcamp,Integer> {
}
