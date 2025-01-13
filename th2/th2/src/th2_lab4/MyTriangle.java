/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th2_lab4;

/**
 *
 * @author admin
 */
public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    // Constructor với tọa độ 3 điểm
    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.v1 = new MyPoint(x1, y1);
        this.v2 = new MyPoint(x2, y2);
        this.v3 = new MyPoint(x3, y3);
    }

    // Constructor với 3 đối tượng MyPoint
    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    // Phương thức toString
    @Override
    public String toString() {
        return "Triangle @ " + v1 + ", " + v2 + ", " + v3;
    }

    // Tính chu vi
    public double getPerimeter() {
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }

    // Xác định loại tam giác
    public void printType() {
        double side1 = v1.distance(v2);
        double side2 = v2.distance(v3);
        double side3 = v3.distance(v1);

        if (side1 == side2 && side2 == side3) {
            System.out.println("Equilateral");
        } else if (side1 == side2 || side2 == side3 || side3 == side1) {
            System.out.println("Isosceles");
        } else {
            System.out.println("Scalene");
        }
    }
}
