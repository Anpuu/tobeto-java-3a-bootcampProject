package tobeto.bootcamppoject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tobeto.bootcamppoject.core.entities.BaseEntity;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bootcampState")
@EqualsAndHashCode(callSuper = true)
public class BootcampState extends BaseEntity<Integer> {

    @Column(name = "name")
    private String name;

    @OneToMany
    private List<Bootcamp> bootcampList;

}
