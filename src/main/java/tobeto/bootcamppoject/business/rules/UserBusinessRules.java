package tobeto.bootcamppoject.business.rules;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.core.exceptions.types.BusinessException;
import tobeto.bootcamppoject.dataAccess.abstracts.UserRepository;
import tobeto.bootcamppoject.entity.User;

@Service
@AllArgsConstructor
public class UserBusinessRules {

    private UserRepository userRepository;

    public void checkIfEmailExists(String email) {
        User user = userRepository.getByEmail(email.trim());
        if (user != null) {
            throw new BusinessException("This email is already used!");
        }
    }
}
