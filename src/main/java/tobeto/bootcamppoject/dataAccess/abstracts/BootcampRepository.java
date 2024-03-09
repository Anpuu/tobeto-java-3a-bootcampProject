package tobeto.bootcamppoject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcamppoject.entity.Bootcamp;

import java.util.List;

public interface BootcampRepository extends JpaRepository<Bootcamp,Integer> {
    Bootcamp getById(int id);

    List<Bootcamp> getAllByInstructorId(int id);

    List<Bootcamp> getAllByBootcampStateId(int id);
}
