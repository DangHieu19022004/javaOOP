/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GSach;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class GuiSach extends JFrame {
    
    private XLSach xls = new XLSach();
    private JLabel lbMaS, lbTenS, lbNhaXB, lbNamXB, lbGiaB;
    private JTextField tfMaS, tfTenS, tfNhaXB, tfNamXB, tfGiaB;
    private JButton btnC, btnR, btnU, btnD;
    private JTable table;
    private DefaultTableModel dftable;
    
    public GuiSach(){
        
        //setlayout
        setLayout(new BorderLayout());
        setTitle("QL Sach");
        setSize(600, 700);
        
        //set panel input
        JPanel panelInput = new JPanel(new GridLayout(6, 2, 5, 10));
        
        lbMaS = new JLabel("Ma sach");
        tfMaS = new JTextField();
        
        lbTenS = new JLabel("Ten Sach");
        tfTenS = new JTextField();
        
        lbNhaXB = new JLabel("Nha xuat ban");
        tfNhaXB = new JTextField();
        
        lbNamXB = new JLabel("Nam xuat ban");
        tfNamXB = new JTextField();
        
        lbGiaB = new JLabel("Gia ban");
        tfGiaB = new JTextField();
        
        panelInput.add(lbMaS);  panelInput.add(tfMaS);
        panelInput.add(lbTenS);  panelInput.add(tfTenS);
        panelInput.add(lbNhaXB);  panelInput.add(tfNhaXB);
        panelInput.add(lbNamXB);  panelInput.add(tfNamXB);
        panelInput.add(lbGiaB);  panelInput.add(tfGiaB);
        
        
        //table
        Object[] colName = {"Ma sach", "Ten sach", "Nha xuat ban", "Nam xuat ban", "Gia ban"};
        dftable = new DefaultTableModel(colName, 0);
        table = new JTable(dftable);
        JScrollPane scrollPane = new JScrollPane(table);
        
        
        //btn
        JPanel panelBtn = new JPanel(new GridLayout(1, 4, 5, 5));
        
        btnC = new JButton("Create");
        btnR = new JButton("Read");
        btnU = new JButton("Update");
        btnD = new JButton("Delete");
        
        panelBtn.add(btnC);
        panelBtn.add(btnR);
        panelBtn.add(btnU);
        panelBtn.add(btnD);
        
        
        //add view main
        add(panelInput, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBtn, BorderLayout.SOUTH);
        
        
        addAcrionBtn();
        
        setVisible(true);
    }
    
    public void addAcrionBtn(){
        resetDtb();
        
        btnC.addActionListener(e -> {
            int MaS = Integer.parseInt(tfMaS.getText());
            String TenS = tfTenS.getText();
            String NhaXB = tfNhaXB.getText();
            int NamXb = Integer.parseInt(tfNamXB.getText());
            double GiaB = Double.parseDouble(tfGiaB.getText());
            if(xls.createSach(MaS, TenS, NhaXB, NamXb, GiaB)){
                resetTF();
                resetDtb();
                JOptionPane.showMessageDialog(null, "Add success");
            }
        });
        btnR.addActionListener(e -> {
            dftable.setRowCount(0);
            int NamXb = Integer.parseInt(tfNamXB.getText());
            double GiaB = Double.parseDouble(tfGiaB.getText());
            ArrayList<Sach> listSach = new ArrayList<>();
            listSach = xls.getSAbyNXBGB(NamXb, GiaB);
            if(listSach != null){
                for(Sach s : listSach){
                    dftable.addRow(new Object[] {s.getMaS(), s.getTenS(), s.getNhaXB(), s.getNamXB(), s.getGiaB()});
                }
            }
        });
        btnU.addActionListener(e -> {
            int MaS = Integer.parseInt(tfMaS.getText());
            String TenS = tfTenS.getText();
            String NhaXB = tfNhaXB.getText();
            int NamXb = Integer.parseInt(tfNamXB.getText());
            double GiaB = Double.parseDouble(tfGiaB.getText());
            if(xls.updateSach(MaS, TenS, NhaXB, NamXb, GiaB)){
                resetTF();
                resetDtb();
                JOptionPane.showMessageDialog(null, "Update success");
            }
        });
        btnD.addActionListener(e -> {
            int MaDD = Integer.parseInt(tfMaS.getText());
            if(xls.deleteSach(MaDD)){
                resetDtb();
                resetTF();
                JOptionPane.showMessageDialog(null, "Delete success");
            }
        });
    }    
    
    public void resetTF(){
        tfMaS.setText("");
        tfTenS.setText("");
        tfNhaXB.setText("");
        tfNamXB.setText("");
        tfGiaB.setText("");
    }
    
    public void resetDtb(){
        dftable.setRowCount(0);
        ArrayList<Sach> listSach = new ArrayList<>();
        listSach = xls.getSA();
        if(listSach != null){
            for(Sach s : listSach){
                dftable.addRow(new Object[] {s.getMaS(), s.getTenS(), s.getNhaXB(), s.getNamXB(), s.getGiaB()});
                
            }
        }
    }
    
    public static void main(String[] args) {
        new GuiSach();
    }
}
