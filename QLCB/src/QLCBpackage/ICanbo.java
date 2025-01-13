/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package QLCBpackage;

import java.sql.*;
public interface ICanbo {
    void getCon();
    void insertCB(int SoTK, String Hoten, String GT, String Diachi, double Luong);
    void closeCon();
    void updateCB(int SoTK, String Hoten, String GT, String Diachi, double Luong);
    void deleteCB(int SoTK);
    ResultSet getCB();
}
