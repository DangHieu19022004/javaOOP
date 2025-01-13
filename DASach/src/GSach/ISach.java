/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GSach;

import java.sql.*;
import java.util.ArrayList;

public interface ISach {
    Connection getCon();
    ArrayList<Sach> getSA();
    ArrayList<Sach> getSAbyNXBGB(int NamXB, double GiaB);
    boolean createSach(int MaS, String TenS, String NhaXB, int NamXB, double GiaB);
    boolean updateSach(int MaS, String TenS, String NhaXB, int NamXB, double GiaB);
    boolean deleteSach(int MaS);
    
}
