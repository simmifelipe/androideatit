package androideatit.dev.fb.com.androideatit.Model;

/**
 * Created by Felipe Simmi on 24/06/2018.
 */

public class User {

    private String phone;
    private String password;
    private String name;

    public User() {
    }

    public User(String phone, String password, String name) {
        this.phone = phone;
        this.password = password;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
