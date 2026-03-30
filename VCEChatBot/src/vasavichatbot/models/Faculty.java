package vasavichatbot.models;

import java.io.Serializable;

public class Faculty implements Serializable {
    private String name;
    private String department;
    private String designation;
    private String email;
    private String phone;

    public Faculty(String name, String department, String designation, String email, String phone) {
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
