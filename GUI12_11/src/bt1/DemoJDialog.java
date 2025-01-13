/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt1;

import javax.swing.*;

/**
 *
 * @author Acer
 */
public class DemoJDialog extends JDialog {
    
    public DemoJDialog(){
        setTitle("Demo JDialog");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300,200);
        setResizable(false);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new DemoJDialog();
    }
}
