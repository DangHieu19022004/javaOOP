
package TH2;

import java.util.HashSet;

public class Circle {
    private double radius;
    private String color;

    public Circle() {
        radius = 1.0;
        color = "red";
    }

    public Circle(double r) {
        radius = r;
        color = "red";
    }

//    1. Constructor

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }
    
//    2. Getter
    public String getColor() {
        return color;
    }
    
//    4.Setter
    public void setRadius(double r) {
        radius = r;
    }

//    5.setter
    public void setColor(String c) {
        color = c;
    }
    
//    6. toString
    public String toString() {
        return "Circle: radius=" + radius + " color=" + color;
    }
    
    
    public double getRadius(){
        return radius;
    }
    
    public double  getArea(){
        return radius*radius*Math.PI;
    }
    
}
