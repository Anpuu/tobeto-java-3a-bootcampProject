package tobeto.bootcamppoject.wepapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tobeto.bootcamppoject.dataAccess.abstracts.ApplicantRepository;
import tobeto.bootcamppoject.entity.Applicant;

import java.util.List;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {
    private ApplicantRepository applicantRepository;

    public ApplicantController(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @RequestMapping("/save")
    public Applicant applicant() {
        Applicant applicant=new Applicant();
        applicant.setUserName("Anpu");
        applicant.setFirstName("ismail");
        applicant.setLastName("bayraktar");
        applicant.setEmail("ismailbayraktar@gmail.com");
        applicant.setAbout("Çok zorlanıyorum, Herşey çok karışık ve zor.");
        applicant.setPassword("88888888");
        applicantRepository.save(applicant);
        return applicant;

    }

    @RequestMapping("/getall")
    public List<Applicant> findAll() {
        List<Applicant> applicants=applicantRepository.findAll();
        return applicants;
    }



}
