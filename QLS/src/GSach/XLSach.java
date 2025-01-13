
package GSach;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class XLSach implements ISach{
    String str = "jdbc:sqlserver://localhost:1433;databaseName=DLSach;encrypt=false";
    Connection conn = null;
    
    @Override
    public void getCon() {
        try {
            conn = DriverManager.getConnection(str, "sa", "12345");
            System.out.println("Success");
        } catch (SQLException e) {
            System.out.println("Ex: " + e.getMessage());
        }
    }

    @Override
    public List<Sach> getSA() {
        List<Sach> SachList = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from tbSach");
            while(rs.next()){
                Sach s = new Sach(rs.getInt("MaS"), rs.getString("TenS"), rs.getString("NhaXB"), rs.getInt("NamXB"), rs.getFloat("GiaB"));
                SachList.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Ex: " + e.getMessage());
        }
        return SachList;
    }

    
    @Override
    public List<Sach> getSAbyNXBGB(String nhaxb) {
        List<Sach> SachList = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from tbSach where NhaSB = '" + nhaxb + "'");
            while(rs.next()){
                Sach sa = new Sach(rs.getInt("MaS"), rs.getString("TenS"), rs.getString("NhaXB"), rs.getInt("NamXB"), rs.getFloat("GiaB"));
                SachList.add(sa);
            }
        } catch (SQLException e) {
            System.out.println("Ex: " + e.getMessage());
        }
        return SachList;
    }
    
}
