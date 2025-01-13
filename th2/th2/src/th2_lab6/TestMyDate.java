/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th2_lab6;

public class TestMyDate {
     public static void main(String[] args) {
        MyDate date = new MyDate(2011, 12, 28);

        System.out.println("Initial date: " + date);
        while (!(date.getYear() == 2012 && date.getMonth() == 3 && date.getDay() == 2)) {
            date.nextDay();
            System.out.println(date);
        }
    }
}
