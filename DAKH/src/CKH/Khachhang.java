/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CKH;

/**
 *
 * @author ACER
 */
public class Khachhang {
    private int SoTK;
    private String Hoten;
    private String GT;
    private String Diachi;
    private double Sodu;

    public Khachhang() {
    }

    public Khachhang(int SoTK, String Hoten, String GT, String Diachi, double Sodu) {
        this.SoTK = SoTK;
        this.Hoten = Hoten;
        this.GT = GT;
        this.Diachi = Diachi;
        this.Sodu = Sodu;
    }

    public int getSoTK() {
        return SoTK;
    }

    public void setSoTK(int SoTK) {
        this.SoTK = SoTK;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getGT() {
        return GT;
    }

    public void setGT(String GT) {
        this.GT = GT;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public double getSodu() {
        return Sodu;
    }

    public void setSodu(double Sodu) {
        this.Sodu = Sodu;
    }
    
    public String toString(){
        return SoTK + Hoten + GT + Diachi + Sodu;
    }
}
