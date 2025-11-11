# MongoDB Notes
MongoDB bir NoSQL (Not only SQL) veritabanı yönetim sistemidir ve belge odaklı bir yapıya sahiptir. Geleneksel ilişkisel veritabanlarından farklı olarak, MongoDB verileri JSON benzeri belgeler (BSON formatında) olarak depolar. Bu, esnek veri modelleri oluşturmayı ve hızlı geliştirme süreçlerini destekler. 

## Temel Bileşenler
- **Veritabanı (Database)**: MongoDB'de veriler veritabanlarında saklanır. Bir MongoDB sunucusu birden fazla veritabanını barındırabilir.
- **Koleksiyon (Collection)**: Veritabanları, koleksiyonlar içerir. Koleksiyonlar, ilişkisel veritabanlarındaki tablolar gibi düşünülebilir, ancak koleksiyonlar şemaya bağlı değildir ve farklı yapıda belgeler içerebilir.
- **Belge (Document)**: Koleksiyonlar, belgelerden oluşur. Belgeler, key value çiftlerinden oluşan JSON benzeri yapılardır. Her belge benzersiz bir `_id` alanına sahiptir.

> Belgeler dinamik şemalara sahip olduğundan, aynı koleksiyondaki belgeler farklı alanlara sahip olabilir.

## Kurulum
MongoDB'yi kurmak için resmi web sitesinden (https://www.mongodb.com/products/self-managed/community-edition) uygun sürümü indirip kurabilirsiniz. Kurulum tamamlandıktan sonra, MongoDB sunucusunu başlatmak için terminal veya komut istemcisinde `mongod` komutunu kullanabilirsiniz.
## Temel Komutlar
- **MongoDB Shell'e Bağlanma**: `mongosh` komutunu kullanarak MongoDB shell'e bağlanabilirsiniz.
- **Veritabanı Oluşturma**: `use veritabani_adi` komutuyla yeni bir veritabanı oluşturabilirsiniz.
- **Koleksiyon Oluşturma**: `db.createCollection("koleksiyon_adi")` komutuyla yeni bir koleksiyon oluşturabilirsiniz.
- **Belge Ekleme**: `db.koleksiyon_adi.insertOne({alan1: "deger1", alan2: "deger2"})` komutuyla koleksiyona belge ekleyebilirsiniz.
- **Belge Sorgulama**: `db.koleksiyon_adi.find({alan1: "deger1"})` komutuyla belirli kriterlere uyan belgeleri sorgulayabilirsiniz.
- **Belge Güncelleme**: `db.koleksiyon_adi.updateOne({alan1: "deger1"}, {$set: {alan2: "yeni_deger"}})` komutuyla belgeleri güncelleyebilirsiniz.
- **Belge Silme**: `db.koleksiyon_adi.deleteOne({alan1: "deger1"})` komutuyla belgeleri silebilirsiniz.

## Komut Örnekleri
```java
// Veritabanı seçme veya oluşturma
use myDatabase
// Koleksiyon oluşturma
db.createCollection("myCollection")
// Belge ekleme
db.myCollection.insertOne({name: "John", age: 30, city: "New York"})
db.myCollection.insertMany([
  {name: "Jane", age: 25, city: "Los Angeles"},
  {name: "Mike", age: 32, city: "Chicago"}
])
// Tüm belgeleri listeleme
db.myCollection.find()
// Belge sorgulama
db.myCollection.find({name: "John"})
db.myCollection.findOne({age: {$gt: 28}})
db.myCollection.find({city: "New York", age: {$lt: 35}}) // virgül ile AND işlemi
db.myCollection.find({city: "New York"}, {age: {$lt: 30}}) // curly parantez + virgül ile OR işlemi
db.myCollection.find({$or: [{city: "New York"}, {age: {$lt: 30}}]}) // $or operatörü ile OR işlemi
db.myCollection.find({$and: [{city: "New York"}, {age: {$gt: 25}}]}) // $and operatörü ile AND işlemi
db.myCollection.find({age: {$in: [25, 30]}}) // Belirli değerleri içeren belgeleri bulma
db.myCollection.find({age: {$nin: [25, 30]}}) // Belirli değerleri içermeyen belgeleri bulma
db.myCollection.findOne({_id: ObjectId("belge_idsi")}) // Belge kimliğine göre sorgulama
// Belge sayısını sayma
db.myCollection.countDocuments({age: {$gte: 30}})
// Belge sıralama  
db.myCollection.find().sort({age: -1}) // Yaşa göre azalan sırada
// Belge güncelleme
db.myCollection.updateOne({name: "John"}, {$set: {age: 31}})
db.myCollection.updateMany({city: "New York"}, {$inc: {age: 1}})
db.myCollection.replaceOne({name: "Jane"}, {name: "Jane", age: 26, city: "San Francisco"})
db.myCollection.updateOne({name: "Mike"}, {$unset: {city: ""}}) // Belge alanını silme
db.myCollection.updateOne({name: "John"}, {$rename: {age: "years"}}) // Belge alan adını değiştirme
db.myCollection.updateOne({name: "John"}, {$min: {age: 29}}) // age alanını 29'dan küçükse 29 yapar
db.myCollection.updateOne({name: "John"}, {$max: {age: 35}}) // age alanını 35'ten büyükse 35 yapar
db.myCollection.updateOne({name: "John"}, {$push: {hobbies: "reading"}}) // Array alanına eleman ekleme
db.myCollection.updateOne({name: "John"}, {$pop: {hobbies: 1}}) // Array alanından son elemanı çıkarma
db.myCollection.updateOne({name: "John"}, {$pull: {hobbies: "reading"}}) // Array alanından belirli bir elemanı çıkarma
// Belge silme
db.myCollection.deleteOne({name: "John"})
db.myCollection.deleteMany({age: {$lt: 30}})
```

- Array yada object gibi türleri de belge içinde kullanabilirsiniz. Bunlar nested (iç içe) yapılar oluşturmanıza da olanak tanır:
```java
db.myCollection.insertOne({
  name: "Alice",
  age: 28,
  hobbies: ["reading", "traveling", "swimming"],
  address: {
    street: "123 Main St",
    city: "Wonderland",
    zip: "12345"
  }
  nestedField: {
    subField1: {
      subSubField: "value1",
      arrayField: [1, 2, 3]
    },
    subField2: "value2"
  }
})
db.myCollection.find({hobbies: "traveling"}) // Array içinde sorgulama
db.myCollection.find({"address.city": "Wonderland"}) // Nested object içinde sorgulama  
```

- export collerction to json file:
```java
mongoexport --db myDatabase --collection myCollection --out myCollection.json
```

## İndeksleme
MongoDB, sorgu performansını artırmak için indeksleme desteği sunar. İndeksler, belirli alanlarda hızlı arama yapmayı sağlar. İndeks oluşturmak için `db.koleksiyon_adi.createIndex({alan: 1})` komutunu kullanabilirsiniz. Burada `1` artan sırayı, `-1` ise azalan sırayı temsil eder.