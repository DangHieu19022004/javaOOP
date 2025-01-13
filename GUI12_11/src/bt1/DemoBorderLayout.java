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
public class DemoBorderLayout extends JFrame{
    private JButton
        bn = new JButton("North"),
        bs = new JButton("South"),
        be = new JButton("East"),
        bw = new JButton("West"),
        bc = new JButton("Center");

    public DemoBorderLayout(){
        setTitle("BorderLayout");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        add(BorderLayout.NORTH, bn);
        add(BorderLayout.SOUTH, bs);
        add(BorderLayout.EAST, be);
        add(BorderLayout.WEST, bw);
        add(BorderLayout.CENTER, bc);
        
        bn.setBackground(Color.red);
        bn.setForeground(Color.white);
        be.setBackground(Color.blue);
        be.setForeground(Color.white);
    }
    
    public static void main(String[] args) {
        new DemoBorderLayout().setVisible(true);
    }
}
