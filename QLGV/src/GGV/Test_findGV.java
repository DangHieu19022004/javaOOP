package GGV;


public class Test_findGV {
    public static void dogetGV(String Donvi, int Soct){
        XLGV conn = new XLGV();
        conn.getGV(Donvi, Soct);
    }
    
    public static void main(String[] args) {
        dogetGV("4", 4);
    }
    
}
