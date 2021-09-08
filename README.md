# Tutorial APAP
## Authors
* **AISYAH INDONESIA MAZAYA ZAYN** - *1906399000* - *C*

===
## Tutorial 1
### What I have learned today
Tutorial 1 ini membuat saya bernostalgia ke perkuliahan DDP. Istilah-istilah yang diberikan pada dokumen tutorial ada yang familiar di telinga, seperti Dependency, Maven, Git, dan Controller. Namun, ada juga istilah yang tidak pernah saya temukan. Tutorial ini membuat saya mengingat kembali materi Springboot. Walaupun sedikit lupa dan adanya perbedaan Set Up Springboot antara DDP dan APAP, asisten dosen sangat membantu saya untuk debugging dan memecahkan masalah.

### Github
#### 1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
Issue Tracker adalah perangkat lunak / software yang memungkinkan developer dalam mencatat bug dan melakukan track progress dalam memperbaikinya. Dengan adanya Issue Tracker, developer dapat memperbaiki bug, mencegah adanya bug, dan menyelesaikan masalah dengan cepat. Kegunaan Issue Tracker yang lain, yaitu memberikan masukan / ide untuk menentukan product road map dan mengetahui efek issue pada sistem, memantau dan membantu proses perbaikan berdasarkan prioritas, mengelola issue di seluruh siklusnya, serta menghasilkan laporan awal sampai ke penyelesaian akhir issue.

#### 2. Apa perbedaan dari git merge dan git merge --squash?
Git merge dan git merge --squash berfungsi untuk menyatukan perubahan pada suatu program dari branches yang ada. Namun pada git merge, hanya akan ada merge commit yang muncul dan branches akan tetap mempertahankan history atau riwayat perubahannya. Jadi pada git merge, nantinya akan muncul lebih dari satu parent. Sementara, pada git merge --squash, branches juga tetap mempertahankan history-nya. Namun, merge commit tidak lagi dimunculkan dan keseluruhan mperubahan pada master digabung menjadi satu commit serta ditampilkan sebagai satu commit. Jadi,pada git merge --squash nantinya akan tersisa satu parent.

#### 3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?
Version control adalah sebuah sistem yang mencatat setiap perubahan terhadap sebuah berkas / kumpulan berkas sehingga pada suatu saat anda dapat kembali kepada salah satu versi dari berkas tersebut. Sistem Version Control memungkinkan kita untuk untuk mengembalikan file / proyek di posisi sebelum terjadi perubahan tertentu, mempercepat development time, mengembalikan posisi sistem ketika terjadi error, dan dapat membandingkan setiap perubahan yang terjadi. Bahkan, System Control juga bisa mengatasi posisi sistem ketika terjadi error / terhapus dan bisa dikerjakan secara offline. Tentunya Version Control System ini sangat berguna untuk paea developer, terlebih untuk developer pemula dari kalangan pelajar / mahasiswa.

### SPRING
#### 4. Apa itu library & dependency?
Library madalah sekumpulan kode yang memiliki fungsi tertentu dan dapat dipanggil ke dalam program lain. Library dibuat untuk mempermudah dalam membangun sebuah aplikasi. Dengam adanya library, developer tidak harus membangun kode dari awal untuk function tertentu. Sementara, dependency adalah suatu istilah dalam dunia pemrograman yang menggambarkan ketergantungan satu program dengan program lainnya agar dapat bekerja. Library dan dependency memiliki keterkaitan. Contohnya adalah ketika "program P menggunakan library Q" yang memili arti bahwa P depends on Q atau Q is P's dependency.

#### 5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
Maven adalah salah satu build tool yang sering digunakan dalam proyek aplikasi Java yang didasarkan oleh Project Object Model dan digunakan untuk mempermudah pengelolaan dalam hal dependency maupun dokumentasi. Penggunaan Maven membantu meringankan beban tim developer karena ketika mengerjakan project yang mengandung banyak dependency dan requirements secara manual akan sangat menyulitkan. Maven dapat menambahkan semua dependency yang diperlukan untuk proyek secara otomatis dengan membaca file Project Object Model serta developer dapat membangun proyek mereka ke jar dan war sesuai requirements dari suatu aplikasi. Selain itu, Maven sangat memudahkan developer dalam memulai proyek di lingkungan yang berbeda dan tidak perlu lagi menangani dependencies injection, builds, maupun processing. Tentu saja terdapat alternatif lain dari Maven, yaitu CMake, GNU Make, Gradle, Ant, dan Jenkins.

#### 6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
Spring framework menggunakan teknik pemrograman yang sederhana, model pemrograman dengan Spring cukup mudah dan rapi. Hal ini sangat memudakan bagi developer pemula untuk mempelajari dan menerapkannya. Hal ini karena framework Spring mendorong untuk membuat kode program yang modular dan independen. Hasilnya, kode program yang dibuat akan lebih rapi, mudah dites, dan lebih terstruktur. Spring juga dapat digunakan untuk mengembangkan berbagai macam aplikasi, seperti aplikasi standalone, aplikasi GUI standalone, applet, dan aplikasi web berbasis MVC.

#### 7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?
@RequestParam dan @PathVariable digunakan untuk mengekstrak suatu value dari URL. Namun, dari segi penggunaan keduanya biasanya ditentukan oleh bagaimana suatu website atau situs dirancang. @PathVariable digunakan untuk mengekstrak data dari template URI, misalnya adalah RESTful web services. @PathVariable sebaiknya digunakan ketika developer ingin melakukan customization untuk mendapatkan data karena Spring MVC mendukung adjustment pada URL. Sementara, @RequestParam digunakan untuk mengekstrak data yang ditemukan dalam parameter query dan untuk mendapatkan tempat penampung dari URI (Spring menyebutnya sebagai Template URI). @RequestParam sebaiknya digunakan saat kita ingin mengikat parameter request ke argumen pada handler method secara otomatis.

### What I did not understand
Sejauh ini belum ada materi terkait APAP yang saya belum mengerti. Namun, pertanyaan di bawah adalah pertanyaan mengenai implementasi mata kuliah APAP dan tools yang belum saya ketahui jawabannya. Pada tutorial 2, pertanyaan di bawah akan saya lengkapi dan saya tambahkan checklist.
- [] Mengapa saya harus belajar APAP?
- [] Mengapa mahasiswa disarakan untuk memakai Intellij IDEA dibanding Visual Studio Code?
- [] Apa perbedaan penggunaan Springboot untuk APAP dan SDA? Mengapa penggunaan SpringBoot untuk APAP lebih rumit dan kompleks?

