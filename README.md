
# **Submission**

Selamat, Anda telah berada di akhir pembelajaran dalam akademi ini. Anda telah belajar banyak tentang pengembangan aplikasi berbasis Android. Untuk bisa lulus dari akademi ini Anda akan memodifikasi proyek submission **Aplikasi Movie Catalogue (Local Storage)** dengan menambahkan beberapa fitur. Anda bisa memanfaatkan beberapa materi yang telah dipelajari. Selamat berkreasi!

## Kriteria

Fitur yang harus ditambahkan pada aplikasi:

1.  **Pencarian film**  
    Syarat:
    *   Pengguna dapat melakukan pencarian **Movies**.
    *   Pengguna dapat melakukan pencarian **Tv Show**.  

2.  **Widget**  
    Syarat:
    *   Pengguna dapat menampilkan widget dari film favorite ke halaman utama smartphone.
    *   Tipe widget yang diterapkan adalah **Stack Widget**.  

3.  **Reminder**  
    Syarat:
    *   Daily Reminder, mengirimkan notifikasi ke pengguna untuk kembali ke **Aplikasi Movie Catalogue**. Daily reminder harus selalu berjalan tiap jam 7 pagi.
    *   Release Today Reminder, mengirimkan notifikasi ke pengguna semua film yang rilishari ini (**wajib menggunakan endpoint seperti yang telah disediakan pada bagian Resources di bawah**). Release reminder harus selalu berjalan tiap jam 8 pagi.
    *   Terdapat halaman pengaturan untuk mengaktifkan dan menonaktifkan reminder.  

4.  **Aplikasi** **Favorite**  
    Syarat:
    *   Membuat aplikasi atau modul baru yang menampilkan daftar film favorite.
    *   Menggunakan **Content Provider** sebagai mekanisme untuk mengakses data dari satu aplikasi ke aplikasi lain.

Berikut kerangka tampilan yang bisa Anda gunakan sebagai referensi:

![201902180856320073cc3b59071a00e26d5be08eecc67d.png](https://dicodingacademy.blob.core.windows.net/academies/201902180856320073cc3b59071a00e26d5be08eecc67d.png)

Kesempatan untuk submission Anda diterima akan lebih besar jika:

*   Notifikasi dapat berjalan pada perangkat Oreo dan setelahnya
*   Data pada **widget** dapat diperbarui secara otomatis ketika terdapat perubahan pada data **favorite**.
*   Menggunakan **SearchView** pada fitur pencarian film.
*   Menggunakan library pihak ketiga seperti Retrofit, Fast Android Networking, dsb.
*   Menggunakan library penyimpanan lokal pihak ketiga seperti Room, Realm, dsb.
*   Menerapkan design pattern seperti MVP, MVVM, Arch Component, dsb.
*   Aplikasi bisa memberikan pesan eror jika data tidak berhasil ditampilkan.
*   Menuliskan kode dengan bersih.

Submission Anda akan ditolak jika:

*   Fitur **pencarian** tidak berjalan dengan baik.
*   Fitur **pencarian** tidak memanfaatkan endpoint dari **TheMovieDB**.
*   Fitur **reminder** tidak berjalan dengan baik.
*   Fitur **release today reminder** tidak memanfaatkan endpoint dari **TheMovieDB.**
*   Tidak dapat menampilkan data favorite ke dalam **Stack Widget**.
*   Tidak terdapat aplikasi atau modul baru yang menampilkan data **favorite**.
*   Tidak menerapkan **Content Provider** sebagai mekanisme untuk mengakses data dari satu aplikasi ke aplikasi lain.
*   Tidak Mempertahankan semua fitur aplikasi dan komponen yang digunakan pada aplikasi **Movie Catalogue  (Local Storage).**
*   Informasi yang ditampilkan pada daftar ataupun detail film, tidak relevan.

*   Aplikasi **force closed**.

*   Project tidak bisa di-build.

*   Mengirimkan file selain proyek Android Studio.

*   Mengirimkan proyek yang bukan karya sendiri.

## Resources

Gunakan endpoint berikut untuk melakukan pencarian film.  
**Movies**: <span style="color:rgb(226,80,65);">https://api.themoviedb.org/3/search/movie?api_key=**{API KEY}**&language=en-US&query=</span>**<span style="color:rgb(226,80,65);">{MOVIE NAME}</span>**  
**Tv** **Show**: <span style="color:rgb(226,80,65);">https://api.themoviedb.org/3/search/tv?api_key=**{API KEY}**&language=en-US&query=</span>**<span style="color:rgb(226,80,65);">{TV SHOW NAME}</span>**  
**Contoh: **<span style="color:rgb(226,80,65);">https://api.themoviedb.org/3/search/movie?api_key=**123456789**&language=en-US&query=</span>**<span style="color:rgb(226,80,65);">Avenger</span>**

Gunakan endpoint berikut untuk mendapatkan film yang rilis pada tanggal hari ini.  
**Movies release**: <span style="color:rgb(209,72,65);">https://api.themoviedb.org/3/discover/movie?api_key={**API KEY**}&primary_release_date.gte={**TODAY DATE**}&primary_release_date.lte={**TODAY DATE**}</span>  
**Contoh**: <span style="color:rgb(209,72,65);">https://api.themoviedb.org/3/discover/movie?api_key=**123456789**&primary_release_date.gte=**2019-01-31**&primary_release_date.lte=**2019-01-31**</span>  
<span style="color:rgb(0,0,0);">**Catatan**: P<span style="color:rgb(0,0,0);">astikan format tanggal yang kalian gunakan benar.</span> Format tanggal yang digunakan adalah **"yyyy-MM-dd"**.</span>

**<span style="font-size:24px;">Ketentuan</span>**

Beberapa ketentuan umum dari proyek aplikasi:

*   Menggunakan **Android Studio.**

*   Menggunakan bahasa pemrograman **Kotlin** atau **Java**.

*   Mengirimkan pekerjaan Anda dalam bentuk folder Proyek Android Studio yang telah diarsipkan (**ZIP**). Jika Anda membuat** 2 (dua) proyek** untuk aplikasi **Provider** dan **Consumer**, harap arsip menjadi **1 (satu) berkas .zip** saja. **Hindari** juga ada** Zip di dalam Zip,** karena akan mengakibatkan submission Anda tidak bisa di-_extract_ pada platform dicoding dan tidak bisa direview menggunakan **inline review**.

*   Tim penilai akan mengulas submission Anda dalam waktu **selambatnya**** 3 (tiga) hari kerja** (tidak termasuk Sabtu, Minggu, dan hari libur nasional).
*   Tidak disarankan untuk melakukan submit berkali-kali karena akan memperlama proses penilaian yang dilakukan tim penilai.
*   Anda akan mendapat notifikasi hasil pengumpulan submission Anda via email, atau Anda dapat mengecek status submission pada akun Dicoding Anda.

## Tips

Sebelum mengirimkan proyek, pastikan Anda sudah mengekspornya dengan benar.

Bagaimana cara ekspor proyek ke dalam berkas **ZIP**?

1.  Pilih menu **File → Export to ZIP File...** pada Android Studio.

2.  Pilih direktori penyimpanan dan klik **OK**.

Dengan cara di atas, ukuran dari berkas **ZIP** akan lebih kecil dibandingkan Anda melakukan kompresi secara manual pada file explorer.

