
# **DICODING MADE Submission 3**
# *Syahroni Wahyu Iriananda*

Anda sudah mempelajari beberapa hal tentang **Background Service**, salah satunya adalah bagaimana cara mendapatkan data dari internet menggunakan <span style="padding:2px 4px;color:#c7254e;background-color:#f9f2f4;">AsyncTaskLoader</span>**. **Untuk lanjut mempelajari modul berikutnya, kirimkan proyek aplikasi dengan tema Anda perlu** Movie Catalogue (API). **Jika pada submission sebelumnya Anda hanya memanfaatkan data lokal untuk ditampilkan, kali ini data yang akan ditampilkan adalah data dari API, yaitu [**The Movie DB**](https://www.themoviedb.org/)**.**

## Kriteria

Fitur yang harus ada pada aplikasi:

1.  **Daftar film  
    **Syarat:
    *   Terdapat 2 (dua) halaman yang menampilkan daftar film (**Movies** dan **Tv Show**)
    *   Menggunakan <span style="padding:2px 4px;color:#c7254e;background-color:#f9f2f4;">Fragment</span> untuk menampung halaman **Movies** dan **Tv Show**.
    *   Menggunakan <span style="padding:2px 4px;color:#c7254e;background-color:#f9f2f4;">RecyclerView</span> untuk menampilkan daftar film.
    *   Menggunakan<span> </span><span style="padding:2px 4px;color:#c7254e;background-color:#f9f2f4;">TabLayout</span>, <span style="padding:2px 4px;color:#c7254e;background-color:#f9f2f4;">BottomNavigationView</span> atau yang lainnya sebagai navigasi antara halaman<span> </span>**Movies**<span> </span>dan<span> </span>**Tv Show**.
    *   Menampilkan indikator loading ketika data sedang dimuat.  

2.  **Detail film  
    **Syarat:
    *   Menampilkan poster dan informasi film pada halaman detail film.
    *   Menggunakan <span style="padding:2px 4px;color:#c7254e;background-color:#f9f2f4;">ConstraintLayout</span> untuk menyusun layout.
    *   Menampilkan indikator loading ketika data sedang dimuat.  

3.  **Localization**  
    Syarat:
    *   Aplikasi harus mendukung bahasa Indonesia dan bahasa Inggris.  

4.  **Configuration Changes  
    **Syarat:
    *   Aplikasi harus bisa menjaga data yang sudah dimuat ketika terjadi pergantian orientasi dari potrait ke landscape atau sebaliknya.

Berikut kerangka tampilan yang bisa Anda gunakan sebagai referensi:

![20190304105622bf155a6cc53796c48877ad20d603e099.png](https://dicodingacademy.blob.core.windows.net/academies/20190304105622bf155a6cc53796c48877ad20d603e099.png)

Kesempatan untuk submission Anda diterima akan lebih besar jika:

*   Menggunakan library pihak ketiga seperti Retrofit, Fast Android Networking, dsb.
*   Menerapkan design pattern seperti MVP, MVVM, Arch Component, dsb.
*   Aplikasi bisa memberikan pesan eror jika data tidak berhasil ditampilkan.
*   Menuliskan kode dengan bersih.

Submission Anda akan ditolak jika:

*   Tidak menggunakan <span style="padding:2px 4px;color:#c7254e;background-color:#f9f2f4;">Fragment</span> untuk menampung halaman **Movies** dan **Tv** **Show****.**

*   Tidak menggunakan <span style="padding:2px 4px;color:#c7254e;background-color:#f9f2f4;">RecyclerView</span> untuk menampilkan daftar film.

*   Tidak menggunakan<span> </span><span style="padding:2px 4px;color:#c7254e;background-color:#f9f2f4;">TabLayout</span>, <span style="padding:2px 4px;color:#c7254e;background-color:#f9f2f4;">BottomNavigationView</span> atau yang lainnya sebagai navigasi antara **Movies** dan **Tv** **Show**.
*   Tidak menggunakan <span style="padding:2px 4px;color:#c7254e;background-color:#f9f2f4;">ConstraintLayout</span> untuk menyusun layout pada halaman detail film.
*   Tidak terdapat indikator loading.
*   Aplikasi tidak mendukung bahasa Indonesia dan bahasa Inggris.
*   Aplikasi tidak bisa menjaga data yang sudah dimuat ketika terjadi pergantian orientasi dari potrait ke landscape atau sebaliknya.
*   Menangani perubahan konfigurasi menggunakan tag <span style="padding:2px 4px;color:#c7254e;background-color:#f9f2f4;">android:configChanges</span> pada berkas <span style="padding:2px 4px;color:#c7254e;background-color:#f9f2f4;">AndroidManifest.xml</span>
*   Poster tidak berhasil ditampilkan.
*   Informasi yang ditampilkan pada daftar ataupun detail film, tidak relevan.

*   Project tidak bisa di-build.

*   Aplikasi force closed.

*   Mengirimkan file selain proyek Android Studio.

*   Mengirimkan proyek yang bukan karya sendiri.

## Resources

*   Untuk mendapatkan **API Key** silakan ikuti tutorial pada tautan berikut:  
    [https://blog.dicoding.com/registrasi-testing-themoviedb-api/](https://blog.dicoding.com/registrasi-testing-themoviedb-api/)
*   Gunakan endpoint berikut untuk mendapatkan data **Movies**:  
    <span style="color:rgb(226,80,65);">https://api.themoviedb.org/3/discover/movie?api_key=**{API KEY}**&language=en-US</span>
*   Gunakan endpoint berikut untuk mendapatkan data **Tv Show**:  
    <span style="color:rgb(226,80,65);">https://api.themoviedb.org/3/discover/tv?api_key=**{API KEY}**&language=en-US</span>
*   Gunakan url berikut untuk mendapatkan poster film.

    <span style="color:rgb(226,80,65);">https://image.tmdb.org/t/p/**{POSTER SIZE}**/</span>**<span style="color:rgb(226,80,65);">{POSTER FILENAME}</span>**

    **POSTER SIZE** di atas adalah ukuran dari poster yang ingin didapatkan. Tersedia beberapa ukuran yang dapat digunakan **w92**, **w154**, **w185**, **w342**, **w500**, **w780**, dan **original**. Sedangkan **POSTER FILENAME** adalah path poster yang bisa didapatkan dari responseJSON dengan key <span style="padding:2px 4px;color:#c7254e;background-color:#f9f2f4;">poster_path</span>.  
    **Contoh:**  
    [<span style="color:rgb(226,80,65);">https://image.tmdb.org/t/p**/****w185**/**kSBXou5Ac7vEqKd97wotJumyJvU.jpg**</span>](https://image.tmdb.org/t/p/w185/kSBXou5Ac7vEqKd97wotJumyJvU.jpg)

*   Penjelasan mengenai poster dapat Anda lihat pada tautan berikut:  
    [https://developers.themoviedb.org/3/configuration/get-api-configuration](https://developers.themoviedb.org/3/configuration/get-api-configuration)

## **<span style="font-size:24px;">Ketentuan</span>**

Beberapa ketentuan umum dari proyek aplikasi:

*   Menggunakan **Android Studio.**

*   Menggunakan bahasa pemrograman **Kotlin**<span> </span>atau **Java**.

*   Mengirimkan pekerjaan Anda dalam bentuk folder Proyek Android Studio yang telah diarsipkan (**ZIP**).

*   Tim penilai akan mengulas submission Anda dalam waktu **selambatnya**** 3 (tiga) hari kerja** (tidak termasuk Sabtu, Minggu, dan hari libur nasional).
*   Tidak disarankan untuk melakukan submit berkali-kali karena akan memperlama proses penilaian.
*   Anda akan mendapat notifikasi hasil pengumpulan submission Anda via email, atau Anda dapat mengecek status submission pada akun Dicoding Anda.

## Tips

Sebelum mengirimkan proyek, pastikan Anda sudah mengekspornya dengan benar.

Bagaimana cara ekspor proyek ke dalam berkas **ZIP**?

1.  Pilih menu **File → Export to ZIP File...** pada Android Studio.

2.  Pilih direktori penyimpanan dan klik **OK**.

Dengan cara di atas, ukuran dari berkas **ZIP** akan lebih kecil dibandingkan Anda melakukan kompresi secara manual pada file explorer.

## **<span style="font-size:24px;">Perhatian</span>**

![201911011417282a9425244900eb53c5a42a48ce780d56.png](https://dicodingacademy.blob.core.windows.net/academies/201911011417282a9425244900eb53c5a42a48ce780d56.png)

**Sesuai dengan termsofuse yang ada pada halaman [https://www.dicoding.com/termsofuse](https://www.dicoding.com/termsofuse), submission haruslah hasil karya Anda sendiri.**

**Kode yang didapatkan dari sumber lain (website, buku selain MADE, forum, GitHub, dan lain-lain) hanya digunakan sebagai referensi. Tingkat kesamaannya tidak boleh lebih dari 70%.**

**Kami berhak untuk <span style="color:rgb(226,80,65);">menonaktifkan akun peserta</span> jika gagal mematuhi peraturan yang berlaku.**
