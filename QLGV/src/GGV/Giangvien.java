/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GGV;

/**
 *
 * @author ACER
 */
public class Giangvien extends Person {
    private String Donvi;
    private int Soct;

    
    
    public String getDonvi() {
        return Donvi;
    }

    public int getSoct() {
        return Soct;
    }

    public void setDonvi(String Donvi) {
        this.Donvi = Donvi;
    }

    public void setSoct(int Soct) {
        this.Soct = Soct;
    }

    public Giangvien() {
    }

    public Giangvien(String Donvi, int Soct, String MaDD, String HoTen, String GT) {
        super(MaDD, HoTen, GT);
        this.Donvi = Donvi;
        this.Soct = Soct;
    }

    
    
    @Override
    public String Xetthuong(int Soct) {
        if (Soct > 10){
            return "Khen";
        }else{
            return "Khen";
        }
    }
    
}
