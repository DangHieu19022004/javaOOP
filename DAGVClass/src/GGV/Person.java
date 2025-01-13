
package GGV;

public abstract class Person {
    private String MaDD;
    private String Hoten;
    private String Gioitinh;

    public Person(String MaDD, String Hoten, String Gioitinh) {
        this.MaDD = MaDD;
        this.Hoten = Hoten;
        this.Gioitinh = Gioitinh;
    }

    public Person() {
    }

    public String getMaDD() {
        return MaDD;
    }

    public void setMaDD(String MaDD) {
        this.MaDD = MaDD;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(String Gioitinh) {
        this.Gioitinh = Gioitinh;
    }
    
    public abstract String Xetthuong();
}
