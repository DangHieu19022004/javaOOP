/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package th2_lab2;

/**
 *
 * @author admin
 */
public class TestCircle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// Tạo instance cl với giá trị mặc định
        Circle c1 = new Circle();
        System.out.println("The circle has radius of " + c1.getRadius() + " and area of " + c1.getArea());

        // Tạo instance c2 với bán kính được chỉ định
        Circle c2 = new Circle(2.0);
        System.out.println("The circle has radius of " + c2.getRadius() + " and area of " + c2.getArea());
        
      //  Circle c3 = new Circle(3.0, "blue");
        //System.out.println("The circle has radius of " + c3.getRadius() + ", color of " + c3.getColor() + ", and area of " + c3.getArea());

        Circle c3 = new Circle(); // Tạo instance mới
        c3.setRadius(5.0);        // Thay đổi bán kính
        c3.setColor("green");     // Thay đổi màu sắc
        System.out.println("Circle c3 has radius of " + c3.getRadius() + ", color of " + c3.getColor());
        
        Circle c4 = new Circle(4.0, "yellow");
        System.out.println(c4.toString());  // Gọi tường minh
        System.out.println(c4);             // Gọi ngầm định

    }
    
}
