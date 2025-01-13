/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt1;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Acer
 */
public class DemoBoxLayout {
    public static void main(String[] args) {
        JFrame blo = new JFrame();
        blo.setTitle("BoxLayout");
        blo.setSize(450, 250);
        blo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        blo.setLocationRelativeTo(null);
        blo.setResizable(true);
        
        Box bv, bh1, bh2, bv1;
        blo.add(bv = Box.createVerticalBox());
        bv.add(bh1 = Box.createHorizontalBox());
        bv.add(bv1 = Box.createVerticalBox());
        bv.add(bh2 = Box.createHorizontalBox());
        
        
        for(int i=0; i<3; i++){
            bh1.add(Box.createHorizontalGlue());
            bh1.add(new JButton("btn " + i));
        }
        
        bh1.add(Box.createHorizontalGlue());
        
        for(int i = 0; i<5; i++){
            bh2.add(new JButton("btn2 " + i));
        }
        
        for(int i = 0; i<5; i++){
            bv1.add(Box.createVerticalBox());
            bv1.add(new JButton("btnbv1 " + i));
        }
        
        bv1.add(Box.createVerticalStrut(5));
        
        blo.setVisible(true);
    }
}
