# Tutorial APAP
## Authors
* **AISYAH INDONESIA MAZAYA ZAYN** - *1906399000* - *C*

## Tutorial 2
### What I have learned today

Pada tutorial kedua ini, saya tidak hanya menyalin code dari dokumen tutorial, tetapi juga harus membuat beberapa code di controller, html, dan lainnya. Kesulitan yang saya alami adalah ketika salah menaruh package, yang seharusnya berada di directory main, tetapi saya tadi menaruhnya di directory test. Dengan adanya kejadian ini, saya menjadi lebih berhati-hati dan teliti dalam melakukan setiap step untuk pengembangan fitur sehingga tidak banyak waktu yang terbuang. Selain itu, saya juga mengeksplorasi konsep MVC dengan mempelajari lebih dalam tentang model dan service. Istilah model mengacu pada objek yang menyimpan informasi mengenai suatu hal. Sementara, istilah service digunakan untuk mendefinisikan method yang dapat dijalankan untuk memanipulasi suatu class. Terdapat juga istilah controller, yang berfungsi sebagai request handler dengan cara memetakan sebuah request dari user untuk memanggil service yang diinginkan.

### Pertanyaan
#### 1. Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20 APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10 Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi
> Saat saya membuka link tersebut, saya menemukan WhiteLable Error pada web browser saya. Hal tersebut dikarenakan oleh Controller yang telah berusaha untuk mengakses atau me-return template `“add-bioskop”` yang belum dibuat oleh saya. Solusi untuk permasalah ini adalah dengan membuat HTML template tersebut agar error dapat teratasi. 

#### 2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat
> Anotasi @Autowired merupakan implementasi dari konsep dependency injection. Jadi, jika kita menggunakan `@Autowired`, kita tidak perlu lagi menyediakan method setter maupun menambahkan argumen atau parameter di constructor. Anotasi ini bekerja dengan cara melihat isi dari package yang sedang berjalan, lalu mencari class-class dengan anotasi `@Repository`, `@Service`, `@Controller`, atau `@Component`, dan selanjutnya melakukan inisiasi terhadap class-class tersebut dan menginjeksi semua dependencies-nya.

#### 3. Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut: http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20 APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
> Terjadi error karena pada controller kita telah menetapkan dan menentukan idBioskop, namaBioskop, alamat, noTelepon, dan jumlahStudio sebagai required parameter yang bernilai `true`. Sementara, pada link di atas tidak dicantumkan parameter jumlahStudio sehingga akan menimbulkan error. 

#### 4. Jika Papa APAP ingin melihat Bioskop dengan nama Bioskop Maung, link apa yang harus diakses?
> Pertama, saya asumsikan saya telah menambahkan bioskop dengan keterangan **id bioskop: 2, nama bioskop: Bioskop Maung, alamat : Depok, nomor telepon: 0218235912, jumlah studio : 220** menggunakan `http://localhost:8080/bioskop/add?idBioskop=2&namaBioskop=Bioskop%20Maung&alamat=Depok&noTelepon=0218235912&jumlahStudio=220`
> Untuk melihat detail bioskop yang dimiliki tanpa mengetahui id bioskop, Papa bisa mengakses link `http://localhost:8080/bioskop/viewall`, lalu mencari nama bioskop tersebut di daftar seluruh bioskop yang muncul beserta id bioskop, alamat, nomor telepon, dan jumlah studio. Akan tetapi, jika Papa mengetahui id bioskop tersebut (diumpamakan id bioskopnya adalah 2), Papa bisa mengakses salah satu dari link di bawah ini agar bisa langsung memperlihatkan informasi bioskop yang dimiliki seorang pasien tanpa harus mencarinya satu per satu di daftar bioskop.
> - `http://localhost:8080/bioskop/view?idBioskop=2` (jika developer  sistem mengimplementasikan **RequestParam**, sesuaikan idBioskop sesuai dengan id yang ingin dicari)
> - `http://localhost:8080/bioskop/view/id-bioskop/2` (jika pengembang sistem mengimplementasikan **PathVariable**, sesuaikan idBioskop sesuai dengan id yang ingin dicari))

