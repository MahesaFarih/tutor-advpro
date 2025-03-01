Refleksi #1

Penerapan Clean Code

Selama pengembangan fitur List, Edit, dan Delete Product dalam aplikasi EShop, kami telah menerapkan prinsip-prinsip clean code untuk memastikan kode yang ditulis mudah dipahami, dikelola, dan diperluas. Salah satu prinsip utama yang diterapkan adalah pemberian nama variabel, metode, dan kelas yang deskriptif agar jelas dalam mengkomunikasikan tujuan dan fungsinya. Contohnya, nama kelas seperti ProductServiceImpl secara eksplisit menunjukkan bahwa kelas tersebut merupakan implementasi dari ProductService.

Selain itu, kami juga menerapkan prinsip pemisahan tanggung jawab (Separation of Concerns) dengan membagi kode ke dalam empat package utama: model, repository, service, dan controller. Pendekatan ini memastikan bahwa setiap lapisan memiliki peran spesifik, sehingga kode menjadi lebih modular dan mudah dipelihara. Dengan pemisahan ini, perubahan dalam satu lapisan tidak akan berdampak besar pada lapisan lainnya.

Praktik Secure Coding

Dalam mengembangkan aplikasi ini, beberapa praktik secure coding juga diterapkan untuk mencegah potensi celah keamanan. Salah satu praktik yang digunakan adalah validasi input pada controller untuk memastikan data yang dikirimkan oleh pengguna sesuai dengan yang diharapkan dan menghindari serangan seperti SQL Injection atau XSS. Jika aplikasi ini nantinya terhubung ke database, penggunaan parameterized queries atau ORM akan memastikan keamanan terhadap serangan injeksi SQL.

Selain itu, kami juga menghindari penggunaan informasi sensitif dalam kode sumber, seperti kredensial atau konfigurasi yang seharusnya disimpan dalam environment variables atau konfigurasi eksternal. Dengan demikian, keamanan aplikasi dapat lebih terjaga, terutama jika kode sumber dipublikasikan atau dibagikan dengan tim lain.

Evaluasi dan Perbaikan Kode

Dalam mengevaluasi kembali kode yang telah dibuat, kami menyadari beberapa area yang bisa ditingkatkan. Salah satunya adalah peningkatan pengelolaan error handling dalam service dan repository layer. Saat ini, jika terjadi kesalahan dalam pengelolaan produk (misalnya mencoba mengedit produk yang tidak ada), aplikasi bisa saja gagal tanpa memberikan feedback yang jelas ke pengguna. Untuk mengatasi ini, perlu ditambahkan mekanisme exception handling yang lebih baik, seperti menggunakan @ExceptionHandler dalam controller untuk menangani error secara terpusat.

Selain itu, efisiensi kode juga dapat ditingkatkan dengan mengoptimalkan penggunaan dependency injection pada Spring Boot. Dalam beberapa bagian, mungkin ada ketergantungan yang dapat dibuat lebih fleksibel dengan menggunakan interface yang lebih generik, sehingga memudahkan pengujian dan penggantian implementasi di masa depan.

Kesimpulan

Secara keseluruhan, implementasi fitur dalam aplikasi EShop telah dilakukan dengan menerapkan prinsip clean code dan secure coding. Namun, masih ada beberapa aspek yang bisa diperbaiki, seperti pengelolaan error yang lebih baik dan optimalisasi dependency injection. Evaluasi dan perbaikan kode secara berkala sangat penting untuk memastikan bahwa aplikasi tetap aman, mudah dikelola, dan dapat berkembang sesuai kebutuhan bisnis di masa mendatang.


Refleksi #2

1. Refleksi Setelah Menulis Unit Test

Setelah menulis unit test untuk proyek eShop, saya merasa bahwa proses ini sangat membantu dalam memastikan bahwa setiap komponen dalam aplikasi berfungsi sesuai dengan yang diharapkan. Dengan adanya unit test, saya dapat mendeteksi kesalahan lebih awal sebelum kode diintegrasikan ke dalam sistem secara keseluruhan.

Dalam satu kelas, jumlah unit test yang harus dibuat tergantung pada kompleksitas kelas tersebut. Setiap metode utama yang memiliki logika bisnis sebaiknya diuji dengan skenario positif maupun negatif. Untuk memastikan bahwa unit test sudah cukup, kita dapat menggunakan metrik code coverage. Code coverage mengukur seberapa banyak bagian kode yang diuji oleh unit test. Namun, meskipun code coverage mencapai 100%, itu tidak menjamin bahwa kode sepenuhnya bebas dari bug atau error. Hal ini karena unit test hanya menguji skenario yang telah didefinisikan, dan tidak dapat menangkap semua kemungkinan bug yang mungkin muncul dalam produksi.

2. Refleksi Mengenai Clean Code dalam Functional Test

