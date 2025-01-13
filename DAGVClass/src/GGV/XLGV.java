/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GGV;

import java.sql.*;
public class XLGV {
    private String str = "jdbc:sqlserver://localhost:1433;databaseName=QLGV;encrypt=false";
    private Connection conn=null;
    public  void getCon(){
        try {
            conn = DriverManager.getConnection(str, "sa", "12345");
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("err" + e.getMessage());
        }
    }
    
    public ResultSet getGV(String Donvi, int SoCT){
        try {
            String query = "Select * from tbGiangvien where Donvi like N'%"+Donvi+"%' and Soct = "+SoCT+"";
            Statement que = conn.createStatement(); //Statement query nhanh hon preparestatement
            ResultSet kq = que.executeQuery(query);
            
            return kq; 
            
//            PreparedStatement get = conn.prepareStatement(query);
//            get.executeQuery();
        } catch (SQLException e) {
            System.out.println("Err" + e.getMessage());
            return null;
        }
        
    }
    
}
