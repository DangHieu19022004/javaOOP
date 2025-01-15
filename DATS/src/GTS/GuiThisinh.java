/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GTS;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class GuiThisinh extends JFrame {
    
    private XLTS xlts = new XLTS();
    private JLabel lbSBD, lbTen, lbGT, lbNganhH, lbTongD;
    private JTextField tfSBD, tfTen, tfGT, tfNganhH, tfTongD;
    private JButton btnInsert, btnUpdate, btnDelete, btnSearch;
    private JTable table;
    private DefaultTableModel dftb;
    
    public GuiThisinh(){
    
        //main layout
        setLayout(new BorderLayout());
        setTitle("Quan ly thi sinh");
        setSize(600, 700);
        
        
        //input
        JPanel panelInput = new JPanel(new GridLayout(6, 2, 5, 5));
        
        lbSBD = new JLabel("So bao danh");
        lbTen = new JLabel("Ten");
        lbGT = new JLabel("GT");
        lbNganhH = new JLabel("Nganh hoc");
        lbTongD = new JLabel("Tong diem");
        
        tfSBD = new JTextField();
        tfTen = new JTextField();
        tfGT = new JTextField();
        tfNganhH = new JTextField();
        tfTongD = new JTextField();
        
        panelInput.add(lbSBD);
        panelInput.add(tfSBD);
        panelInput.add(lbTen);
        panelInput.add(tfTen);
        panelInput.add(lbGT);
        panelInput.add(tfGT);
        panelInput.add(lbNganhH);
        panelInput.add(tfNganhH);
        panelInput.add(lbTongD);
        panelInput.add(tfTongD);
        
        
        //table
        Object[] obj = new Object[] {"SBD", "Ho ten", "Gioi tinh", "Nganh hoc", "Tong diem", "Hoc bong"};
        dftb = new DefaultTableModel(obj, 0);
        table = new JTable(dftb);
        JScrollPane scrollPane = new JScrollPane(table);
        
        
        //btn
        JPanel panelBtn = new JPanel(new GridLayout(1, 4, 5, 5));
        
        btnDelete = new JButton("Xoa");
        btnInsert = new JButton("Them");
        btnSearch = new JButton("Tim kiem");
        btnUpdate = new JButton("Cap nhat");
        
        panelBtn.add(btnDelete);
        panelBtn.add(btnInsert);
        panelBtn.add(btnSearch);
        panelBtn.add(btnUpdate);
        
        
        //add main
        add(panelInput, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBtn, BorderLayout.SOUTH);
        
        
        actionBtn();
        
        setVisible(true);
    }
    
    public void actionBtn(){
        
        resetDtb();
        
        btnDelete.addActionListener(e -> {
            int SoBD = Integer.parseInt(tfSBD.getText());
            if(xlts.deleteTS(SoBD)){
                JOptionPane.showMessageDialog(null, "delete success");
                resetDtb();
                resetTF();
            }
        });
        
        btnInsert.addActionListener(e -> {
            int SoBD = Integer.parseInt(tfSBD.getText());
            String Hoten = tfTen.getText();
            String GT = tfGT.getText();
            String NganhH = tfNganhH.getText();
            double TongD = Double.parseDouble(tfTongD.getText());
            if(xlts.insertTS(SoBD, Hoten, GT, NganhH, TongD)){
                JOptionPane.showMessageDialog(null, "insert success");
                resetDtb();
                resetTF();
            }
        });
        
        btnSearch.addActionListener(e -> {
            String NganhH = tfNganhH.getText();
            double TongD = Double.parseDouble(tfTongD.getText());
            ArrayList<Thisinh> listTS = new ArrayList<>();
            listTS = xlts.findTS(NganhH, TongD);
            if(listTS != null){
                dftb.setRowCount(0);
                for(Thisinh ts : listTS){
                    int SoBD = ts.getSoBD();
                    String HoTen = ts.getHoten();
                    String GT = ts.getGT();
                    String hocbong = ts.Hocbong(TongD);
                    dftb.addRow(new Object[] {SoBD, HoTen, GT, NganhH, TongD, hocbong});
                }
            }
        });
        
        btnUpdate.addActionListener(e -> {
            int SoBD = Integer.parseInt(tfSBD.getText());
            String Hoten = tfTen.getText();
            String GT = tfGT.getText();
            String NganhH = tfNganhH.getText();
            double TongD = Double.parseDouble(tfTongD.getText());
            if(xlts.updateTS(SoBD, Hoten, GT, NganhH, TongD)){
                JOptionPane.showMessageDialog(null, "update success");
                resetDtb();
            }
        });
        
        
    }
    
    public void resetTF(){
        tfGT.setText("");
        tfNganhH.setText("");
        tfSBD.setText("");
        tfTen.setText("");
        tfTongD.setText("");
    }
    
    public void resetDtb(){
        dftb.setRowCount(0);
        ArrayList<Thisinh> listTS = new ArrayList<>();
        listTS = xlts.getTS();
        if(listTS != null){
            for (Thisinh ts : listTS) {                
                int SoBD = ts.getSoBD();
                String HoTen = ts.getHoten();
                String GT = ts.getGT();
                String NganhH = ts.getNganhH();
                double TongD = ts.getTongD();
                String hocbong = ts.Hocbong(TongD);
                dftb.addRow(new Object[] {SoBD, HoTen, GT, NganhH, TongD, hocbong});
            }
        }
    }
    
    public static void main(String[] args) {
        new GuiThisinh();
    }
}
