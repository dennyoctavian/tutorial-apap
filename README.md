# Tutorial APAP

## Authors

- **<Denny Octavian>** - _<1906298834>_ - _<A>_

---

## Tutorial 2

### What I have learned today

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