#### 5. Tambahkan 1 contoh Bioskop lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/bioskop/viewall, apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
> Saya telah menambahkan bioskop dengan keterangan **id bioskop: 3, nama bioskop: Bioskop Mazaya, alamat : Cibubur, nomor telepon: 081215944753, jumlah studio : 7** menggunakan link: `http://localhost:8080/bioskop/add?idBioskop=3&namaBioskop=Bioskop%20Mazaya&alamat=Cibubur&noTelepon=081215944753&jumlahStudio=7`
> Lalu saya mencoba untuk mengakses link `http://localhost:8080/bioskop/viewall` dan terdapat bioskop yang telah saya tambahkan beserta detailnya.
> Berikut adalah bukti screenshot saya `https://ibb.co/v3xRVvt`

----------

## Tutorial 1
### What I have learned today
Tutorial 1 ini membuat saya bernostalgia ke perkuliahan DDP. Istilah-istilah yang diberikan pada dokumen tutorial ada yang familiar di telinga, seperti Dependency, Maven, Git, dan Controller. Namun, ada juga istilah yang tidak pernah saya temukan. Tutorial ini membuat saya mengingat kembali materi Springboot. Walaupun sedikit lupa dan adanya perbedaan Set Up Springboot antara DDP dan APAP, asisten dosen sangat membantu saya untuk debugging dan memecahkan masalah.

### Github
#### 1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
Issue Tracker adalah perangkat lunak / software yang memungkinkan developer dalam mencatat bug dan melakukan track progress dalam memperbaikinya. Dengan adanya Issue Tracker, developer dapat memperbaiki bug, mencegah adanya bug, dan menyelesaikan masalah dengan cepat. Kegunaan Issue Tracker yang lain, yaitu memberikan masukan / ide untuk menentukan product road map dan mengetahui efek issue pada sistem, memantau dan membantu proses perbaikan berdasarkan prioritas, mengelola issue di seluruh siklusnya, serta menghasilkan laporan awal sampai ke penyelesaian akhir issue.

#### 2. Apa perbedaan dari git merge dan git merge --squash?
Git merge dan git merge --squash berfungsi untuk menyatukan perubahan pada suatu program dari branches yang ada. Namun pada git merge, hanya akan ada merge commit yang muncul dan branches akan tetap mempertahankan history atau riwayat perubahannya. Jadi pada git merge, nantinya akan muncul lebih dari satu parent. Sementara, pada git merge --squash, branches juga tetap mempertahankan history-nya tetapi merge commit tidak lagi dimunculkan dan keseluruhan perubahan pada master digabung menjadi satu commit serta ditampilkan sebagai satu commit. Jadi, pada git merge --squash nantinya akan tersisa satu parent.

#### 3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?
Version control adalah sebuah sistem yang mencatat setiap perubahan terhadap sebuah berkas / kumpulan berkas sehingga pada suatu saat anda dapat kembali kepada salah satu versi dari berkas tersebut. Sistem Version Control memungkinkan kita untuk untuk mengembalikan file / proyek di posisi sebelum terjadi perubahan tertentu, mempercepat development time, mengembalikan posisi sistem ketika terjadi error, dan dapat membandingkan setiap perubahan yang terjadi. Bahkan, System Control juga bisa mengatasi posisi sistem ketika terjadi error / terhapus dan juga Version Control System bisa dikerjakan secara offline. Tentunya Version Control System ini sangat berguna untuk para developer, terlebih untuk developer yang pemula.

### SPRING
#### 4. Apa itu library & dependency?
Library madalah sekumpulan kode yang memiliki fungsi tertentu dan dapat dipanggil ke dalam program lain. Library dibuat untuk mempermudah pembangunan sebuah aplikasi. Dengan adanya library, developer tidak harus membangun kode dari awal untuk function tertentu. Sementara, dependency adalah suatu istilah dalam dunia pemrograman yang menggambarkan ketergantungan satu program dengan program lainnya agar dapat bekerja. Library dan dependency memiliki keterkaitan. Contohnya adalah ketika "program P menggunakan library Q" yang memili arti bahwa P depends on Q atau Q is P's dependency.

