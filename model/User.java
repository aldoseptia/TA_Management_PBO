package model;

/**
 * Class User merupakan superclass abstrak
 * yang menjadi dasar untuk Mahasiswa dan Admin.
 */
public abstract class User {

    protected String id;
    protected String nama;

    public User(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    // Method abstrak untuk membedakan peran user
    public abstract String getRole();
}
