/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package QLCB;

import java.sql.*;
import java.util.List;
public interface ICanbo {
    Connection getCon();
    boolean insertCB(int SoTK, String Hoten, String GT, String Diachi, double Luong);
    boolean updateCB(int SoTK, String Hoten, String GT, String Diachi, double Luong);
    boolean deleteCB(int SoTK);
    List<Canbo> showCB();
}
