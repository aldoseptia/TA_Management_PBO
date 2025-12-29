package model;

/**
 * Class Mahasiswa merupakan turunan dari User
 * yang merepresentasikan pengguna mahasiswa.
 */
public class Mahasiswa extends User {

    public Mahasiswa(String nim, String nama) {
        super(nim, nama);
    }

    @Override
    public String getRole() {
        return "MAHASISWA";
    }
}
