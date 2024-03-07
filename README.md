## TOBETO JAVA 3A BOOTCAMP PROJECT<br>
Bu repository, Tobeto kurumunda verilen ödevlerin yapıldığı bir projeyi içermektedir.<br>

## Yapılanlar:<br>

### 1. Ödev: <br>

- Spring Boot projesi oluşturuldu ve geliştirildi.
- entities katmanında User, Instructor, Applicant ve Employee sınıfları oluşturuldu.
- Her sınıf için ilgili alanlar tanımlandı.
- Kalıtım (inheritance) konusu kullanılarak Instructor, Applicant ve Employee sınıfları User sınıfından türetilerek oluşturuldu.
- Entity'lerin veritabanına migration işlemleri gerçekleştirildi.
- dataaccess katmanında repository sınıfları yazıldı.
- Request-Response patterni hakkında araştırma yapıldı.
- @EqualsAndHashCode, @PrimaryKeyJoinColumn, @MappedSuperClass, @Inheritance gibi anotasyonlar hakkında araştırma yapıldı ve kullanıldı.

### 2. Ödev:<br>
- ModelMapper implementasyonu projeye entegre edildi.
- Her entity için CRUD operasyonları yazıldı.
- Her entity için özel operasyonlar repository içinde field alanlarına göre eklenerek business katmanında kullanıldı.
- Exception kavramı araştırıldı.

### 3. Ödev:
- Results yapısı projeye entegre edildi.
- Entities katmanına isterdeki sınıflar eklendi.
- İlgili sınıflar için crud operasyonları yazılıyor..(henüz bitmedi...)

### 4.Ödev
- exeption yapısı eklenmedi eklenecek..
- Blacklist sınıfı eklendi.
- Blacklist crud yazıldı
- Business logic yazılacak...

### 5.Ödev
- Validasyon eklenecek.

### 6.Ödev
- Logging projeye eklendi Loglama için mongoDb kuruldu ve veritabanında yapılan loglama ile ilgili detaylar kaydedildi.

  
### 7.Ödev
- Docker Kurulumu gerçekleştirildi.
- docker-compose.yml oluşturuldu ve postgreSQL container konfigurasyonu yazıldı ve " bootcampDb " adında otomatik db oluşacak şekilde ayarlandı.
- docker üzerinde oluşan database sunucusuna migration yapıldı.
- docker-compose.yml içerisine mongoDb konfigurasyonu eklendi ve oluşturuldu.
- Loglama docker üzerinden oluşturulan mongodb sunucusuna bağlanıldı ve " TobetoLog " adında otomatik db oluşacak şekilde ayarlandı.
  
  
#### Ayrıca, projeyi test etmek için Postman koleksiyon dosyası da repoya eklenmiştir.<br>

#### Projeye Swagger eklenmiştir. http://localhost:8080/swagger-ui/index.html# adresinden ulaşıp denemelerinizi yapabilirsiniz.<br>

#### Proje detaylarına ve kodlara erişmek için tobeto-java-3a-bootcampProject reposunu ziyaret edebilirsiniz.

#### Database olarak postgreSQL Loglama için ise MongoDb kullanılmıştır. Son ödevlerden sonra proje docker üzerinden çalışacak şekilde docker-compose.yml eklenmiştir Projeyi çalıştırmak için;
- resources paketi altında -> application.properties dosyası içerisinde ki ayarları kendinize göre güncellemeniz gerekmektedir.

## Katkıda bulunmak veya projeyi kullanmak için benimle iletişime geçebilirsiniz.


### Docker

![image](https://github.com/Anpuu/tobeto-java-3a-bootcampProject/assets/71339489/5a405eab-7f53-4062-978c-c45b0bc5158b)



### MongoDB Log

![image](https://github.com/Anpuu/tobeto-java-3a-bootcampProject/assets/71339489/cdb3bf0c-3d69-4893-a608-a86430a98d23)



### DBeaver Migration

![image](https://github.com/Anpuu/tobeto-java-3a-bootcampProject/assets/71339489/9a67811e-d1f8-49f3-acf9-3895ec009238)

