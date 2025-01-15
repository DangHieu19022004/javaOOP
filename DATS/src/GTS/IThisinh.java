/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GTS;


import java.sql.*;
import java.util.ArrayList;

public interface IThisinh {
    Connection getCon();
    ArrayList<Thisinh> getTS();
    boolean insertTS(int SoBD, String Hoten, String GT, String NganhH, double TongD);
    boolean updateTS(int SoBD, String Hoten, String GT, String NganhH, double TongD);
    boolean deleteTS(int SoBD);
    ArrayList<Thisinh> findTS(String NganhH, double TongD);
}
