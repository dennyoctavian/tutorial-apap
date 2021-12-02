# Tutorial APAP

## Authors

- **<Denny Octavian>** - _<1906298834>_ - _<A>_

---
## Tutorial 8

### What I have learned today
Pada hari saya mempelajari react yang lebih dalam lagi yaitu menggunakan data dari api bukan data dummy seperti minggu kemarin. Pada minggu sebelumnya kita sudah mempelajari membuat api dengan mengirim response data json melalui xampp sekarang kita mengirim ke api melalui react js.

1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian
melakukan langkah - langkah tersebut?
Latihan no 1 kemarin diberitahu oleh asisten dosen untuk tidak melakukan implementasi karena ada kesalahan soal. Karena set state dibuat kosong atau di set state ulang kembali.

2.Jelaskan fungsi dari async dan await!
async maksudnya function tersebut dapat berjalan secara asrinkonus.
await itu untuk melakukan hit api dan api akan menggambil dan mengolah data pada html.

3. Masukkan jawaban dari Screenshot yang diperintahkan di halaman 9 pada Component Lifecycle
pada pertanyaan ini.
https://drive.google.com/drive/folders/1ZNjqquVeEnv1ogdUQoi4ohoFBTOVnKxD?usp=sharing

4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate,
componentDidUpdate, componentWillReceiveProps, componentWillUnmount.
Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja
yang biasanya menggunakan lifecycle method tersebut”.
componentDidMount : dipanggil segera setelah komponen dipasang. Inisialisasi yang membutuhkan node DOM harus dilakukan di sini. Digunakan ketika Clock output dimasukkan DOM.
shouldComponentUpdate : beri tahu React jika output komponen tidak terpengaruh oleh perubahan state atau props saat ini.
componentDidUpdate : dipanggil segera setelah pembaruan terjadi. Metode ini tidak dipanggil untuk render awal
componentWillReceiveProps : diperlukan jika Anda ingin memperbarui nilai status dengan nilai props baru, metode ini akan dipanggil setiap kali terjadi perubahan pada nilai props.
componentWillUnmount : dipanggil segera sebelum komponen dilepas dan dihancurkan.

### What I did not understand
Pada hari ini saya mengalami error yang cukup aneh padahal saya sudah bersama teman untuk debug malah tidak dapat menghasilkan add item ke cart.

## Tutorial 7

### What I have learned today
Pada hari ini saya mempelajari salah satu library javascript untuk mengelola bagian frontend yaitu menggunakan React Js. Kita mempelejari bagaimana membagi satu halaman html menjadi beberapa componet dan elemen. Kita juga mempelajari props dan state. Kita mempelajari javascript ES 6 yaitu let dan arrow function. Belajar bagimana melakukan routing pada react js.

1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.
Screenshot no 1.
   deleteItem = (item) => {
        const newItems = [...this.state.cartItems];
        const newItem = { ...item };
        const targetInd = newItems.findIndex((it) => it.id === newItem.id);
        newItem.inCart = false;
        newItems.splice(targetInd, 1);
        this.updateShopItem(newItem, false);
        this.setState({ cartItems: newItems });
        this.setState({balance: this.state.balance + newItem['price']});
    }
pada no 1, saya melihat algoritma bagimana untuk menambahkan setelah saya mempelajari saya mengcopy code mengupdate lalu setelah saya pelajari, saya memutuskan untuk mengubah newItems.splice(targetInd, 1);
this.updateShopItem(newItem, false); yang berarti saya menghapus item yang ingin dihapus pada list dan mengubah value newItem menjadi false untuk nanti jumalah dikeranjang dapat berkurang.

screenshot no 2
this.setState({balance: this.state.balance - newItem['price']});

pada no 2, saya menambahkan this.setState({balance: this.state.balance - newItem['price']}); yaitu dengan memanggil setState lalu mengupdate sebuah variabel balance dari balan-hargabarang.

