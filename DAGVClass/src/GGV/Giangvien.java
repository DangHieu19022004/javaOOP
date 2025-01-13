
package GGV;

public class Giangvien extends Person {
    private String Donvi;
    private int soCT;

    public Giangvien(String Donvi, int soCT, String MaDD, String Hoten, String Gioitinh) {
        super(MaDD, Hoten, Gioitinh);
        this.Donvi = Donvi;
        this.soCT = soCT;
    }

    public Giangvien(String Donvi, int soCT) {
        this.Donvi = Donvi;
        this.soCT = soCT;
    }

    

    public Giangvien() {
    }

    
    public String getDonvi() {
        return Donvi;
    }

    public void setDonvi(String Donvi) {
        this.Donvi = Donvi;
    }

    public int getSoCT() {
        return soCT;
    }

    public void setSoCT(int soCT) {
        this.soCT = soCT;
    }
    
    
    
    @Override
    public String Xetthuong() {
        if (soCT > 10) {
            return "Thuong";
        } else {
            return "";
        }
    }
    
}
