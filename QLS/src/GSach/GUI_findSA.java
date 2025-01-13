
package GSach;

import javax.swing.*;
public class GUI_findSA extends JFrame{
    private int currenntRow = -1;
    private XLSach xl = new XLSach();
    public GUI_findSA(){
        setSize(920, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        JComboBox<String> cbxb = new JComboBox<>
        xl.getCon();
    }
    
    public static void main(String[] args) {
        new GUI_findSA().setVisible(true);
    }
    
    
}
