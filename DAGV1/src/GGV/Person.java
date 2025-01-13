package GGV;

public abstract class Person {
    private int MaDD;
    private String Hoten;
    private String GT;

    public Person() {
    }

    public Person(int MaDD, String Hoten, String GT) {
        this.MaDD = MaDD;
        this.Hoten = Hoten;
        this.GT = GT;
    }

    public abstract String Xetthuong(int Soct);
    
    public int getMaDD() {
        return MaDD;
    }

    public void setMaDD(int MaDD) {
        this.MaDD = MaDD;
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
    
}
