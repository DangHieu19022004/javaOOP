/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th2_lab3;

/**
 *
 * @author admin
 */
public class TestAuthor {

    public static void main(String[] args) {
        // Tạo một tác giả
        Author anAuthor = new Author("Tan Ah Teck", "ahteck@somewhere.com", 'm');
        System.out.println(anAuthor); // Gọi toString()

        // Thay đổi email và in lại thông tin
        anAuthor.setEmail("paul@nowhere.com");
        System.out.println(anAuthor);
    }
}


