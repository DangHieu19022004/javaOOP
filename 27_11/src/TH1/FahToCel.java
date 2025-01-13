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
public class FahToCel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Please enter a degree in Fahrenheit: ");
        double Fahrenheit = scanner.nextDouble();

        double Celsius = (5.0/9) * (Fahrenheit - 32.0);

       System.out.println("Fahrenheit " + String.format("%.2f", Fahrenheit) + " is " + String.format("%.2f", Celsius) + " in Celsius");


        
        scanner.close();
    }

}
