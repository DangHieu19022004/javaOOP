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
public class DemoGridLayout extends JFrame {
    public DemoGridLayout(){
        setTitle("GridLayout");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        setLayout(new GridLayout(7, 3, 15, 5)); //row=7, column=3, h=5, v5
        for(int i=1; i<=20; i++){
            add(new JButton("btn " + i));
        }
    }
    
    public static void main(String[] args) {
        new DemoGridLayout().setVisible(true);
    }
}
