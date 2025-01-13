/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th2_lab3;

/**
 *
 * @author admin
 */
public class Book {
    private String name;
    private Author author;
    private double price;
    private int qtyInStock;

    // Constructor với 3 tham số
    public Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qtyInStock = 0; // Mặc định số lượng là 0
    }

    // Constructor với 4 tham số
    public Book(String name, Author author, double price, int qtyInStock) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qtyInStock = qtyInStock;
    }

    // Getter và setter
    public String getName() {
        return this.name;
    }

    public Author getAuthor() {
        return this.author;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtyInStock() {
        return this.qtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    // Phương thức toString
    @Override
    public String toString() {
        return "'" + this.name + "' by " + this.author.toString();
    }

    // Các phương thức bổ sung
    public String getAuthorName() {
        return this.author.getName();
    }

    public String getAuthorEmail() {
        return this.author.getEmail();
    }

    public char getAuthorGender() {
        return this.author.getGender();
    }
}

