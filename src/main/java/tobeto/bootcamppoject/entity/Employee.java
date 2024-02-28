package tobeto.bootcamppoject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tobeto.bootcamppoject.core.entities.BaseEntity;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="employees" )
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "user_id")
public class Employee extends User{

    @Column(name="position")
    private String position;

}
