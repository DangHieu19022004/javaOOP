
package bt1;

import javax.swing.*;


public class DemoJFrame extends JFrame {
    
    public DemoJFrame(){
        setTitle("Demo JFrame");
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false); // disable resize
    }
    
    public static void main(String[] args) {
        new DemoJFrame().setVisible(true);
    }
}
