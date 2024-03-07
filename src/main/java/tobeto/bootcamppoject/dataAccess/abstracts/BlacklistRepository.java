package tobeto.bootcamppoject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcamppoject.entity.Blacklist;

public interface BlacklistRepository extends JpaRepository<Blacklist, Integer> {
    Blacklist getById(int id);
    Blacklist getByApplicantId(int id);
}