Dalam penulisan functional test, saya menyadari bahwa jika kita membuat banyak test suite dengan setup yang serupa, ada risiko kode menjadi redundant dan sulit untuk dipelihara. Jika kita membuat kelas baru untuk menguji jumlah item dalam daftar produk dengan prosedur dan variabel instance yang sama seperti functional test sebelumnya, maka kode kita menjadi tidak efisien dan melanggar prinsip DRY (Don't Repeat Yourself).

Potensi masalah dalam clean code:

Duplikasi kode: Jika banyak test suite memiliki setup yang sama, setiap perubahan pada setup akan mengharuskan kita memperbarui banyak file secara manual.

Sulit untuk dikelola: Semakin banyak duplikasi, semakin sulit untuk memahami dan memelihara kode dalam jangka panjang.

Cara meningkatkan kualitas kode:

Refactor setup ke dalam metode terpisah

Gunakan metode setup bersama yang bisa digunakan kembali di berbagai functional test suite.

Contohnya, buat kelas utilitas atau base class yang berisi metode setup umum.

Gunakan parameterized tests

Jika ada banyak skenario yang perlu diuji, pertimbangkan untuk menggunakan parameterized tests agar tidak perlu menulis banyak metode dengan struktur yang sama.

Gunakan Page Object Model (POM)

Jika functional test berinteraksi dengan UI web, kita bisa menerapkan Page Object Model untuk menyimpan elemen dan interaksi dengan halaman dalam satu tempat, sehingga kode lebih terstruktur dan lebih mudah diperbarui.

Dengan menerapkan strategi-strategi tersebut, kita dapat memastikan bahwa functional test tetap bersih, mudah dipelihara, dan tidak mengandung duplikasi yang berlebihan.

Refleksi #3

Dalam latihan ini, saya mengonfigurasi Gradle dengan plugin JaCoCo untuk mengukur code coverage, serta menerapkan CI/CD menggunakan GitHub Actions. Saya berhasil mengotomatisasi pengujian, analisis kode, dan deployment dengan membuat workflow yang mencakup langkah-langkah utama seperti checkout kode, setup Java, menjalankan tes, serta menambahkan alat analisis tambahan seperti OSSF Scorecard dan PMD/SonarCloud.

Tantangan utama adalah memastikan cakupan kode meningkat dengan menambah unit test dan memperbaiki masalah kualitas kode yang terdeteksi. Setelah perbaikan, saya memverifikasi bahwa workflow berjalan dengan benar dan masalah tidak muncul kembali. Akhirnya, saya menerapkan mekanisme auto-deploy ke PaaS, memastikan aplikasi dapat langsung digunakan setelah perubahan diterapkan.

Secara keseluruhan, latihan ini memperkuat pemahaman saya tentang CI/CD, otomatisasi pengujian, serta penerapan best practices dalam pengembangan perangkat lunak.

Refleksi #4: Penerapan Prinsip SOLID

1. Prinsip SOLID yang Diterapkan
   Selama refactoring kode, beberapa prinsip SOLID diterapkan untuk meningkatkan kualitas dan maintainability aplikasi:

Single Responsibility Principle (SRP):

Contoh:

CarController dan ProductController dipisahkan menjadi kelas independen.

CarRepositoryImpl hanya bertanggung jawab untuk menyimpan data mobil, tanpa logika bisnis.

Open/Closed Principle (OCP):

Contoh:

Interface CarService dan CarRepository memungkinkan ekstensi (misalnya, menambahkan metode baru) tanpa memodifikasi kode yang sudah ada.

Liskov Substitution Principle (LSP):

Contoh:

CarController tidak lagi mewarisi ProductController, sehingga memastikan substitusi kelas tidak melanggar fungsionalitas.

Interface Segregation Principle (ISP):

Contoh:

Interface CarService hanya berisi metode yang relevan untuk operasi mobil (tidak ada metode redundan).

Dependency Inversion Principle (DIP):

Contoh:

CarController bergantung pada interface CarService, bukan implementasi konkret CarServiceImpl.

Dependency Injection menggunakan @Autowired untuk memenuhi prinsip ini.

2. Keuntungan Menerapkan SOLID
   Penerapan SOLID memberikan manfaat signifikan:

Mudah Diperluas
Contoh: Menambahkan fitur baru seperti MotorcycleService dapat dilakukan dengan mengimplementasikan interface VehicleService tanpa mengubah kode yang ada (OCP).

Kode Lebih Terstruktur
Contoh: Pemisahan CarController dan ProductController menghindari duplikasi logika (SRP).

Fleksibilitas
Contoh: Mengganti database dari in-memory list ke PostgreSQL hanya memerlukan perubahan di CarRepositoryImpl, tanpa mengganggu service atau controller (DIP).

Meminimalisir Bug
Contoh: Penghapusan inheritance antara CarController dan ProductController mencegah efek samping yang tidak diinginkan (LSP).

3. Kerugian Tidak Menerapkan SOLID
   Jika SOLID diabaikan, kode akan rentan terhadap masalah berikut:

Kode Kaku dan Sulit Diubah
Contoh: Sebelum refactoring, CarController yang mewarisi ProductController menyebabkan ketergantungan yang tidak perlu. Perubahan di ProductController bisa merusak fungsionalitas mobil.

Duplikasi Logika
Contoh: Tanpa SRP, kelas CarRepository mungkin menangani validasi data dan penyimpanan sekaligus, sehingga logika tersebar di banyak tempat.

Testing yang Rumit
Contoh: Jika CarServiceImpl bergantung langsung pada CarRepositoryImpl (bukan interface), unit test akan sulit dibuat karena ketergantungan konkret.

Kesulitan Kolaborasi
Contoh: Tanpa ISP, interface Service yang besar akan memaksa kelas mengimplementasikan metode tidak relevan, memperlambat pengembangan tim.

Formatting Fixes
Penambahan header ### untuk subbagian.

Spasi konsisten antar-paragraf.

Penomoran refleksi yang jelas (Refleksi #1 hingga Refleksi #4).

Kesimpulan
Penerapan SOLID meningkatkan kualitas kode secara holistik, sementara mengabaikannya dapat menyebabkan technical debt yang signifikan. Refleksi ini memperkuat pentingnya prinsip SOLID dalam pengembangan berkelanjutan.