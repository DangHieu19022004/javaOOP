/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CKH;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class XLKH implements IKhachhang {
    Connection conn;
    String str = "jdbc:sqlserver://localhost:1433;databaseName=DLKH;encrypt=false";
    
    @Override
    public Connection getCon() {
        try {
            conn = DriverManager.getConnection(str, "sa", "12345");
            System.out.println("success con");
            return conn;
        } catch (Exception e) {
            System.out.println("err conn " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean insertKH(int SoTK, String Hoten, String GT, String Diachi, double Sodu) {
        conn = getCon();
        String query = "INSERT INTO tbKhachhang VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            
            pre.setInt(1, SoTK);
            pre.setString(2, Hoten);
            pre.setString(3, GT);
            pre.setString(4, Diachi);
            pre.setDouble(5, Sodu);
            if (pre.executeUpdate() > 0) {
                System.out.println("insert success");
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            System.out.println("err insert " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Khachhang> showKH() {
        conn = getCon();
        List<Khachhang> listKH= new ArrayList<>();
        String query = "SELECT * FROM tbKhachhang";
        try {
            Statement stm;
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {                
                Khachhang kh = new Khachhang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
                listKH.add(kh);
            }
            return listKH;
        } catch (SQLException ex) {
            System.out.println("err show " +ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean updateKH(int SoTK, String Hoten, String GT, String Diachi, double Sodu) {
        conn = getCon();
        String query = "UPDATE tbKhachhang SET Hoten = ?, GT = ?, Diachi = ?, Sodu = ? WHERE SoTK = ? ";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            
            pre.setString(1, Hoten);
            pre.setString(2, GT);
            pre.setString(3, Diachi);
            pre.setDouble(4, Sodu);
            pre.setInt(5, SoTK);

            return pre.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("err update " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteKH(int SoTK) {
        conn = getCon();
        String query = "DELETE tbKhachhang WHERE SoTK = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            
            pre.setInt(1, SoTK);

            return pre.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("err update " + e.getMessage());
            return false;
        }
    }
    
}
