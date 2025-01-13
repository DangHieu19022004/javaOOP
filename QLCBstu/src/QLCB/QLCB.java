/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLCB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class QLCB implements ICanbo{
    private Connection conn;
    String str = "jdbc:sqlserver://localhost:1433;databaseName=QLCB;encrypt=false";
    @Override
    public Connection getCon() {
        try {
            conn = DriverManager.getConnection(str, "sa", "12345");
            System.out.println("success con");
            return conn;
        } catch (Exception e) {
            System.out.println("err con" + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean insertCB(int SoTK, String Hoten, String GT, String Diachi, double Luong) {
        conn = getCon();
        String query = "INSERT INTO tbCanbo VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, SoTK);
            pre.setString(2, Hoten);
            pre.setString(3, GT);
            pre.setString(4, Diachi);
            pre.setDouble(5, Luong);
            return pre.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println("err insert" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateCB(int SoTK, String Hoten, String GT, String Diachi, double Luong) {
        conn = getCon();
        String query = "UPDATE tbCanbo SET Hoten=?, GT=?, Diachi=?, Luong=? WHERE SoTK=?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            
            pre.setString(1, Hoten);
            pre.setString(2, GT);
            pre.setString(3, Diachi);
            pre.setDouble(4, Luong);
            pre.setInt(5, SoTK);
            
            return pre.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println("err update" + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteCB(int SoTK) {
        conn = getCon();
        String query = "DELETE tbCanbo WHERE SoTK=?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, SoTK);
            
            return pre.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println("err update" + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Canbo> showCB() {
        conn = getCon();
        List<Canbo> lcb = new ArrayList<>();
        String query = "SELECT * FROM tbCanbo";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                int SoTK = rs.getInt(1);
                String Hoten = rs.getString(2);
                String GT = rs.getString(3);
                String Diachi = rs.getString(4);
                double Luong = rs.getDouble(5);
                Canbo cbn = new Canbo(SoTK, Hoten, GT, Diachi, Luong);
                lcb.add(cbn);
            }
            return lcb;
        } catch (Exception e) {
            System.out.println("err show" + e.getMessage());
            return null;
        }
    }
    
}
