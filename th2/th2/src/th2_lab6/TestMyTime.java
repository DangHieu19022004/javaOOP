/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th2_lab6;

public class TestMyTime {
     public static void main(String[] args) {
        MyTime time = new MyTime(23, 59, 59);

        System.out.println("Initial time: " + time);
        System.out.println("Next second: " + time.nextSecond());
        System.out.println("Next minute: " + time.nextMinute());
        System.out.println("Next hour: " + time.nextHour());
        System.out.println("Previous second: " + time.previousSecond());
        System.out.println("Previous minute: " + time.previousMinute());
        System.out.println("Previous hour: " + time.previousHour());
    }
}
