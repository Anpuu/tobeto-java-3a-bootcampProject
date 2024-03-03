package tobeto.bootcamppoject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tobeto.bootcamppoject.core.entities.BaseEntity;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bootcamp")
@EqualsAndHashCode(callSuper = true)
public class Bootcamp extends BaseEntity<Integer> {

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "instructorId")
    private Instructor instructor;


    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "bootcampStateId")
    private BootcampState bootcampState;
}
