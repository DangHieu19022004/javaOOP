/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th2_lab4;

/**
 *
 * @author admin
 */
public class TestMyTriangle {
    public static void main(String[] args) {
        MyTriangle triangle = new MyTriangle(new MyPoint(0, 0), new MyPoint(4, 0), new MyPoint(0, 3));

        System.out.println(triangle);
        System.out.println("Perimeter: " + triangle.getPerimeter());

        triangle.printType();
    }
}
