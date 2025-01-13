/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt1;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
/**
 *
 * @author Acer
 */
public class BoxLayoutPanel extends JPanel {
    public BoxLayoutPanel(){
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));
        Box row = Box.createHorizontalBox();
        for(int i=0; i<4; i++){
            JButton b = new JButton("B " + i);
            b.setFont(new Font("serif", Font.BOLD, 12 + i * 2));
            row.add(b);
        }
        add(row, BorderLayout.NORTH);
        JPanel col = new JPanel();
        col.setLayout(new BoxLayout(col, BoxLayout.Y_AXIS));
        col.setBorder(new TitledBorder(new EtchedBorder(), "Column"));
        
        for(int i = 0; i<4; i++){
            JButton b = new JButton("btn4 " + i);
            b.setFont(new Font("sanserif", Font.BOLD, 10 + i * 2));
            col.add(b);
        }
        add(col, BorderLayout.EAST);
        
        
    }
    
    public static void main(String[] args) {
        
    }
}
