/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GGV;

/**
 *
 * @author ACER
 */
public class Giangvien extends Person{

    private String Donvi;
    private int Soct;

    public Giangvien(int MaDD, String Hoten, String GT, String Donvi, int Soct) {
        super(MaDD, Hoten, GT);
        this.Donvi = Donvi;
        this.Soct = Soct;
    }

    public Giangvien() {
    }

    public String getDonvi() {
        return Donvi;
    }

    public void setDonvi(String Donvi) {
        this.Donvi = Donvi;
    }

    public int getSoct() {
        return Soct;
    }

    public void setSoct(int Soct) {
        this.Soct = Soct;
    }
    
    @Override
    public String Xetthuong(int Soct) {
        return (Soct > 10)? "Khen thuong" : null;
    }
}
