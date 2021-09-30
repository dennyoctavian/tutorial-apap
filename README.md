# Tutorial APAP

## Authors

- **<Denny Octavian>** - _<1906298834>_ - _<A>_

---

## Tutorial 4

### What I have learned today

Pada minggu ini saya mempelajari engine template dari springboot yaitu thymeleaf. Kita dapat dengan mudah menggunakan conditional, looping, dan compile to html dengan mudah karena sudah disediakan. Minggu ini kita memepelajari syntax-syntax yang ada pada thymeleaf ini.

1. Jelaskan perbedaan th:include dan th:replace!
   th:include itu memasukan konten kedalam suatu html dari fragments yang telah kita buat.
   th:replace itu menggantikan konten kedalam suatu html dengan fragments yang telah kita buat berarti kita akan menghapus konten yang ada di html utama digantikan oleh konten dari fragment ini.
2. Jelaskan apa fungsi dari th:object!
   th:object berfungsi sebagai submit pada sebuah form sehingga springboot mengetahui object yang disubmit di html. fungsi lainnya untuk menentukan object mana yang akan diisi dari suatu objek.
3. Jelaskan perbedaan dari \* dan \$ pada saat penggunaan th:object! Kapan harus dipakai?

- itu berfungsi untuk mengevaluasi sebuah attribute maupun variable dari sebuah th:object yang sudah di deklarasi sebelum code ini.
  \$ itu untuk mengevaluasi keseluruhan atribute maupun variabel dari sebuah th:object

### What I did not understand

Saya kurang memahami soal no 4 bagaimana membuat beberapa input menu secara reload dan sampai sekarang saya masih mencoba mengimplementasi fitur tersebut.

## Tutorial 3

### What I have learned today

Pada kesempatan kali ini saya mempelajari sebuah framework yang dapat membuat sebuah model sekaligus membuat data pada database menjadi lebih mudah tanpa harus melakukan query pada MySQL. Pada minggu ini saya memepelajari satu layer baru yaitu layer repository yang berfungsi seluruh query yang berhubungan dengan database. Pada minggu ini saya memepelajari jika menggunakan vscode memerlukan extension lombok sebelum menggunakannya pada code.

1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model
   (@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)
   @AllArgsConstructor membuat constructor secara otomatis dengan satu parameter untuk setiap class yang dibuat
   @NoArgsConstructor membuat constructor secara otomatis yang tanpa parameter
   @Setter membuat seluruh setter yang dibutuhkan oleh model tersebut
   @Getter membuat seluruh getter yang dibutuhkan oleh model tersebut
   @Entity mendeklarasikan sebuah class model sehingga dapat dilakukan mapping ke table pada database
   @Table memberikan nama table pada JPA menggunakan @table(nama="nama_database") sehingga ketika dibuat database di MySQL sesuai nama yang diberikan pada @Table

2. Pada class CabangDB, terdapat method findByNoCabang, apakah kegunaan dari method tersebut?
   Fungsinya untuk mencari berdasarkann no cabang pada database karena kelas CabangDB berfungsi untuk melakukan seluruh logic yang berhubungan dengan database.

3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn
   @JoinTable adalah membuat sabuah table baru dari join beberapa table.
   @JoinColum adalah membuat foreignkey dari suatu kolom ke kolom yang lainnya.

4. Pada class PegawaiModel, digunakan anotasi @JoinColumn pada atribut cabang, apa
   kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa
   perbedaan nullable dan penggunaan anotasi @NotNull
   @JoinColumn(name ="noCabang", referencedColumnName = "noCabang", nullable = false)
   name adalah membuat nama attribute pada kolom PegawaiModel yang akan menjadi sebuah foreignkey
   referencedColumnName adalah attribute mana yang akan dituju atau mau di foreignkey ke mana
   nullable itu khusus untuk diforeignkey sedangkan @NotNull untuk attribute biasa yang bukan attribute foreignkey

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
   FetchType.LAZY : memberi tahu Hibernate untuk hanya mengambil entitas terkait dari database saat Anda menggunakan relasi. Pola ini adalah menunda menginisialisasi data selama mungkin. Umumnya digunakan untuk relasi one to one.
   CascadeType.ALL : menyebarkan semua operasi (PERSIST, REMOVE, REFRESH, MERGE, DETACH) termasuk yang khusus dari Hibernate dari induk ke entitas anak. Umumnya digunakan untuk relasi one to many.
   dan FetchType.EAGER : memberi tahu Hibernate untuk mendapatkan semua elemen relasi saat memilih entitas root. Pola ini adalah segera menginisialisasi data pada saat itu juga. Umumnya digunakan untuk relasi many to one.

### What I did not understand

Pada minggu ini saya mengalami kesalahan pemahaman soal. Seperti untuk cabang sedang buka saya memikirkan bahwa tombol terdisable ternyata permintaan soal berbeda. Saya tidak memahami layer repository karena hanya membuat interface karena tidak ada dilakukan implementasi. Saya membutuhkan informasi yg lebih untuk memahami layer repository pada springboot.

## Tutorial 2

### What I have learned today

### What I did not understand

Saya mempelajari fungsi dari sebuah service untuk tidak meredundant code yang kita buat. Dan membuat code saya lebih terstrukur. Dan minggu ini juga mempelajari model yang merepresentasikan data pada database, tetapi minggu ini belum mempelajari bagaimana mengakases database.

Pertanyaan 1: Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut setelah menjalankan program:
http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi
Ketika saya klik link tersebut akan muncul error yaitu error whitelabel error page. Karena pada controller kita mereturn sebuah file html, tetapi pada folder resources/template file html tersebut masih belum tersedia maka muncul error tersebut. Ini adalah internal server error dengan kode status 500.

Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat
@Autowired ini baru diperkenalan pada spring 2.5 fitur ini yang merupakan implementasi dari konsep dependency injection. Fungsi dari fitur ini adalah menyelesaikan dan meinject berkolaborasi beans ke our bean.
Cara kerja fitur ini adalah kita mengakses ke interface fitur ini yang akan meninject depedency otomatis dari autowiring ke service yang melakukan implementasi autowiring.
source : https://www.baeldung.com/spring-autowire

Pertanyaan 3: Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut:
http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung%20Fasilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
Akan terjadi error karena ada data yang required yaitu noTelepon yang tidak dimasukkan kedalam url tersebut. Kecuali pada controller request paramnya requirednya false maka link tersebut tidak error.

Pertanyaan 4: Jika Papa APAP ingin melihat Kebun Safari dengan nama Papa APAP, link apa yang harus diakses?
http://localhost:8080/kebun-safari?id=1
http://localhost:8080/kebun-safari/view/1

Pertanyaan 5: Tambahkan 1 contoh Kebun Safari lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/ , apa yang akan ditampilkan? Sertakan juga bukti screenshot mu
Akan menampilkan seluruh daftar kebun safari yang sudah diadd masing2 ID akan menampilkan Id, Nama Kebun Safari, Alamat, dan Nomor telepon
Link screenshoot : https://drive.google.com/file/d/1K41uAMMVMJgkjXsD0qoP4Dqq_rehmnnq/view?usp=sharing

### What I did not understand

Autowired saya kurang memahami gmn cara kerja yang pastinya dan bedanya requestmapping dan getmapping (dan kapan kita menggunakannya)

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
