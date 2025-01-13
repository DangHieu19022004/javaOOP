/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLCB;

import java.util.Scanner;


public class Test_insertCB {
    public static void doInsertCB(int SoTK, String Hoten, String GT, String Diachi, double Luong){
        QLCB qlcb = new QLCB();
        if(qlcb.insertCB(SoTK, Hoten, GT, Diachi, Luong)){
            System.out.println("insert success");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        doInsertCB(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.nextDouble());
    }
}
