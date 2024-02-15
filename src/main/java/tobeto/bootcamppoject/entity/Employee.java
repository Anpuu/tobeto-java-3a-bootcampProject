package tobeto.bootcamppoject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tobeto.bootcamppoject.core.entities.MyUser;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="employees" )
@EqualsAndHashCode(callSuper = true)
public class Employee extends MyUser<Integer> {
    @Column(name="position")
    private String position;
   /* @OneToMany(mappedBy = "employee")//bir çalışanın birden fazla başvurusu olabilir
    private List<Applicant> applicants;*/
}
