package tobeto.bootcamppoject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto.bootcamppoject.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User getByEmail(String email);
}
