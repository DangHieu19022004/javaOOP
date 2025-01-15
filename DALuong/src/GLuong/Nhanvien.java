/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GLuong;

/**
 *
 * @author ACER
 */
public class Nhanvien extends Person {
    private String Diachi;
    private double Luong;
    private String GT;

    public Nhanvien(String Diachi, double Luong, String GT, int MaNV, String Hoten) {
        super(MaNV, Hoten);
        this.Diachi = Diachi;
        this.Luong = Luong;
        this.GT = GT;
    }

    public Nhanvien(String Diachi, double Luong, String GT) {
        this.Diachi = Diachi;
        this.Luong = Luong;
        this.GT = GT;
    }

    public Nhanvien() {
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

    public String getGT() {
        return GT;
    }

    public void setGT(String GT) {
        this.GT = GT;
    }

    @Override
    public String toString() {
        return "Nhanvien [MaNV=" + getMaNV() + ", HoTen=" + getHoten() + ", DiaChi=" + getDiachi() + ", Luong=" + getLuong() + ", GioiTinh=" + getGT() + "]";
    }
    
}
