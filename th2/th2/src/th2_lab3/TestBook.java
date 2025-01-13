/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th2_lab3;

/**
 *
 * @author admin
 */
public class TestBook {
    public static void main(String[] args) {
        // Tạo một tác giả
        Author anAuthor = new Author("Tan Ah Teck", "ahteck@somewhere.com", 'm');

        // Tạo một cuốn sách
        Book aBook = new Book("Java for Dummy", anAuthor, 19.95, 1000);
        System.out.println(aBook); // Gọi toString()

        // Sử dụng các phương thức của Book
        System.out.println("Author's name: " + aBook.getAuthorName());
        System.out.println("Author's email: " + aBook.getAuthorEmail());
        System.out.println("Author's gender: " + aBook.getAuthorGender());

        // Thay đổi giá sách và số lượng
        aBook.setPrice(25.95);
        aBook.setQtyInStock(1200);
        System.out.println("Updated price: " + aBook.getPrice());
        System.out.println("Updated quantity in stock: " + aBook.getQtyInStock());
    }
}

