package tobeto.bootcamppoject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcamppoject.entity.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
}
