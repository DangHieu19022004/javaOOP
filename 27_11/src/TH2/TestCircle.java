/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TH2;

/**
 *
 * @author Acer
 */
public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        
        System.out.println("The circle has radius of " + c1.getRadius() + " and area of " + c1.getArea());
        
        Circle c2 = new Circle(2.0);
        
        System.out.println("The circle has radius of " + c2.getRadius() + " and area of " + c2.getArea());
        
        c1.setColor("blue");
        System.out.println(c1.getColor());
        
        System.out.println(c2.toString());
        System.out.println(c2);
        
    }
}
