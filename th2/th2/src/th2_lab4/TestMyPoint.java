/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th2_lab4;

/**
 *
 * @author admin
 */
public class TestMyPoint {
    public static void main(String[] args) {
        // Tạo đối tượng MyPoint
        MyPoint p1 = new MyPoint(3, 0);
        MyPoint p2 = new MyPoint(0, 4);

        // In thông tin
        System.out.println("Point 1: " + p1);
        System.out.println("Point 2: " + p2);

        // Kiểm tra các phương thức distance()
        System.out.println("Distance between p1 and p2: " + p1.distance(p2));
        System.out.println("Distance from p1 to (5, 6): " + p1.distance(5, 6));

        // Tạo mảng 10 điểm
        MyPoint[] points = new MyPoint[10];
        for (int i = 0; i < points.length; i++) {
            points[i] = new MyPoint(i + 1, i + 1);
        }

        // In mảng điểm
        for (MyPoint point : points) {
            System.out.println(point);
        }
    }
}

