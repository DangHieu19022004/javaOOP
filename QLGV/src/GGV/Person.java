/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GGV;

/**
 *
 * @author ACER
 */
public abstract class Person {
    private String MaDD;
    private String HoTen;
    private String GT;

    public String getMaDD() {
        return MaDD;
    }

    public String getHoTen() {
        return HoTen;
    }

    public String getGT() {
        return GT;
    }

    public void setMaDD(String MaDD) {
        this.MaDD = MaDD;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public void setGT(String GT) {
        this.GT = GT;
    }

    public Person() {
    }

    public Person(String MaDD, String HoTen, String GT) {
        this.MaDD = MaDD;
        this.HoTen = HoTen;
        this.GT = GT;
    }
    
    
    
    public abstract String Xetthuong(int Soct);
    
}
