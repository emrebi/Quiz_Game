# 📚 Quiz Game – Android Mobil Uygulama

Quiz Game, Java programlama diliyle geliştirilen, temel soru-cevap oyun mekaniğini içeren bir Android mobil uygulamasıdır. Kullanıcıya belirli bir sıra ile çoktan seçmeli sorular sunar, cevapları değerlendirir ve sonuç ekranında başarı durumunu görsel ve sayısal olarak yansıtır.

## ⚙️ Uygulama Mimarisi

Uygulama, aktivite tabanlı klasik Android yapısı ile geliştirilmiştir. Her ekran bir `Activity` sınıfı ile temsil edilmekte olup veri geçişleri `Intent` aracılığıyla sağlanmaktadır. UI bileşenleri `XML` dosyaları içinde `ConstraintLayout` temelli tasarlanmış, modern ve sade bir kullanıcı deneyimi hedeflenmiştir.

* **MainActivity.java:** Başlangıç ekranı. Oyuna giriş yapılır.
* **ContinueActivity.java:** Kullanıcıyı bilgilendiren geçiş ekranı.
* **Oyun.java:** Soruların yönetildiği, cevapların alındığı ve skorun hesaplandığı asıl oyun ekranı.
* **Sonuc.java:** Kullanıcının performansını özetleyen sonuç ekranı.

Veri modeli doğrudan Java sınıfı içinde tanımlı sabit sorularla sağlanmaktadır. Sorular bir liste olarak hafızada tutulur ve sırayla kullanıcıya sunulur. Her sorunun 4 şıkkı vardır ve doğru seçenek kontrol edilirken kullanıcıdan gelen giriş basit bir `equals()` kontrolü ile kıyaslanır.

## 🔧 Teknik Detaylar

* Proje dili: **Java**
* Minimum SDK: **21 (Android 5.0)**
* Yapı sistemi: **Gradle (Kotlin DSL)**
* UI yapısı: **XML, ConstraintLayout**
* Görsel tasarım: XML tabanlı özel buton arka planları ve görseller (`drawable`)
* Veri akışı: Intent ile activity geçişleri ve `Bundle` üzerinden veri iletimi

Uygulama tamamen offline çalışır, herhangi bir dış API ya da veritabanı kullanmaz. Böylece düşük kaynak tüketimi ile cihaz üzerinde direkt çalışabilir. Bu yapı, temel Android geliştirme pratiklerini öğrenmek isteyenler için sade ve öğretici bir örnek sunar.

## 🧪 Genişletilebilirlik

Projeye aşağıdaki özellikler kolayca entegre edilebilir:

* Harici JSON dosyası veya Firebase ile dinamik soru çekme
* Kullanıcıya süre tanıma (timer)
* Zorluk seviyesine göre kategori seçimi
* Global skor takibi için SQLite veya çevrimdışı veri kaydı
* Sesli uyarılar ve animasyonlar ile oyunlaştırma öğeleri

## 👨‍💻 Geliştirici

Emre Biçer




