/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GTS;

import java.sql.*;
import java.util.*;

public class XLTS implements IThisinh {

    private Connection conn;
    private String str = "jdbc:sqlserver://localhost:1433;databaseName=DLTS;encrypt=false";
    
    @Override
    public Connection getCon() {
        try {
            return DriverManager.getConnection(str, "sa", "12345");
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Thisinh> getTS() {
        conn = getCon();
        String query = "SELECT * FROM tbThisinh";
        ArrayList<Thisinh> listTS = new ArrayList<>();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {                
                Thisinh ts = new Thisinh(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
                listTS.add(ts);
            }
            return listTS;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean insertTS(int SoBD, String Hoten, String GT, String NganhH, double TongD) {
        conn = getCon();
        String query = "INSERT INTO tbThisinh VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, SoBD);
            pre.setString(2, Hoten);
            pre.setString(3, GT);
            pre.setString(4, NganhH);
            pre.setDouble(5, TongD);
            return pre.executeUpdate()>0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateTS(int SoBD, String Hoten, String GT, String NganhH, double TongD) {
        conn = getCon();
        String query = "UPDATE tbThisinh SET Hoten = ?, GT = ?, NganhH = ?, TongD = ? WHERE SoBD = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, Hoten);
            pre.setString(2, GT);
            pre.setString(3, NganhH);
            pre.setDouble(4, TongD);
            pre.setInt(5, SoBD);
            return pre.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
        
    }

    @Override
    public boolean deleteTS(int SoBD) {
        conn = getCon();
        String query = "DELETE tbThisinh WHERE SoBD = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, SoBD);
            return pre.executeUpdate() > 0 ;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ArrayList<Thisinh> findTS(String NganhH, double TongD) {
        conn = getCon();
        String query = "SELECT * FROM tbThisinh WHERE NganhH like ? AND TongD = ?";
        ArrayList<Thisinh> listTS = new ArrayList<>();
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, "%" + NganhH + "%");
            pre.setDouble(2, TongD);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                Thisinh ts = new Thisinh(rs.getInt(1), rs.getString(2), rs.getString(3), NganhH, TongD);
                listTS.add(ts);
            }
            return listTS;
        } catch (Exception e) {
            return null;
        }
    }
    
}
