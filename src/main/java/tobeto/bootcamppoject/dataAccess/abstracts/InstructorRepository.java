package tobeto.bootcamppoject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcamppoject.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
}
