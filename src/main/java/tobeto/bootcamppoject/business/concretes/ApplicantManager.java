package tobeto.bootcamppoject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tobeto.bootcamppoject.business.abstracts.ApplicantService;
import tobeto.bootcamppoject.dataAccess.abstracts.ApplicantRepository;

@Service
public class ApplicantManager implements ApplicantService {
    private ApplicantRepository applicantRepository;
    @Autowired
    public ApplicantManager(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }




}
