package tobeto.bootcamppoject.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.core.exceptions.types.BusinessException;
import tobeto.bootcamppoject.dataAccess.abstracts.ApplicationRepository;
import tobeto.bootcamppoject.entity.Application;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationBusinessRules {

    private ApplicationRepository applicationRepository;

    public void checkIfApplicationStateInUse(int id) {
        List<Application> applications = applicationRepository.getAllByApplicationStateId(id);
        if (!applications.isEmpty()) {
            throw new BusinessException("This application state has application(s) and can not be deleted!");
        }
    }
}
