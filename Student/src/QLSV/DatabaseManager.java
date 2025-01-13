/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLSV;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    QLSV qlsv = new QLSV();
    private Connection conn;
    private String str = "jdbc:sqlserver://localhost:1433;databaseName=QLSV;encrypt=false";
    
    public Connection getCon(){
        try {
            conn = DriverManager.getConnection(str, "sa", "12345");
            return conn;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean insertSV(String ten, String maso, String nganhhoc){
        conn = getCon();
        String query = "INSERT INTO students VALUES(?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            
            pre.setString(1, ten);
            pre.setString(2, maso);
            pre.setString(3, nganhhoc);
            
            return pre.executeUpdate()>0;
            
        } catch (Exception e) {
            return false;
        }
    }
    
    public ArrayList<Student> getStu(){
        conn = getCon();
        String query = "SELECT * FROM students";
        ArrayList<Student> liststu = new ArrayList<>();
        
        try {
            Statement stm = conn.createStatement();
            ResultSet student = stm.executeQuery(query);
            if(student != null){
                while(student.next()){
                    Student stu = new Student(student.getString(1), student.getString(2), student.getString(3));
                    liststu.add(stu);
                }
            }
            return liststu;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean deleteStu(String major){
    conn = getCon();
        String query = "DELETE students WHERE major=?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            
            pre.setString(1, major);
            
            return pre.executeUpdate()>0;
            
        } catch (Exception e) {
            return false;
        }
    }
}
