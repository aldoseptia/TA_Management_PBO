package service;

import config.DatabaseHelper;
import model.TugasAkhir;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TugasAkhirService merupakan implementasi
 * dari interface ITugasAkhir.
 * Class ini menangani operasi CRUD menggunakan JDBC.
 */
public class TugasAkhirService implements ITugasAkhir {

    // Menambahkan data Tugas Akhir ke database
    @Override
    public void tambah(TugasAkhir ta) {
        String sql = "INSERT INTO tugas_akhir (nim, nama_mahasiswa, judul, tanggal_pengajuan, status) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Mengisi parameter query
            stmt.setString(1, ta.getNim());
            stmt.setString(2, ta.getNamaMahasiswa());
            stmt.setString(3, ta.getJudul());
            stmt.setDate(4, Date.valueOf(ta.getTanggalPengajuan()));
            stmt.setString(5, ta.getStatus());

            stmt.executeUpdate();
            System.out.println("Judul Tugas Akhir berhasil ditambahkan.");

        } catch (SQLException e) {
            System.out.println("Gagal menambahkan data: " + e.getMessage());
        }
    }

    // Mengambil seluruh data Tugas Akhir dari database
    @Override
    public List<TugasAkhir> tampilkan() {
        List<TugasAkhir> daftar = new ArrayList<>();
        String sql = "SELECT * FROM tugas_akhir";

        try (Connection conn = DatabaseHelper.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Membaca hasil query baris per baris
            while (rs.next()) {
                TugasAkhir ta = new TugasAkhir(
                        rs.getInt("id"),
                        rs.getString("nim"),
                        rs.getString("nama_mahasiswa"),
                        rs.getString("judul"),
                        rs.getDate("tanggal_pengajuan").toLocalDate(),
                        rs.getString("status")
                );
                daftar.add(ta);
            }

        } catch (SQLException e) {
            System.out.println("Gagal mengambil data: " + e.getMessage());
        }

        return daftar;
    }

    // Mengubah status Tugas Akhir
    @Override
    public void ubahStatus(int id, String status) {
        String sql = "UPDATE tugas_akhir SET status = ? WHERE id = ?";

        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);
            stmt.setInt(2, id);

            stmt.executeUpdate();
            System.out.println("Status berhasil diubah.");

        } catch (SQLException e) {
            System.out.println("Gagal mengubah status: " + e.getMessage());
        }
    }

    // Menghapus data Tugas Akhir berdasarkan id
    @Override
    public void hapus(int id) {
        String sql = "DELETE FROM tugas_akhir WHERE id = ?";

        try (Connection conn = DatabaseHelper.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Data berhasil dihapus.");

        } catch (SQLException e) {
            System.out.println("Gagal menghapus data: " + e.getMessage());
        }
    }
}