screenshot no 3
         if (this.state.balance - newItem['price'] < 0){
            alert("Balance not sufficent!");
        }
pada no 3, saya hanya menambahkan pada add barang ke keranjang dengan code 
if (this.state.balance - newItem['price'] < 0){
    alert("Balance not sufficent!");
}

dengan mengecek uang yg sekarang ada dikurangin harga barang itu kurang dari nol maka sudah tidak bisa memasukan barang lagi dan akan mengeluarkan sebuah peringatan.

untuk screenshot asli dapat akses https://drive.google.com/drive/folders/1WD_a12HjWN_p9dvfTkPFU-BSU8-nGIpv?usp=sharing

2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?
state adalah sebuah data yang bersifat private pada sebuah component. State ini tidak dapat diakses oleh component lain, hanya dapat diakses oleh component milik dia sendiri.
props adalah property yang mirip seperti atrribute pada tag HTML. pada functional component kita dapat menyimpulkan bahwa props itu adalah parameternya. Jika kita membuat sebuah class untuk mengaksesnya memerlukan this sedangkan untuk function biasa bisa langsung nama file.

3. Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam React? sebutkan alasannya.
Kita sebaiknya menggunakan component alasannya untuk dapat diakses oleh halaman lain jadi apabila terdapat pengulangan dalam menampilkan pada html kita tidak perlu lagi melakukan coding ulang melainkan untuk memanggil komponen yang ingin kita tampilkan.

4. Apa perbedaan class component dan functional component?
functional component hanya dapat memakai props 
sedangkan class component dapat memakai state dan props.

5. Dalam react, apakah perbedaan component dan element?
component adalah 
elemen adalah bagian terkecil pada react yang menggambarkan sesuatu yang akan ditampilkan pada layar. Elemen adalah virtual dari DOM yang sangat terkenal karena kecepatannya. pada setting standar react memiliki 1 file index html yang isinya ada 
<div id="root"></div>

komponen adalah function seperti javascript yang memiliki input props dan mengembalikan react elemen. Dengan komponen kita dapat membuat UI yang independent, isolated, dan reusable. Sehingga mengurangi redudansi pada kode.

### What I did not understand
Syntax syantax react js asing bagi kami karena kita tidak memahami js yang cukup advanced.

## Tutorial 6

### What I have learned today

Pada minggu ini saya mempelajari autentikasi dan autorisasi pada springboot, update password, dan mengecek kriteria password.

1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode
   yang telah anda buat) konsep tersebut diimplementasi?
   Otentikasi adalah mengecek bahwa user yang memiliki id tertentu betul dia yang punya sedangkan Otorisasi adalah mengecek siapa saja yang dapat mengakases halaman tertentu.
   Otentikasi terjadi ketika login, sedangkan Otorisasi pada bagian add user, hapus user, liat all user, add menu pada cabang, tambah, ubah, dan hapus cabang.
2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.
   Itu adalah sebuah library untuk mengubah string password menjadi bentuk hasing. Cara kerjanya adalah semua string yg diterima akan diubah berdasarkan algoritma tertentu umumnya biasanya menggunakan kata kunci untuk melakukan hashing. Tujuannya supaya tidak ada seorang pun yang mengetahui password dari seorang user baik seorang admin.
3. Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa
   demikian?
   Karena password itu adalah hal yang sangat privasi karena untuk melakukan autentikasi kita perlu memasukan password. Karena jika password berbentuk string biasa apabila data bocor sangat mudah sekali untuk diretas apabila dilakukan hashing harus ada usaha tertentu untuk memecah sebuah kode hashing.
4. Jelaskan secara singkat apa itu UUID beserta penggunaannya!
   UUID (Universally Unique Identifier), juga dikenal sebagai GUID (Globally Unique Identifier) ​​mewakili nilai panjang 128-bit yang unik untuk semua tujuan praktis. Representasi standar UUID menggunakan digit hex (oktet). UUID terdiri dari digit hex (masing-masing 4 karakter) bersama dengan 4 simbol "-", yang membuat panjangnya sama dengan 36 karakter. UUID Nil adalah bentuk khusus dari UUID di mana semua bit disetel ke nol.
   UID memiliki kegunaan untuk melakukan sebuah identifikasi secara unik beberapa objek atau entitas di Internet
   sumber : https://www.baeldung.com/java-uuid

5. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut?
   Mempermudah semua segala proses Otentikasi dan Otorisasi karena sebenernya UserDetailsServiceImpl.java sebuah class yang sudah disiapkan oleh spring boot untuk melakukan itu semua. Dengan ada kelas itu mempermudah kita melakukan semua segala proses login logout dan otorisasi lebih mudah dan tidak perlu dilakukan dari 0.

### What I did not understand

Saya tidak memahami bagaimana mengimplementasi mengubah password.

## Tutorial 5

### What I have learned today

Pada minggu ini saya mempelajari RestAPI dengan menggunakan springboot. Kita membuat sebuah response berupa json yang akan dikonsumsi oleh FE. Kita menguji API menggunakan alat bantu POSTMAN.

1. Apa itu Postman? Apa kegunaannya?
   Postman adalah salah satu aplikasi untuk mengecek API yang sudah kita buat itu sudah berjalan sesuai dengan yang diinginkan atau belum. Umumnya digunakan oleh BE untuk mengecek API yang sudah dibuat. Jika dari website resminya POSTMAN adalah Platform API untuk membangun dan menggunakan API. Kegunaan lainnya biasanya digunakan oleh BE untuk mendokumentasikan seluruh API yang sudah ada karena pada POSTMAN kita dapat menyimpan API yang sudah kita test secara terstruktur.

2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
   @JsonIgnoreProperties berfungsi untuk mengabaikan properti logis yang ditentukan dalam serialisasi dan deserialisasi JSON. Hal ini dijelaskan di tingkat kelas. Temukan cuplikan kode.
   sumber: https://www.concretepage.com/jackson-api/jackson-jsonignore-jsonignoreproperties-and-jsonignoretype#JsonIgnore
   @JsonProperty berfungsi untuk digunakan untuk memetakan nama properti dengan kunci JSON selama serialisasi dan deserialisasi.
   sumber: https://dzone.com/articles/jackson-annotations-for-json-part-4-general

3. Apa kegunaan atribut WebClient?
   WebClient adalah antarmuka yang mewakili titik masuk utama untuk melakukan permintaan web atau klien web non-pemblokiran dan reaktif untuk melakukan permintaan HTTP. Dengan kegunaan menyediakan API gaya fungsional yang lancar. Kegunaan lainnya adalah menawarkan dukungan untuk operasi sinkron dan asinkron, sehingga cocok juga untuk aplikasi yang berjalan pada Servlet Stack.

sumber : https://howtodoinjava.com/spring-webflux/webclient-get-post-example/ dan https://www.baeldung.com/spring-5-webclient

4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
   ResponseEntity mewakili seluruh respons HTTP: kode status, header, dan isi. Akibatnya, kita dapat menggunakannya untuk mengonfigurasi respons HTTP sepenuhnya. Kegunaannya adalah karena initipe generik. Sehingga, kita dapat menggunakan tipe apa pun sebagai badan respons.

BindingResult adalah antarmuka yang menentukan bagaimana objek yang menyimpan hasil validasi harus menyimpan dan mengambil hasil validasi (kesalahan, upaya untuk mengikat ke bidang yang tidak diizinkan, dll). BindingResult digunakan objek BindingResult sebagai argumen untuk metode validasi Validator di dalam Controller.

sumber : https://stackoverflow.com/questions/10413886/what-is-the-use-of-bindingresult-interface-in-spring-mvc/36715053 dan https://www.baeldung.com/spring-response-entity

### What I did not understand

Saya kurang memahami soal no 2 untuk mengkonsumsi API external dan mencari jawaban dari 4 pertanyaan diatas.

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
