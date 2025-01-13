/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLCBpackage;

import java.sql.ResultSet;

import java.sql.*;
public class QLCB implements ICanbo{

    private String str = "jdbc:sqlserver://localhost:1433;databaseName=QLCB;encrypt=false";
    private Connection conn = null;

    @Override
    public void getCon() {
        try {
            conn = DriverManager.getConnection(str, "sa", "12345");
            System.out.println("connect success");
        } catch (Exception e) {
            System.out.println("Err " + e.getMessage());
        }
    }
    
    @Override
    public ResultSet getCB() {
        try {
            String query = "SELECT * FROM tbCanbo";
            Statement exec = conn.createStatement();
            ResultSet result = exec.executeQuery(query);
            
            return result ;
        } catch (Exception e) {
            System.out.println("Err get CB: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void insertCB(int SoTK, String Hoten, String GT, String Diachi, double Luong) {
        getCon();
        try {
            String query = "insert into tbCanbo values(?, ?, ?, ?, ?)";
            PreparedStatement pre = conn.prepareStatement(query);
            
            pre.setInt(1, SoTK);
            pre.setString(2, Hoten);
            pre.setString(3, GT);
            pre.setString(4, Diachi);
            pre.setDouble(5, Luong);
            
            pre.executeUpdate();
            
            System.out.println("success insertCB");
        } catch (Exception e) {
            System.out.println("Err get CB: " + e.getMessage());
 
        }
    }

    @Override
    public void closeCon() {
        try {
            if(conn != null && !conn.isClosed()){
                conn.close();
                System.out.println("Connect closed");
            }
        } catch (Exception e) {
            System.out.println("Err get CB: " + e.getMessage());
        }
    }

    @Override
    public void updateCB(int SoTK, String Hoten, String GT, String Diachi, double Luong) {
        try {
            String query = "update tbCanbo set Hoten = ?, GT = ?, Diachi = ?, Luong = ? where SoTK = ?";
            PreparedStatement pre = conn.prepareStatement(query);
            
            pre.setString(1, Hoten);
            pre.setString(2, GT);
            pre.setString(3, Diachi);
            pre.setDouble(4, Luong);
            pre.setInt(5, SoTK);
            
            pre.executeUpdate();
            
            System.out.println("success updateCB");
        } catch (Exception e) {
            System.out.println("Err get CB: " + e.getMessage());
 
        }
    }

    @Override
    public void deleteCB(int SoTK) {
        try {
            String query = "delete from tbCanbo where SoTK = ?";
            PreparedStatement pre = conn.prepareStatement(query);
            
            pre.setInt(1, SoTK);
            
            pre.executeUpdate();
            
            System.out.println("success deleteCB");
        } catch (Exception e) {
            System.out.println("Err get CB: " + e.getMessage());
 
        }
    }


    
}
