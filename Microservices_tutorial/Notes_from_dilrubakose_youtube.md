# Mikroservisler
__Monolitik:__ uygulamanın sunduğu bütün servisler `single deployable unit` içerisinde bulunuyor.

__SingleDeployableUnit:__ Bir e-ticaret uygulaması düşün. Kullanıcıların talep ettiği servisler _request per second (rps)_ cinsinden birbirinden ayrılacaktır. Çok fazla request alan bir servisi çoklamak istediğinde tüm single deployable unit'i çoklmak gerekecek _(scaling problem)_. 

__Microservis:__ Bu mimaride sunulan her servis _decoupled_ olarak geliştirilmiştir. Servislerin deploymentları biribirinden bağımsızdır. Her servis kendi görevinden sorumludur _(**S**OLID)_. Her servisin görevi ayrı ve bellidir. Yüksek rps'li servisler bireysel olarak instance edilerek scaling yapılabilir.

Bu mimaride her servise ihtiyaç duyduğu kaynak ayrı ayrı allocate edilebildiği için cost saving yapmış olursun.

Bir diğer avantaj ise _fault isolation_. Bir serviste meydana gelebilecek bir hata sadece onu ilgilendirecektir.    

Dezavantajların başında ise mikroservisler arasında bir çağrı maliyeti gelir.

__API Gateway:__ Client isteklerini mikroservislere yönlendirmeyi yönettiğimiz proxy katmandır.

## Örnek: Bir E-Ticaret Sitesini için Sistem Tasarımı
__Functional Requirements__: 
- __Register / Login:__ (_Customer Authentication Service_) Müşterinin sadece email ve password gibi giriş yapmasını sağlayacak bilgileri DB'de tutulacak ve servis bir JWT token dönecek.
- __Ürün Listeleme:__ (_Product Service_) Ürün açıklaması, title, ürün görselleri gibi veriler tutulacak. Ürün bilgilerinin çok sık değişmeyeceğini öngörerek DB ile servis arasına bir cache ekleyerek yanıt süresi kısaltılabilir. Bu servisin en çok request alacak servis olmasını bekliyoruz. Ürün görsellerini ayrı bir storage'da tutup, bunların linklerini DB'ye yazarak daha verimli bir tasarım yapılabilir.
- __Sepete Ekleme__
- __Sipariş Oluşturma:__ (_Order Service_) Sipariş oluşturma ve DB'ye ekleme
- __Sipariş Listeleme:__ (_Order Service_) Belirli bir customer için DB sorgusu yapıp sonuları görüntüleme
- __Sipariş Onaylama:__ (_Notification Service_) Bir sipariş oluşturulduğunda müşteriye sipariş bilgilerini mail atacak. Dışarıdan request alması planlanmayan bir servis.

__Amazon API Gateway (AWS):__ Kullanıcı isteklerinin geldiği, ihtiyaca göre konfigüre edilebilir bir bileşen

__Elastic Load Balance (AWS):__ İsteklerin servislere uygun yükle dağıtımını kontrol ettiğimiz bileşen.

__Dependencies:__ Spring Data JPA (database için), Spring Web (Web API'lar için), Spring Boot Dev Tools, Spring Data Reactive Redis (Cache için), Spring Security, Spring for Apache Kafka (messaging için). Bunlar start.spring.io adresinden konfigure edilip indirilebilir.