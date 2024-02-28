package tobeto.bootcamppoject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "applicants")
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "user_id") // nereden user_id alıyor?
public class Applicant extends User{

    @Column(name = "about")
    private String about;

}
