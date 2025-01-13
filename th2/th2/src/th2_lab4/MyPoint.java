/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th2_lab4;

/**
 *
 * @author admin
 */
public class MyPoint {
    private int x;
    private int y;

    // Constructor không đối số, mặc định (0, 0)
    public MyPoint() {
        this.x = 0;
        this.y = 0;
    }

    // Constructor có đối số
    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters và Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Phương thức toString
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // Phương thức distance() với tọa độ (x, y)
    public double distance(int x, int y) {
        int xDiff = this.x - x;
        int yDiff = this.y - y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    // Phương thức distance() với một điểm MyPoint khác
    public double distance(MyPoint another) {
        int xDiff = this.x - another.x;
        int yDiff = this.y - another.y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}

