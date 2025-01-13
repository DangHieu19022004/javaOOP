/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th2_lab3;

/**
 *
 * @author admin
 */
public class Author {
    private String name;
    private String email;
    private char gender;

    // Constructor để khởi tạo các giá trị
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    // Getter cho name
    public String getName() {
        return this.name;
    }

    // Getter và setter cho email
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter cho gender
    public char getGender() {
        return this.gender;
    }

    // Phương thức toString
    @Override
    public String toString() {
        return this.name + " (" + this.gender + ") at " + this.email;
    }
}
