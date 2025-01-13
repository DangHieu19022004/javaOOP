/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GGV;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Test_findGV {

    public static List<Giangvien> dogetGV(String donVi, int soCT) {
        XLGV xl = new XLGV();
        xl.getCon();
        ResultSet rs = xl.getGV(donVi, soCT);
        List<Giangvien> gvList = new ArrayList<>();
        try {

            while (rs.next()) {
                String maDD = rs.getString("MaDD");
                String hoTen = rs.getString(2);
                String GT = rs.getString(3);
                String dv = rs.getString(4);
                int soCt = rs.getInt(5);
                Giangvien gv = new Giangvien(dv, soCT, maDD, hoTen, GT);
                gvList.add(gv);
                System.out.println(maDD + " " + hoTen + " " + GT + " " + dv + " " + soCT + "");
            }//? ? 
        } catch (SQLException ex) {
        }
        return gvList;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap don vi: ");
        String dv = scan.nextLine();
        System.out.println("Nhap so cong trinh: ");
        int soCt = scan.nextInt();
        dogetGV(dv, soCt);
    }
}
