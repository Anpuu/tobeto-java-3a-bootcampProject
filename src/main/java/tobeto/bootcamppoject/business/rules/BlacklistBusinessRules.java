package tobeto.bootcamppoject.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.core.exceptions.types.BusinessException;
import tobeto.bootcamppoject.dataAccess.abstracts.BlacklistRepository;
import tobeto.bootcamppoject.entity.Blacklist;

@Service
@AllArgsConstructor
public class BlacklistBusinessRules {

    private BlacklistRepository blacklistRepository;

    public void checkIfApplicantInBlacklist(int id) {
        Blacklist blacklist = blacklistRepository.getByApplicantId(id);
        if (blacklist != null) {
            throw new BusinessException("This applicant is already in blacklist!");
        }
    }
}
