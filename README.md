# Java Syntax and Data Types Handson Practice

**Nama:** [Billyandre Suwandi]
**NIM:** [2481024]
**Kelas:** [Teknik Informatika]
**Mata Kuliah:** Pemrograman Berorientasi Objek

## Catatan Pembelajaran
**1. Struktur file Java**
Java memiliki aturan ketat terkait urutan package, import, dan deklarasi class. Jika urutannya salah, kode tidak akan dikenali dan akan muncul error seperti “illegal start of type,” sehingga memahami struktur dasar ini sangat penting untuk menghindari error fundamental.

**2. Konflik import dengan nama class yang sama**
Kamu menyadari bahwa dua class dengan nama yang sama dari package berbeda tidak bisa di-import sekaligus karena Java tidak tahu mana yang harus dipakai. Untuk mengatasinya, kamu perlu mengimpor salah satu class saja dan menggunakan fully qualified name untuk class lainnya.

**3. Error terjadi karena tipe object tidak cocok**
Kamu menemukan bahwa banyak error pemanggilan method muncul karena tipe objek yang dikirim tidak sesuai dengan tipe parameter yang diminta. Ini mengajarkan pentingnya memastikan bahwa class yang digunakan benar dan berasal dari package yang sesuai.

**4. Prinsip OCP (Open-Closed Principle)**
Kamu mempelajari bahwa class yang baik harus bisa diperluas tanpa perlu diubah. Dengan memisahkan implementasi ke class-class terpisah dan menggunakan interface atau abstraction, fitur baru dapat ditambah tanpa merusak atau memodifikasi kode lama.

**5. Prinsip LSP (Liskov Substitution Principle)**
Kamu belajar bahwa subclass harus dapat menggantikan parent class tanpa membuat program berperilaku rusak, seperti contoh ReadOnlySender yang melanggar kontrak parent karena melempar exception. Dengan desain ulang yang benar, seluruh subclass dapat digunakan secara polymorphic tanpa menyebabkan error.