#### 5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
Maven adalah salah satu build tool yang sering digunakan dalam proyek aplikasi Java yang didasarkan oleh Project Object Model dan digunakan untuk mempermudah pengelolaan dalam hal dependency maupun dokumentasi. Penggunaan Maven membantu meringankan beban tim developer karena ketika mengerjakan project yang mengandung banyak dependency dan requirements secara manual akan sangat tidak efisien dan efektif. Maven dapat menambahkan semua dependency yang diperlukan untuk proyek secara otomatis dengan membaca file Project Object Model serta developer dapat membangun proyek mereka ke jar dan war sesuai requirements dari suatu aplikasi. Selain itu, Maven sangat memudahkan developer dalam memulai proyek di lingkungan yang berbeda dan tidak perlu lagi menangani dependencies injection, builds, maupun processing. Tentu saja terdapat alternatif lain dari Maven, yaitu CMake, GNU Make, Gradle, Ant, dan Jenkins.

#### 6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
Spring framework menggunakan teknik pemrograman yang sederhana serta model pemrograman dengan Spring cukup mudah dan rapi. Hal ini sangat memudakan developer pemula untuk mempelajari dan menerapkannya karena framework Spring mendorong untuk membuat kode program yang modular dan independen. Hasilnya, kode program yang dibuat akan lebih rapi, mudah dites, dan lebih terstruktur. Spring juga dapat digunakan untuk mengembangkan berbagai macam aplikasi, seperti aplikasi standalone, aplikasi GUI standalone, applet, dan aplikasi web berbasis MVC.

#### 7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?
@RequestParam dan @PathVariable digunakan untuk mengekstrak suatu value dari URL. Namun, dari segi penggunaan keduanya biasanya ditentukan oleh bagaimana suatu website atau situs dirancang. @PathVariable digunakan untuk mengekstrak data dari template URI, misalnya adalah RESTful web services. @PathVariable sebaiknya digunakan ketika developer ingin melakukan customization untuk mendapatkan data karena Spring MVC mendukung adjustment pada URL. Sementara, @RequestParam digunakan untuk mengekstrak data yang ditemukan dalam parameter query dan untuk mendapatkan tempat penampung dari URI (Spring menyebutnya sebagai Template URI). @RequestParam sebaiknya digunakan saat kita ingin mengikat parameter request ke argumen pada handler method secara otomatis.

### What I did not understand
Sejauh ini belum ada materi terkait APAP yang saya belum mengerti. Namun, pertanyaan di bawah adalah pertanyaan mengenai implementasi mata kuliah APAP dan tools yang belum saya ketahui jawabannya. Pada tutorial 2, pertanyaan di bawah akan saya lengkapi dan saya tambahkan checklist.
- [X] Mengapa saya harus belajar APAP?
    - Karena mata kuliah APAP akan sangat berguna dalam pengembangan suatu aplikasi dan nantinya akan berguna untuk mata kuliah Proyek Perancangan Sistem Informasi.
- [X] Mengapa mahasiswa disarakan untuk memakai Intellij IDEA dibanding Visual Studio Code?
    - Karena asdos menggunakan Intellij IDEA untuk panduan dokumen lab sehingga akan lebih mudah dan efektif apabila kita menggunakan software yang sama. Selain itu, Intellij IDEA bisa membuat auto generate constructor, setter, getter, dan berbagai macam import sehingga kita bisa lebih cepat dalam membuat code.
- [X] Apa perbedaan penggunaan Springboot untuk APAP dan DDP2? Mengapa penggunaan SpringBoot untuk APAP lebih rumit dan kompleks?
    - Sebetulnya sama saja, mungkin APAP terlihat lebih kompleks karena saya sudah tidak pernah mengasah programming dengan Springboot lagi sehingga ada beberapa hal yang harus dipelajari kembali.

