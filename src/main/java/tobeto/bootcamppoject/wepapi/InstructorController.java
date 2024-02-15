package tobeto.bootcamppoject.wepapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tobeto.bootcamppoject.dataAccess.abstracts.InstructorRepository;
import tobeto.bootcamppoject.entity.Instructor;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    private InstructorRepository instructorRepository;
    public InstructorController(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


    @RequestMapping("/save")
    public Instructor instructor() {
        Instructor instructor = new Instructor();
        instructor.setUserName("ismail");
        instructor.setEmail("ismail@gmail.com");
        instructor.setCompanyName("Bayraktar CO.");
        instructorRepository.save(instructor);
        return instructor;
    }

    @RequestMapping("/getall")
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

}
