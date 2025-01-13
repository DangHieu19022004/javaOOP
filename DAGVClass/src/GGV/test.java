/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GGV;

import java.sql.*;
import java.util.Scanner;
import java.util.*;

public class test {
    public static List<Giangvien> doGet(String Donvi, int soCT){
        XLGV xl = new XLGV();
        xl.getCon();
        ResultSet rs = xl.getGV(Donvi, soCT);
        List<Giangvien> listgv = new ArrayList<>();
        try {
            while (rs.next()) {
                String madd = rs.getString(1);
                String hoten = rs.getString(2);
                String gt = rs.getString(3);
                String soct = rs.getString(4);
                Giangvien gv = new Giangvien(Donvi, soCT, madd, hoten, hoten);
                System.out.println(madd + "\t" + hoten + "\t"  + gt);
                listgv.add(gv);
                
            }
        } catch (SQLException ex) {
            System.out.println("err " + ex.getMessage());
            return null;
        }
        return listgv;
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String donvi = in.nextLine();
        int soct = in.nextInt();
        doGet(donvi, soct);

    }
}
