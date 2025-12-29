package model;

import java.time.LocalDate;

/**
 * Class TugasAkhir merepresentasikan entitas data
 * judul Tugas Akhir mahasiswa dalam sistem.
 * Class ini digunakan sebagai model dan disimpan ke database.
 */
public class TugasAkhir {

    private int id;
    private String nim;
    private String namaMahasiswa;
    private String judul;
    private LocalDate tanggalPengajuan;
    private String status;

    // Constructor untuk INSERT data baru
    public TugasAkhir(String nim, String namaMahasiswa, String judul,
                      LocalDate tanggalPengajuan, String status) {
        this.nim = nim;
        this.namaMahasiswa = namaMahasiswa;
        this.judul = judul.toUpperCase(); // normalisasi string
        this.tanggalPengajuan = tanggalPengajuan;
        this.status = status;
    }

    // Constructor untuk READ data dari database
    public TugasAkhir(int id, String nim, String namaMahasiswa, String judul,
                      LocalDate tanggalPengajuan, String status) {
        this.id = id;
        this.nim = nim;
        this.namaMahasiswa = namaMahasiswa;
        this.judul = judul.toUpperCase();
        this.tanggalPengajuan = tanggalPengajuan;
        this.status = status;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getNim() {
        return nim;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public String getJudul() {
        return judul;
    }

    public LocalDate getTanggalPengajuan() {
        return tanggalPengajuan;
    }

    public String getStatus() {
        return status;
    }

    // Setter
    public void setStatus(String status) {
        this.status = status;
    }

    // Menampilkan data dalam format ringkas
    public String infoSingkat() {
        return id + " | " + nim + " | " + namaMahasiswa + " | " +
               judul + " | " + tanggalPengajuan + " | " + status;
    }
}
