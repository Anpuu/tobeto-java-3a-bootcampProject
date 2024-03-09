package tobeto.bootcamppoject.business.rules;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.core.exceptions.types.BusinessException;
import tobeto.bootcamppoject.dataAccess.abstracts.BootcampRepository;
import tobeto.bootcamppoject.entity.Bootcamp;

import java.util.List;

@Service
@AllArgsConstructor
public class BootcampBusinessRules {
    private BootcampRepository bootcampRepository;

    public void checkIfInstructorHasBootcamps(int id) {
        List<Bootcamp> bootcamps = bootcampRepository.getAllByInstructorId(id);
        if (!bootcamps.isEmpty()) {
            throw new BusinessException("This instructor has bootcamp(s) and can not be deleted!");
        }
    }

    public void checkIfBootcampStateInUse(int id) {
        List<Bootcamp> bootcamps = bootcampRepository.getAllByBootcampStateId(id);
        if (!bootcamps.isEmpty()) {
            throw new BusinessException("This bootcamp state has bootcamp(s) and can not be deleted!");
        }
    }
}
