/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLCBpackage;

/**
 *
 * @author ACER
 */
public class Canbo {
    private int SoTK;
    private String Hoten;
    private String GT;
    private String Diachi;
    private double Luong;

    public Canbo() {
    }

    public Canbo(int SoTK, String Hoten, String GT, String Diachi, double Luong) {
        this.SoTK = SoTK;
        this.Hoten = Hoten;
        this.GT = GT;
        this.Diachi = Diachi;
        this.Luong = Luong;
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

    public double getLuong() {
        return Luong;
    }

    public void setLuong(double Luong) {
        this.Luong = Luong;
    }
    
    @Override
    public String toString() {
        return "Số TK: " + SoTK + ", Họ tên: " + Hoten + ", Giới tính: " + GT + 
               ", Địa chỉ: " + Diachi + ", Lương: " + Luong;
    }

}
