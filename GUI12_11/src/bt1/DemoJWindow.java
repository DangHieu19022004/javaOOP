/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
/**
 *
 * @author Acer
 */
public class DemoJWindow extends JWindow{
    
    public DemoJWindow(){
        setSize(400, 200);
        setLocationRelativeTo(null); // Cửa sổ nằm giữa màn hình

        // Thêm nội dung vào JWindow
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Chào mừng bạn đến với ứng dụng!", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));

        panel.add(label, BorderLayout.CENTER);
        add(panel);
    }
    
    public static void main(String[] args) {
        new DemoJWindow().setVisible(true);
    }
}
