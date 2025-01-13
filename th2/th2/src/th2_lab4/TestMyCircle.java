/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th2_lab4;

/**
 *
 * @author admin
 */
public class TestMyCircle {
    public static void main(String[] args) {
        MyCircle circle = new MyCircle(new MyPoint(5, 5), 10);

        System.out.println(circle);
        System.out.println("Area: " + circle.getArea());

        circle.setCenterXY(10, 10);
        circle.setRadius(20);

        System.out.println("Updated Circle: " + circle);
        System.out.println("New Area: " + circle.getArea());
    }
}

