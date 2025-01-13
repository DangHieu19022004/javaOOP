
package MyPoint;

public class MyPoint {
    private int x;
    private int y;

    public MyPoint() {
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public String toString(){
        return x + y + "";
    }
    
    public double distance(int x, int y){
        int xD = this.x - x;
        int yD = this.y - y;
        return Math.sqrt(xD*xD + yD*yD);
    }
    
    
}
