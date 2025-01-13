/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GGV;

/**
 *
 * @author Admin
 */
public class Giangvien extends Person {

    private String donVi;
    private int soCT;

    public Giangvien() {
    }

    public Giangvien(String donVi, int soCT, String maDD, String hoTen, String gioiTinh) {
        super(maDD, hoTen, gioiTinh);
        this.donVi = donVi;
        this.soCT = soCT;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public int getSoCT() {
        return soCT;
    }

    public void setSoCT(int soCT) {
        this.soCT = soCT;
    }

    

    public String Xetthuong() {
//        if(soCT>10) return "Khen thuong";
//        return "";
        return (soCT > 10) ? "Khen thuong" : "";
    }

}
