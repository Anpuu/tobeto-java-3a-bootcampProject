package tobeto.bootcamppoject.core.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private T id;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Column(name = "created_time")
    private LocalDateTime createdTime;

    @Column(name = "deleted_time")
    private LocalDateTime deletedTime;
}

/*

    Equal = içerisinde herhangi bir değer varmı diye kontrol ediyor.
    HashCode = Liste tarzı bir sınıf var. Bu veri yapılarında nesneleri saklamak ve hızlı bir şekilde verilere erişmek için kullanılıyor.
    Büyük harfler = sabit const değişkenlerde bu isimlendirme kullanır.

 */