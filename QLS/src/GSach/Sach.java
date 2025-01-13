/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GSach;

/**
 *
 * @author ACER
 */
public class Sach {
    private int MaS;
    private String TenS;
    private String NhaXB;
    private int NamXB;
    private float GiaB;

    public Sach(int MaS, String TenS, String NhaXB, int NamXB, float GiaB) {
        this.MaS = MaS;
        this.TenS = TenS;
        this.NhaXB = NhaXB;
        this.NamXB = NamXB;
        this.GiaB = GiaB;
    }

    public int getMaS() {
        return MaS;
    }

    public void setMaS(int MaS) {
        this.MaS = MaS;
    }

    public String getTenS() {
        return TenS;
    }

    public void setTenS(String TenS) {
        this.TenS = TenS;
    }

    public String getNhaXB() {
        return NhaXB;
    }

    public void setNhaXB(String NhaXB) {
        this.NhaXB = NhaXB;
    }

    public int getNamXB() {
        return NamXB;
    }

    public void setNamXB(int NamXB) {
        this.NamXB = NamXB;
    }

    public float getGiaB() {
        return GiaB;
    }

    public void setGiaB(float GiaB) {
        this.GiaB = GiaB;
    }
    
    public float Khuyenmai(int NamXB, float GiaB){
        float giab = 0;
        if(NamXB<2019){
           giab = GiaB - GiaB*25/100;
        }
        return giab;
    }
    
    

}
