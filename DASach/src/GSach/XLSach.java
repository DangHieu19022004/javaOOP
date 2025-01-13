/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GSach;

import java.sql.Connection;
import java.util.ArrayList;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XLSach implements ISach {
    private String str = "jdbc:sqlserver://localhost:1433;databaseName=DLSach1;encrypt=false";
    private Connection conn;
    
    @Override
    public Connection getCon() {
        try {
            conn = DriverManager.getConnection(str, "sa", "12345");
            return conn;
        } catch (SQLException ex) {
            return null;
        }
       
    }

    @Override
    public ArrayList<Sach> getSA() {
        conn = getCon();
        String query = "SELECT * FROM tbSach";
        ArrayList<Sach> listSach = new ArrayList<>();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                int MaS = rs.getInt(1);
                String TenS = rs.getString(2);
                String NhaXB = rs.getString(3);
                int NamXB = rs.getInt(4);
                double GiaB = rs.getDouble(5);
                Sach s = new Sach(MaS, TenS, NhaXB, NamXB, GiaB);
                listSach.add(s);
            }
            return listSach;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Sach> getSAbyNXBGB(int NamXB, double GiaB) {
        conn = getCon();
        String query = "SELECT * FROM tbSach WHERE NamXB = ? AND GiaB = ?";
        ArrayList<Sach> listSach = new ArrayList<>();
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, NamXB);
            pre.setDouble(2, GiaB);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                int MaS = rs.getInt(1);
                String TenS = rs.getString(2);
                String NhaXB = rs.getString(3);
                Sach s = new Sach(MaS, TenS, NhaXB, NamXB, GiaB);
                listSach.add(s);
            }
            return listSach;
        } catch (Exception e) {
            System.out.println("err filter: " + e);
            return null;
        }
    }

    @Override
    public boolean createSach(int MaS, String TenS, String NhaXB, int NamXB, double GiaB) {
        conn = getCon();
        String query = "INSERT INTO tbSach VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, MaS);
            pre.setString(2, TenS);
            pre.setString(3, NhaXB);
            pre.setInt(4, NamXB);
            pre.setDouble(5, GiaB);
            return pre.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println("err create: " + e);
            return false;
        }
    }

    @Override
    public boolean updateSach(int MaS, String TenS, String NhaXB, int NamXB, double GiaB) {
        conn = getCon();
        String query = "UPDATE tbSach SET TenS = ?, NhaXB = ?, NamXB = ?, GiaB = ? WHERE MaS = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, TenS);
            pre.setString(2, NhaXB);
            pre.setInt(3, NamXB);
            pre.setDouble(4, GiaB);
            pre.setInt(5, MaS);
            return pre.executeUpdate()>0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteSach(int MaS) {
        conn = getCon();
        String query = "DELETE FROM tbSach WHERE MaS = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, MaS);
            return pre.executeUpdate()>0;
        } catch (Exception e) {
            return false;
        }
    }
    
}
