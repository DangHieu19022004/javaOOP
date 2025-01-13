/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TH1;
import java.util.Scanner;
/**
 *
 * @author Acer
 */
public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double a, b, c, p, Area;
        
        System.out.print("Please enter the three sides of a triangle: "  );
        a = scanner.nextDouble();
        
        b = scanner.nextDouble();
        
        c = scanner.nextDouble();
        
        p = (a+b+c)/2;
        
        Area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        
        System.out.printf("The area of this triangle with sides: %.1f %.1f %.1f is: %.1f \n", a, b, c, Area );
        
    }
}
