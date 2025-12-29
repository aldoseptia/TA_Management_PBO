package service;

import model.TugasAkhir;
import java.util.List;

/**
 * Interface ITugasAkhir mendefinisikan
 * operasi CRUD untuk data Tugas Akhir.
 */
public interface ITugasAkhir {

    void tambah(TugasAkhir ta);

    List<TugasAkhir> tampilkan();

    void ubahStatus(int id, String status);

    void hapus(int id);
}
