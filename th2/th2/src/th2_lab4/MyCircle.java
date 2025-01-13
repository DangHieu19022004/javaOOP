/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th2_lab4;

/**
 *
 * @author admin
 */
public class MyCircle {
    private MyPoint center;
    private int radius;

    // Constructor với tọa độ (x, y) và bán kính
    public MyCircle(int x, int y, int radius) {
        this.center = new MyPoint(x, y);
        this.radius = radius;
    }

    // Constructor với MyPoint làm tâm
    public MyCircle(MyPoint center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    // Getters và Setters
    public MyPoint getCenter() {
        return center;
    }

    public void setCenter(MyPoint center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getCenterX() {
        return center.getX();
    }

    public int getCenterY() {
        return center.getY();
    }

    public void setCenterXY(int x, int y) {
        center.setXY(x, y);
    }

    // Phương thức toString
    @Override
    public String toString() {
        return "Circle @ " + center + " radius=" + radius;
    }

    // Tính diện tích
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
