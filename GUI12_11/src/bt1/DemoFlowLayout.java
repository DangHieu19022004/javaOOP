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
public class DemoFlowLayout extends JFrame {
    
    public DemoFlowLayout(){
        setTitle("FlowLayout");
        setSize(300, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        setLayout(new FlowLayout());
        for(int i=1; i<=20; i++){
            add(new JButton("Button " + i));
        }
    }
    
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setLayout(new FlowLayout(FlowLayout.CENTER));
        jf.add(new JButton("btn"));
        jf.add(new JButton("btn")); // Thêm nút vào JFrame
        jf.setSize(200, 100); // Thiết lập kích thước cửa sổ
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đóng ứng dụng khi tắt cửa sổ
        jf.setVisible(true);
    }
}
