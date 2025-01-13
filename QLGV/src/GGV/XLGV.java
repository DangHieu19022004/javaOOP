package GGV;
import java.sql.*;

public class XLGV  {
    public String str = "jdbc:sqlserver://localhost:1433;databaseName=QLGV;encrypt=false";
    Giangvien gv = new Giangvien();
    public Connection getCon(){
        try {
            Connection conn = DriverManager.getConnection(str, "sa", "12345");
            System.out.println("success");
            return conn;
        } catch (SQLException ex) {
            System.out.println("err " + ex);
            return null;
        }
    }
    
    public void getGV(String Donvi, int Soct) {
        Connection conn = getCon();
        if(conn == null){
            System.out.println("err");
            return;
        }
        
        String query = "SELECT * FROM tbGiangvien WHERE Donvi = ? AND Soct = ?";
        
        try(PreparedStatement strQuery = conn.prepareStatement(query)){
            strQuery.setString(1, Donvi);
            strQuery.setInt(2, Soct);
            
            ResultSet rs = strQuery.executeQuery();
            
            String Xetthuong = gv.Xetthuong(Soct);
            
            while(rs.next()){
                System.out.println("Ho ten " + "\t" + "GT " + "\t" + "Don vi " + "\t" + "So cong trinh "  + "Xet thuong");
                String Hoten = rs.getString("Hoten");
                String GT = rs.getString("GT");
                System.out.println(Hoten + "\t" + GT + "\t" + Donvi + "\t" + Soct + "\t" + Xetthuong);
            }
            
        }catch(Exception ex){
            System.out.println("err " + ex);
        }finally{
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println("err " + e);
            }
        }
    }

}
