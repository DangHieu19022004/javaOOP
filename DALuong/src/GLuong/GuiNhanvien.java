/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GLuong;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class GuiNhanvien extends JFrame {
    private XLLuong xll = new XLLuong();
    private JLabel lbMaNV, lbHoten, lbDiachi, lbLuong, lbGT;
    private JTextField tfMaNV, tfHoten, tfLuong;
    private JRadioButton rdNam, rdNu;
    private ButtonGroup gbtnGender;
    private JComboBox<String> cbbDiachi;
    private JTable table;
    private DefaultTableModel dftb;
    private JButton btnD, btnI, btnF,btnU;
    
    public GuiNhanvien(){
    
        setLayout(new BorderLayout());
        setTitle("Quan ly nhan vien");
        setSize(400, 500);
        
        //panel input
        JPanel panelInput = new JPanel(new GridLayout(6, 2, 5, 5));
        
        lbMaNV = new JLabel("Ma nhan vien");
        lbHoten = new JLabel("Ho ten");
        lbDiachi = new JLabel("Dia chi");
        lbLuong = new JLabel("Luong");
        lbGT = new JLabel("Gioi tinh");
        
        tfMaNV = new JTextField();
        tfHoten = new JTextField();
        cbbDiachi = new JComboBox(new Object[] {"Hai Phong", "Ha Noi", "Nam Dinh"});
        tfLuong = new JTextField();
        JPanel panelGT = new JPanel(new GridLayout(1, 2, 3, 3));
        rdNam = new JRadioButton("Nam");
        rdNu = new JRadioButton("Nu");
        gbtnGender = new ButtonGroup();
        gbtnGender.add(rdNam);
        gbtnGender.add(rdNu);
        panelGT.add(rdNam);
        panelGT.add(rdNu);
        
        panelInput.add(lbMaNV);
        panelInput.add(tfMaNV);
        panelInput.add(lbHoten);
        panelInput.add(tfHoten);
        panelInput.add(lbDiachi);
        panelInput.add(cbbDiachi);
        panelInput.add(lbLuong);
        panelInput.add(tfLuong);
        panelInput.add(lbGT);
        panelInput.add(panelGT);
        
        
        //table
        Object[] colname = {"Ma nhan vien", "Ho ten", "Dia chi", "Luong", "Gioi tinh"};
        dftb = new DefaultTableModel(colname, 0);
        table = new JTable(dftb);
        JScrollPane scrollPane = new JScrollPane(table);
        
        
        //btn
        btnD = new JButton("delete");
        btnF = new JButton("Tim kiem");
        btnI = new JButton("Insert");
        btnU = new JButton("update");
        
        JPanel panelbtn = new JPanel(new GridLayout(1, 4, 5, 5));
        panelbtn.add(btnD);
        panelbtn.add(btnF);
        panelbtn.add(btnI);
        panelbtn.add(btnU);
        
        
        //add main layout
        add(panelInput, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelbtn, BorderLayout.SOUTH);
        
        actionbtn();
        
        setVisible(true);
    }
    
    public void actionbtn(){
        resetDtb();
        btnD.addActionListener(e -> {
            int MaNV = Integer.parseInt(tfMaNV.getText());
            if(xll.deleteNV(MaNV)){
                resetDtb();
                JOptionPane.showMessageDialog(null, "delete success");
            }
        });
        btnF.addActionListener(e -> {
            int MaNV = Integer.parseInt(tfMaNV.getText());
            ArrayList<Nhanvien> listnv = new ArrayList<>();
            listnv = xll.getNVbyMa(MaNV);
            if(listnv != null){
                dftb.setRowCount(0);
                for(Nhanvien nv : listnv){
                    dftb.addRow(new Object[] {nv.getMaNV(), nv.getHoten(), nv.getDiachi(), nv.getLuong(), nv.getGT()});
                }
            }
        });
        btnI.addActionListener(e -> {
            int MaNV = Integer.parseInt(tfMaNV.getText());
            String Hoten = tfHoten.getText();
            String Diachi = cbbDiachi.getSelectedItem().toString();
            Double Luong = Double.parseDouble(tfLuong.getText());
            String GT = rdNam.isSelected() ? "Nam" : rdNu.isSelected() ? "Nu" : "Khac";
            if(xll.insertNV(MaNV, Hoten, Diachi, Luong, GT)){
                JOptionPane.showMessageDialog(null, "Add success");
                resetDtb();
            }
        });
        btnU.addActionListener(e -> {
            int MaNV = Integer.parseInt(tfMaNV.getText());
            String Hoten = tfHoten.getText();
            String Diachi = cbbDiachi.getSelectedItem().toString();
            Double Luong = Double.parseDouble(tfLuong.getText());
            String GT = rdNam.isSelected() ? "Nam" : rdNu.isSelected() ? "Nu" : "Khac";
            if(xll.updateNV(MaNV, Hoten, Diachi, Luong, GT)){
                JOptionPane.showMessageDialog(null, "Add success");
                resetDtb();
            }
        });
    }
    
    public void resetDtb(){
        dftb.setRowCount(0);
        ArrayList<Nhanvien> listnv = new ArrayList<>();
        listnv = xll.getAllNV();
        if(listnv != null){
            for(Nhanvien nv : listnv){
                dftb.addRow(new Object[] {nv.getMaNV(), nv.getHoten(), nv.getDiachi(), nv.getLuong(), nv.getGT()});
            }
        }
    }
    
    public static void main(String[] args) {
        new GuiNhanvien();
    }
}