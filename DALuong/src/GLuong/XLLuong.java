/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GLuong;

import java.sql.*;
import java.util.ArrayList;

public class XLLuong {
    private Connection conn;
    public Connection getCon(){
        String str = "jdbc:sqlserver://localhost:1433;databaseName=DLLuong;encrypt=false";
        try {
            return DriverManager.getConnection(str, "sa", "12345");
        } catch (Exception e) {
            return null;
        }
    }
    public ArrayList<Nhanvien> getNVbyMa(int MaNV){
        conn = getCon();
        ArrayList<Nhanvien> listNV = new ArrayList<>();
        String query = "SELECT * FROM tbNhanvien WHERE MaNV = ?";
        try {
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, MaNV);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                String Hoten = rs.getString(2);
                String Diachi = rs.getString(3);
                double Luong = rs.getDouble(4);
                String GT = rs.getString(5);
                Nhanvien nv = new Nhanvien(Diachi, Luong, GT, MaNV, Hoten);
                listNV.add(nv);
            }
            return listNV;
        } catch (Exception e) {
            System.out.println("err find: " + e);
            return null;
        }
    }
    public boolean updateNV(int MaNV, String Hoten, String Diachi, double Luong, String GT){
        String query = "UPDATE tbNhanvien SET Hoten = ?, Diachi = ?, Luong = ?, GT = ? WHERE MaNV = ?";
        conn = getCon();
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, Hoten);
            pre.setString(2, Diachi);
            pre.setDouble(3, Luong);
            pre.setString(4, GT);
            pre.setInt(5, MaNV);
            return pre.executeUpdate()>0;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean deleteNV(int MaNV){
        String query = "DELETE tbNhanvien WHERE MaNV = ?";
        conn = getCon();
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, MaNV);
            return pre.executeUpdate() >0;
        } catch (Exception e) {
            return false;
        }
    }
    public ArrayList<Nhanvien> getAllNV(){
        String query = "SELECT * FROM tbNhanvien";
        conn = getCon();
        ArrayList<Nhanvien> listNV = new ArrayList<>();
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                int MaNV = rs.getInt(1);
                String Hoten = rs.getString(2);
                String Diachi = rs.getString(3);
                double Luong = rs.getDouble(4);
                String GT = rs.getString(5);
                Nhanvien nv = new Nhanvien(Diachi, Luong, GT, MaNV, Hoten);
                listNV.add(nv);
            }
            return listNV;
        } catch (Exception e) {
            System.out.println("err get: " + e);
            return null;
        }
    }
    public boolean insertNV(int MaNV, String Hoten, String Diachi, double Luong, String GT){
        String query = "INSERT INTO tbNhanvien VALUES(?, ?, ?, ?, ?)";
        conn = getCon();
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, MaNV);
            pre.setString(2, Hoten);
            pre.setString(3, Diachi);
            pre.setDouble(4, Luong);
            pre.setString(5, GT);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
