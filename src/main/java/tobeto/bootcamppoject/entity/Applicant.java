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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "applicants")
@Entity
@EqualsAndHashCode(callSuper = true)
public class Applicant extends MyUser<Integer> {
    @Column(name = "about")
    private String about;


}
