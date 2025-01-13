/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th2_lab2;

/**
 *
 * @author admin
 */
public class Circle {
    private double radius;
    private String color;

    // Constructor 1: đặt giá trị mặc định
    public Circle() {
        this.radius = 1.0;
        this.color = "red";
    }
    // Constructor nhận bán kính và màu sắc
    public Circle(double radius, String color) {
         this.radius = radius;
         this.color = color;
}


    // Constructor 2: nhận bán kính, màu mặc định
    public Circle(double r) {
        this.radius = r;
        this.color = "red";
    }

    // Phương thức lấy bán kính
    public double getRadius() {
        return this.radius;
    }

    // Phương thức tính diện tích hình tròn
    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }

  
    
    // Getter cho biến màu sắc
    public String getColor() {
        return this.color;
}
    // Setter cho bán kính
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Setter cho màu sắc
    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public String toString() {
    return "Circle: radius = " + this.radius + " color = " + this.color;
}

}
