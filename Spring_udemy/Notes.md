# Spring Boot - Udemy Course
İki kavram önemlidir: Inversion of Control ve Dependency Injection. 
- Inversion of Control (IoC) bir nesnenin bağımlılıklarını kendisinin değil, dışarıdan bir kaynaktan alması prensibidir. Bu, nesnelerin daha gevşek bağlı olmasını sağlar ve test edilebilirliği artırır. 
- Dependency Injection (DI) ise IoC'nin bir uygulamasıdır ve bağımlılıkların nesnelere dışarıdan "enjekte" edilmesi anlamına gelir.

## File Structure
- pom.xml: Proje bağımlılıklarını ve yapılandırmalarını içerir.<dependecies> etiketi altında Spring Boot ve diğer kütüphaneler tanımlanır. Burada tanımlanan bağımlılıklar, projenin ihtiyaç duyduğu kütüphaneleri içerir ve Maven tarafından yönetilir.

- src/main/java: Java kaynak kodlarının bulunduğu dizindir. Bu dizin altında uygulamanın ana sınıfları, servisleri, denetleyicileri ve diğer bileşenleri yer alır.

- src/main/resources: Uygulamanın yapılandırma dosyaları, statik kaynaklar ve şablon dosyalarının bulunduğu dizindir. Örneğin, application.properties veya application.yml gibi yapılandırma dosyaları burada yer alır.

## Maven

Maven, Java projelerinde kullanılan bir proje yönetim ve yapılandırma aracıdır. Proje bağımlılıklarını yönetmek, derleme sürecini otomatikleştirmek ve proje yapısını standartlaştırmak için kullanılır. Maven, projenin ihtiyaç duyduğu kütüphaneleri otomatik olarak indirir ve yönetir, böylece geliştiricilerin manuel olarak kütüphane eklemesi gerekmez.

Maven, proje yapılandırmasını pom.xml dosyası aracılığıyla yapar. Bu dosyada projenin bağımlılıkları, eklentileri ve diğer yapılandırma ayarları tanımlanır. Ardından local maven repository (genellikle ~/.m2/repository dizininde bulunur) kullanılarak gerekli kütüphaneler indirilir ve projeye dahil edilir. Eğer bir kütüphane pom.xml dosyasında belirtilmişse ve local repository'de bulunmuyorsa, Maven bu kütüphaneyi central Maven repository'den indirir.

## Tomcat
Tomcat, Java Servlet ve JSP (JavaServer Pages) teknolojilerini destekleyen açık kaynaklı bir web sunucusu ve servlet konteyneridir. Spring Boot, Tomcat'i varsayılan gömülü web sunucusu olarak kullanır, bu da uygulamanın bağımsız olarak çalışabilmesini sağlar. Gömülü Tomcat sayesinde, uygulama bir WAR dosyası olarak dağıtılmak zorunda kalmadan doğrudan çalıştırılabilir. Bu, geliştirme ve dağıtım süreçlerini basitleştirir. Tomcat, HTTP isteklerini işler, servlet'leri çalıştırır ve web uygulamalarının düzgün bir şekilde çalışmasını sağlar.

IDE'de embedded Tomcat bulunmuyorsa, servers altında "Add Server" seçeneği ile Tomcat eklenebilir.

