/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GGV;

/**
 *
 * @author Admin
 */
public abstract class Person {
    private String maDD;
    private String hoTen;
    private String gioiTinh;

    public Person() {
    }

    public Person(String maDD, String hoTen, String gioiTinh) {
        this.maDD = maDD;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
    }

    public String getMaDD() {
        return maDD;
    }

    public void setMaDD(String maDD) {
        this.maDD = maDD;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public abstract String Xetthuong();
    
}
