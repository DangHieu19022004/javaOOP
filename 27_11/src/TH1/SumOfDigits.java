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
public class SumOfDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int a, sum = 0;
  
        
        do {            
            System.out.print("Type integer: ");
        
            a = scanner.nextInt();
        
        } while (a<=0 || a>=1000);
        
        char[] str = Integer.toString(a).toCharArray();
        
        for(int i=0; i<str.length; i++){
            sum += (str[i] - '0');
            
        }
        
        System.out.println("sum: " + sum);
        
        scanner.close();
    }
}
