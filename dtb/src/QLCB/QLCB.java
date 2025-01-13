package QLCB;

import java.sql.*;

public class QLCB implements ICanBo {
    
//    for mysql conn = "http://localhost....
    
    public String str = "jdbc:sqlserver://localhost:1433;encrypt=false";
    
    
    @Override
    public void getCon() {
        try {
            Connection conn = DriverManager.getConnection(str, "sa", "12345");
            System.out.println("Connected success");
        } catch (SQLException ex) {
            System.out.println("ERR: " + ex.getMessage());
        }
    }

    @Override
    public void inSertCB(CanBo cb) {
        
    }
    
}
