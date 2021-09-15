# Tutorial APAP

## Authors

- **<Denny Octavian>** - _<1906298834>_ - _<A>_

---

## Tutorial 1

### What I have learned today

Hari ini saya mempelajari sebuah framework dari java. Pada lab kali ini, saya diperkenalan MVC pada springboot dengan membuat sebuah model, controller, dan thymeleaf html. Saya juga mempelajari bagaimana membuild sebuah project di vscode.

GitHub

1. [Note] Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue
   Tracker?
   Issue tracker adalah sebuah tools yang digunakan untuk menangani/melacak sebuah bug pada program aplikasi anda dan sebagai permintaan sebuah fitur kepada partner developer lain. Issue tracker juga dikenal sebagai bug tracking system.
   Sumber dari https://developers.google.com/issue-tracker
   Masalah yang dapat diselesaikan dengan Issue Tracker adalah menyelesaikan bug, melacak bug, pencatatan alur pembuatan fitur aplikasi, dll.
2. [Note] Apa perbedaan dari git merge dan git merge --squash?
   git merge --squash itu membuat commit menjadi hanya menjadi satu informasi commit, sedangkan git merge menampilkan seluruh commit yang telah dilakukan.
   Kedua fungsi ini menggabungkan seluruh branch yang ada pada sebuah repository baik di github, gitlab, dll

3. [Note] Apa keunggulan menggunakan Version Control System seperti Git dalam
   pengembangan suatu aplikasi?
   Kita dapat mengetahui setiap perubahan versi yang dilakukan developer
   apabila ditengah jalan terjadi error dan stuck, kita dapat kembali keversi sebelumnya.
   Salah satu pendokumentasian proses alur pembuatan aplikasi.

Spring

1. [Note] Apa itu library & dependency?
   library adalah kumpulan beberapa fungsi yang dibuat untuk memperudah developer untuk membuat program yang digunakan pada aplikasi (website).
   Dependecy adalah keterkaitan sebuah program terhadap tools tools apa yang digunakan pada sebuah framework dalam membangun sebuah aplikasi.
2. [Note] Apa itu maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
   Maven adalah proyek managemen software yang digunakan untuk mengembangkan dan memanage program berbasis java.
   Karena maven ini popular dan umum digunakan oleh kalangan developer, kemudian seluruh dokumentasi sudah tersedia dengan baik.
   Alternatif lain adalah Gradle, Ant, dll
3. [Note] Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan
   Spring framework?
   Pembuatan API, mengembangkan aplikasi berbasis android, dan pembuatan aplikasi website berbasis microservice.
4. [Note] Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
   menggunakan @RequestParam atau @PathVariable?
   @RequestParams mengambil sebuah nilai dari query string yang disisipkan pada URL
   @PathVariables mengambil sebuah nilai dari URI path
   2 method ini sudah kita coba pada tutorial 1.

@PathVariables mengambil nilai dari mengekstrak value URI tetapi tidak di encoded
@RequestParams ini sudah di encoded

Kita menggunakan @RequestParam pada website tradisional sedangkan @PathVariable pada website modern.
RequestParam ini kurang aman karena informasi esensial muncul pada URL.

### What I did not understand

Saya kurang memahami code pada bagian @PathVariable(value = "kalimat") String kalimat, Model model) Apa yang diambil oleh code ini.