## Context ve Bean Kavramları
Spring context, Spring uygulamasının çalışma zamanında yönetilen nesnelerin (bean'lerin) yaşam döngüsünü ve yapılandırmasını yöneten bir konteynerdir. Spring context, uygulamanın ihtiyaç duyduğu bean'leri oluşturur, yapılandırır ve yönetir. Bu sayede, uygulama bileşenleri arasındaki bağımlılıklar otomatik olarak çözülür ve yönetilir. IoC container ve ApplicationContext terimleri de Spring context ile eşanlamlı olarak kullanılır.

Bean ise Spring context tarafından yönetilen nesnelerdir. Bir bean, genellikle bir sınıfın nesnesidir ve Spring tarafından oluşturulur, yapılandırılır ve yaşam döngüsü yönetilir. Bean'ler, uygulamanın farklı bileşenleri arasında veri ve işlevsellik paylaşımını sağlar. Spring context, bean'lerin oluşturulması, yapılandırılması ve yaşam döngüsünün yönetilmesi gibi görevleri üstlenir.

@configuration: Bu anotasyon, bir sınıfın Spring context tarafından yapılandırma sınıfı olarak tanımlanmasını sağlar. Bu sınıf içinde bean tanımlamaları yapılabilir.
@Bean: Bu anotasyon, bir metodun Spring context tarafından yönetilen bir bean oluşturmak için kullanılmasını sağlar. Metodun dönüş değeri, oluşturulan bean'in türünü belirler.

## Lombok
Lombok, Java projelerinde boilerplate kodunu azaltmak için kullanılan bir kütüphanedir. Lombok, anotasyonlar aracılığıyla getter, setter, toString, equals, hashCode gibi yaygın olarak kullanılan metodları otomatik olarak oluşturur. Bu sayede geliştiriciler, bu tür metodları manuel olarak yazmak zorunda kalmazlar ve kod daha temiz ve okunabilir hale gelir.

## Bean Oluşturma
@Bean anotasyonu kullanılarak bir bean oluşturulabilir. Örneğin:
```java
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
}
```
Bu örnekte, AppConfig sınıfı bir yapılandırma sınıfıdır ve myService metodu bir MyService bean'i oluşturur.


## RestAPI
RestAPI (Representational State Transfer Application Programming Interface), web tabanlı uygulamalar arasında veri alışverişi yapmak için kullanılan bir mimari tarzdır. RESTful API'ler, HTTP protokolünü kullanarak kaynaklara erişim sağlar ve genellikle JSON veya XML formatında veri döner. Spring Boot, RESTful web servisleri oluşturmak için güçlü bir altyapı sağlar.
- @RestController: Bu anotasyon, bir sınıfın RESTful web servisleri için controller olarak kullanılmasını sağlar. Bu sınıf içindeki metodlar, HTTP isteklerine yanıt verir.
- @Service: Bu anotasyon, bir sınıfın servis katmanı bileşeni olarak tanımlanmasını sağlar. Servis katmanı, business logic içerir ve genellikle veri erişim katmanı ile controller katmanı arasında yer alır.
- @Repository: Bu anotasyon, bir sınıfın veri erişim katmanı bileşeni olarak tanımlanmasını sağlar. Veri erişim katmanı, veritabanı işlemlerini gerçekleştirir.
- @Autowired: Bu anotasyon, Spring'in Dependency Injection mekanizmasını kullanarak bir bean'i başka bir bean'e enjekte etmek için kullanılır.
- @GetMapping: Bu anotasyon, bir HTTP GET isteğini belirli bir metoda yönlendirmek için kullanılır. Örneğin, bir kaynağı almak için kullanılır.
- @PostMapping: Bu anotasyon, bir HTTP POST isteğini belirli bir metoda yönlendirmek için kullanılır. Örneğin, yeni bir kaynak oluşturmak için kullanılır.

- @PathVariable: Bu anotasyon, bir URL yolundaki değişkeni bir metoda parametre olarak geçirmek için kullanılır. Örneğin, /users/{id} gibi bir URL'den id değerini almak için kullanılır.
- @RequestBody: Bu anotasyon, bir HTTP isteğinin gövdesindeki veriyi bir metoda parametre olarak geçirmek için kullanılır. Genellikle JSON formatındaki verileri almak için kullanılır.

- @RequestParam: Bu anotasyon, bir HTTP isteğinin sorgu parametrelerini bir metoda parametre olarak geçirmek için kullanılır. Örneğin, /users?name=John gibi bir URL'den name değerini almak için kullanılır.

- @RequestBody: Bu anotasyon, bir HTTP isteğinin gövdesindeki veriyi bir metoda parametre olarak geçirmek için kullanılır. 

## Spring JPA ve Hibernate
Spring JPA (Java Persistence API), Java uygulamalarında veri erişim katmanını yönetmek için kullanılan bir frameworktür. Spring JPA, JPA standartlarını kullanarak veritabanı işlemlerini kolaylaştırır ve geliştiricilerin veri erişim kodunu daha az yazmasını sağlar. Hibernate ise JPA'nın popüler bir implementasyonudur ve nesne-ilişkisel haritalama (Object Relational Mapping, ORM) işlemlerini gerçekleştirir.

### ORM
ORM (Object Relational Mapping), nesne yönelimli programlama dillerinde kullanılan nesneler ile ilişkisel veritabanlarındaki tablolar arasındaki dönüşümü sağlayan bir tekniktir. ORM, geliştiricilerin veritabanı işlemlerini nesneler üzerinden gerçekleştirmesine olanak tanır ve SQL sorgularını manuel olarak yazma ihtiyacını azaltır. Hibernate, Java için popüler bir ORM frameworküdür ve JPA standartlarını uygular.

- @Entity: Bu anotasyon, bir sınıfın veritabanı tablosu ile eşleştirilen bir varlık (entity) olduğunu belirtir. Bu sınıfın nesneleri, veritabanındaki kayıtları temsil eder.
- @Column: Bu anotasyon, bir varlık sınıfındaki bir alanın veritabanındaki bir sütun ile eşleştirildiğini belirtir. Bu anotasyon ile sütun adı, veri türü ve diğer özellikler tanımlanabilir.
- JpaRepository: Bu arayüz, Spring Data JPA tarafından sağlanan bir veri erişim arayüzüdür. JpaRepository, temel CRUD (Create, Read, Update, Delete) işlemlerini gerçekleştirmek için kullanılır ve geliştiricilerin veri erişim kodunu yazmasını büyük ölçüde azaltır. 
- @Id: Bu anotasyon, bir varlık sınıfındaki bir alanın birincil anahtar (primary key) olduğunu belirtir.
- @GeneratedValue: Bu anotasyon, birincil anahtar alanının otomatik olarak oluşturulmasını sağlar. Genellikle veritabanı tarafından otomatik artan bir değer olarak kullanılır.

> Not: Spring Boot uygulamalarında, JPA ve Hibernate kullanırken, veritabanı bağlantı bilgileri genellikle application.properties veya application.yml dosyasında yapılandırılır. Bu dosyada, veritabanı URL'si, kullanıcı adı, şifre ve diğer ilgili ayarlar tanımlanır.

## DTO
DTO (Data Transfer Object), uygulamalar arasında veri taşımak için kullanılan bir tasarım desenidir. DTO'lar, genellikle veri tabanından alınan verileri veya API istek/yanıtlarını temsil eden basit nesnelerdir. DTO'lar, veri taşıma işlemlerini optimize etmek ve gereksiz veri yükünü azaltmak için kullanılır. Örneğin, bir kullanıcı varlığı (entity) sınıfı birçok alan içerebilir, ancak bir API yanıtında yalnızca belirli alanların gönderilmesi gerekebilir. Bu durumda, bir DTO sınıfı oluşturularak sadece gerekli alanlar taşınabilir.

- @Query: Bu anotasyon, Spring Data JPA'da özel sorgular tanımlamak için kullanılır. @Query anotasyonu ile JPQL (Java Persistence Query Language) veya SQL sorguları yazılabilir ve bu sorgular belirli bir metoda atanabilir. Bu sayede, geliştiriciler karmaşık sorguları kolayca tanımlayabilir ve veri erişim işlemlerini özelleştirebilir. HQL: (Hibernate Query Language), Hibernate tarafından kullanılan bir sorgulama dilidir. HQL, SQL'e benzer bir sözdizimine sahiptir ancak nesne yönelimli programlama kavramlarını kullanır. HQL, veritabanı tabloları yerine varlık (entity) sınıfları ve onların özellikleri üzerinde sorgular yapmayı sağlar. Bu sayede, geliştiriciler veritabanı işlemlerini nesneler üzerinden gerçekleştirebilir ve SQL sorgularını manuel olarak yazma ihtiyacını azaltır. (nativeQuery=true ile SQL sorgusu da yazılabilir).