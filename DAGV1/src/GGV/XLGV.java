/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GGV;

import java.sql.*;
import java.util.ArrayList;

public class XLGV {
    private String str = "jdbc:sqlserver://localhost:1433;databaseName=DLGV;encrypt=false";
    private Connection conn = null;
    public Connection getCon(){
        try {
            conn = DriverManager.getConnection(str,"sa", "12345");
            return conn;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean insertGV(int MaDD, String Hoten, String GT, String Donvi, int Soct){
        conn = getCon();
        String query = "INSERT INTO tbGiangvien VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, MaDD);
            pre.setString(2, Hoten);
            pre.setString(3, GT);
            pre.setString(4, Donvi);
            pre.setInt(5, Soct);
            return pre.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println("err " + e);
            return false; 
        }
    }
    
    public ArrayList<Giangvien> getGV(){
        conn = getCon();
        String query = "SELECT * FROM tbGiangvien";
        ArrayList<Giangvien> listGV = new ArrayList<>();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                int MaDD = rs.getInt(1);
                String Hoten = rs.getString(2);
                String GT = rs.getString(3);
                String Donvi = rs.getString(4);
                int Soct = rs.getInt(5);
                Giangvien gv = new Giangvien(MaDD, Hoten, GT, Donvi, Soct);
                listGV.add(gv);
            }
            return listGV;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean upDateGV(int MaDD, String Hoten, String GT, String Donvi, int Soct){
        conn = getCon();
        String query = "UPDATE tbGiangvien SET Hoten = ?, GT = ?, Donvi = ?, Soct = ? WHERE MaDD = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, Hoten);
            pre.setString(2, GT);
            pre.setString(3, Donvi);
            pre.setInt(4, Soct);
            pre.setInt(5, MaDD);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("err update " + e);
            return false;
        }
    }
    
    public boolean deleteGV(int MaDD){
        conn = getCon();
        String query = "DELETE FROM tbGiangvien WHERE MaDD = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, MaDD);
            return pre.executeUpdate()>0;
        } catch (Exception e) {
            return false;
        }
    }
}
