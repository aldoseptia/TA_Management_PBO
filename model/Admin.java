package model;

/**
 * Class Admin merupakan turunan dari User,
 * memiliki hak pengelolaan data.
 */
public class Admin extends User {

    public Admin(String id, String nama) {
        super(id, nama);
    }

    @Override
    public String getRole() {
        return "ADMIN";
    }
}
