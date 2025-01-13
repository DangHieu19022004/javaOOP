/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th2_lab5;
import java.util.Scanner;

public class MyComplexApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập số phức thứ nhất
        System.out.print("Enter complex number 1 (real and imaginary part): ");
        double real1 = sc.nextDouble();
        double imag1 = sc.nextDouble();
        MyComplex num1 = new MyComplex(real1, imag1);

        // Nhập số phức thứ hai
        System.out.print("Enter complex number 2 (real and imaginary part): ");
        double real2 = sc.nextDouble();
        double imag2 = sc.nextDouble();
        MyComplex num2 = new MyComplex(real2, imag2);

        // Hiển thị giá trị
        System.out.println("Number 1 is: " + num1);
        System.out.println("Number 2 is: " + num2);

        // Kiểm tra real và imaginary
        System.out.println(num1 + " is " + (num1.isReal() ? "" : "NOT ") + "a pure real number");
        System.out.println(num1 + " is " + (num1.isImaginary() ? "" : "NOT ") + "a pure imaginary number");
        System.out.println(num2 + " is " + (num2.isReal() ? "" : "NOT ") + "a pure real number");
        System.out.println(num2 + " is " + (num2.isImaginary() ? "" : "NOT ") + "a pure imaginary number");

        // So sánh hai số phức
        System.out.println(num1 + " is " + (num1.equals(num2) ? "" : "NOT ") + "equal to " + num2);

        // Thực hiện các phép toán
        System.out.println(num1 + " + " + num2 + " = " + num1.add(num2));
        System.out.println(num1 + " - " + num2 + " = " + num1.subtract(num2));
        num1.multiplyWith(num2);
        System.out.println(num1 + " * " + num2 + " = " + num1);
        num1.setValue(real1, imag1); // Đặt lại giá trị gốc
        num1.divideBy(num2);
        System.out.println(num1 + " / " + num2 + " = " + num1);

        sc.close();
    }
}
