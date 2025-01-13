/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CKH;

import java.sql.*;
import java.util.List;
public interface IKhachhang {
    Connection getCon();
    boolean insertKH(int SoTK, String Hoten, String GT, String Diachi, double Sodu);
    List<Khachhang> showKH();
    boolean updateKH(int SoTK, String Hoten, String GT, String Diachi, double Sodu);
    boolean deleteKH(int SoTK);
}
