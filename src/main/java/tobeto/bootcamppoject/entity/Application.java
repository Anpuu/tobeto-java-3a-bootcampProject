package tobeto.bootcamppoject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tobeto.bootcamppoject.core.entities.BaseEntity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "application")
@EqualsAndHashCode(callSuper = true)
public class Application extends BaseEntity<Integer> {

    @ManyToOne
    @JoinColumn(name = "applicantId")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "bootcampId")
    private Bootcamp bootcamp;

    @ManyToOne
    @JoinColumn(name = "applicationStateId")
    private ApplicationState applicationState;
}