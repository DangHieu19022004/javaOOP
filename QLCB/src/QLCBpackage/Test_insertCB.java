
package QLCBpackage;

import java.util.*;
import java.sql.*;

public class Test_insertCB {
    public static void doInsertCB(QLCB qlcb ){
        qlcb.getCon();       
        qlcb.insertCB(1, "meo", "nam", "tm", 240);
    }
    
    public static List<Canbo> doGetCB(QLCB qlcb){
        qlcb.getCon();
        ResultSet rs = qlcb.getCB();
        List<Canbo> listCB = new ArrayList<>();
        try {
            while(rs.next()){
                int SoTK = rs.getInt(1);
                String Hoten = rs.getString(2);
                String GT = rs.getString(3);
                String Diachi = rs.getString(4);
                double Luong = rs.getDouble(5);
                Canbo cb = new Canbo(SoTK, Hoten, GT, Diachi, Luong);
                System.out.println(SoTK + "\t" + Hoten + "\t" + GT + "\t" + Diachi + "\t" + Luong);
                listCB.add(cb);
            }
        } catch (Exception e) {
            System.out.println("err " + e.getMessage());
            return null;
        }
        return listCB;
    }
    
    public static void main(String[] args) {
//        QLCB qlcb = new QLCB();
//        qlcb.getCon();
////        doInsertCB(qlcb);
//        doGetCB(qlcb);
//       
    }
}
