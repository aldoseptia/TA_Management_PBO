import model.TugasAkhir;
import service.ITugasAkhir;
import service.TugasAkhirService;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * MainApp merupakan class utama (entry point) aplikasi.
 * Class ini berfungsi untuk menampilkan menu, menerima input pengguna,
 * serta menghubungkan user dengan service layer.
 */
public class MainApp {

    public static void main(String[] args) {

        // Scanner digunakan untuk menerima input dari user melalui console
        Scanner scanner = new Scanner(System.in);

        // Pemanggilan service menggunakan interface
        // untuk menerapkan konsep abstraction dan loose coupling
        ITugasAkhir service = new TugasAkhirService();

        int pilihan;

        // Perulangan menu akan terus berjalan selama user belum memilih keluar
        do {
            System.out.println("\n=== SISTEM MANAJEMEN JUDUL TUGAS AKHIR ===");
            System.out.println("1. Tambah Judul TA");
            System.out.println("2. Tampilkan Judul TA");
            System.out.println("3. Ubah Status Judul");
            System.out.println("4. Hapus Judul");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            try {
                // Input pilihan menu
                pilihan = scanner.nextInt();
                scanner.nextLine(); // membersihkan buffer

                // Percabangan menu menggunakan switch-case
                switch (pilihan) {
                    case 1:
                        // Input data Tugas Akhir dari user
                        System.out.print("NIM: ");
                        String nim = scanner.nextLine();

                        System.out.print("Nama Mahasiswa: ");
                        String nama = scanner.nextLine();

                        System.out.print("Judul TA: ");
                        String judul = scanner.nextLine();

                        // Membuat object TugasAkhir
                        // Tanggal pengajuan di-set otomatis menggunakan LocalDate
                        TugasAkhir ta = new TugasAkhir(
                                nim,
                                nama,
                                judul,
                                LocalDate.now(),
                                "DIAJUKAN"
                        );

                        // Memanggil method tambah melalui interface
                        service.tambah(ta);
                        break;

                    case 2:
                        // Menampilkan seluruh data Tugas Akhir
                        for (TugasAkhir data : service.tampilkan()) {
                            System.out.println(data.infoSingkat());
                        }
                        break;

                    case 3:
                        // Mengubah status judul Tugas Akhir
                        System.out.print("Masukkan ID TA: ");
                        int idUbah = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Status Baru: ");
                        String status = scanner.nextLine();

                        service.ubahStatus(idUbah, status);
                        break;

                    case 4:
                        // Menghapus data Tugas Akhir berdasarkan ID
                        System.out.print("Masukkan ID TA: ");
                        int idHapus = scanner.nextInt();
                        scanner.nextLine();

                        service.hapus(idHapus);
                        break;

                    case 0:
                        // Keluar dari program
                        System.out.println("Keluar dari program.");
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.");
                }

            } catch (InputMismatchException e) {
                // Exception handling jika input menu bukan angka
                System.out.println("Input harus berupa angka.");
                scanner.nextLine(); // membersihkan input yang salah
                pilihan = -1;
            }

        } while (pilihan != 0);

        // Menutup scanner setelah program selesai
        scanner.close();
    }
}
