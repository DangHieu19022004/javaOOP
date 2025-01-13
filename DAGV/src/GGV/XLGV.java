/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GGV;

/**
 *
 * @author Admin
 */
import java.sql.*;

public class XLGV {

    private String str = "jdbc:sqlserver://localhost:1433;databaseName=DLGV;encrypt=false";
    private Connection conn = null;

    public void getCon() {
        try {
            conn = DriverManager.getConnection(str, "sa", "Quang12345@");
            System.out.println("Connect succses");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public ResultSet getGV(String donVi, int soCT) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from tbGiangvien where  DonVi like N'%" + donVi + "%' and Soct=" + soCT + "");
            return rs;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public ResultSet getDataByMa(String maDD) {
        try {
            Statement st = conn.createStatement();
            return st.executeQuery("select * from tbGiangvien where  MaDD like N'%" + maDD + "%' ");
        } catch (SQLException e) {
            System.out.println("Error get data by MaDD: " + e.getMessage());
            return null;
        }
    }

    public boolean updateData(String maDD, Giangvien gv) {
        try {

            PreparedStatement pst = conn.prepareStatement("update tbGiangvien set hoTen=N'" + gv.getHoTen() + "',GT=N'" + gv.getGioiTinh() + "',Donvi='"+gv.getDonVi()+"',Soct=" + gv.getSoCT()+ "where MaDD='" + gv.getMaDD() + "'");
            int res = pst.executeUpdate();
            return res > 0; //true-> tra ve(>1), false-> ko có
        } catch (SQLException e) {
            System.out.println("Errot update: " + e.getMessage());
            return false;
        }
    }

    public boolean insertData(Giangvien gv) {
        try {

            PreparedStatement pst = conn.prepareStatement("insert into tbGiangvien values ('" + gv.getMaDD()+ "', N'" + gv.getHoTen() + "',N'"+gv.getGioiTinh()+"', N'" + gv.getDonVi()+ "', " + gv.getSoCT()+ ")");
            int res = pst.executeUpdate();
            return res > 0; //true-> tra ve(>1), false-> ko có
        } catch (SQLException e) {
            System.out.println("Error insert: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteData(String maDD) {
        try {

            PreparedStatement pst = conn.prepareStatement("delete from tbGiangvien where MaDD='" + maDD + "'");
            int res = pst.executeUpdate();
            return res > 0; //true-> tra ve(>1), false-> ko có
        } catch (SQLException e) {
            System.out.println("Error delete: " + e.getMessage());
            return false;
        }
    }

    public ResultSet getAllData() {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from tbGiangVien");
            return rs;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

}
