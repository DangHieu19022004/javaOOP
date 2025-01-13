/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CKH;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class guiKH extends JFrame {
    XLKH xlkh = new XLKH();
    //componenet
    private JLabel lbSoTK, lbHoten, lbGT, lbDiachi, lbSodu;
    private JTextField txtSoTK, txtHoten, txtGT, txtDiachi, txtSodu;
    private JButton btnshow, btninsert, btnupdate, btndelete;
    private JTable table;
    private DefaultTableModel tableModel;
    
        
    public guiKH(){
    
        //jrame
        setLayout(new BorderLayout());
        setTitle("manage KH");
        setSize(700, 600);
        
        
        //input
        JPanel panelInput = new JPanel(new GridLayout(7, 2, 10, 10));
        
        lbSoTK = new JLabel("So tk");
        panelInput.add(lbSoTK);
        txtSoTK = new JTextField();
        panelInput.add(txtSoTK);
        
        lbHoten = new JLabel("Ho ten");
        panelInput.add(lbHoten);
        txtHoten = new JTextField();
        panelInput.add(txtHoten);
        
        lbGT = new JLabel("Gioi tinh");
        panelInput.add(lbGT);
        txtGT = new JTextField();
        panelInput.add(txtGT);
        
        lbDiachi = new JLabel("Dia chi");
        panelInput.add(lbDiachi);
        txtDiachi = new JTextField();
        panelInput.add(txtDiachi);
        
        lbSodu = new JLabel("So du");
        panelInput.add(lbSodu);
        txtSodu = new JTextField();
        panelInput.add(txtSodu);
        
        
        //table view
        String[] colName = {"SoTK", "Hoten", "GT", "Diachi", "Sodu"};
        tableModel = new DefaultTableModel(colName, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        
        
        //btn
        JPanel panelbtn = new JPanel(new GridLayout(1, 4, 5, 5));
        btnshow = new JButton("Show");
        btninsert = new JButton("Insert");
        btnupdate = new JButton("Update");
        btndelete = new JButton("Delete");
        panelbtn.add(btnshow);
        panelbtn.add(btninsert);
        panelbtn.add(btnupdate);
        panelbtn.add(btndelete);

        
        //add to frame
        add(panelInput, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelbtn, BorderLayout.SOUTH);
        
        actionAdd();
        
        setVisible(true);
    }
    
    public void actionAdd(){
        //show info
        try {
            List<Khachhang> listKH = xlkh.showKH();
            if(listKH != null){
                for(Khachhang kh : listKH){
                    Object[] row = {kh.getSoTK(), kh.getHoten(), kh.getGT(), kh.getDiachi(), kh.getSodu()};
                    tableModel.addRow(row);
                }
            }
        } catch (Exception e) {
            System.out.println("err " + e.getMessage());
        }
        
        
        //btn show
        btnshow.addActionListener(e -> {
            try {
            tableModel.setRowCount(0);
                List<Khachhang> listKH = xlkh.showKH();
                if(listKH != null){
                    for(Khachhang kh : listKH){
                        Object[] row = {kh.getSoTK(), kh.getHoten(), kh.getGT(), kh.getDiachi(), kh.getSodu()};
                        tableModel.addRow(row);
                    }
                }
            } catch (Exception ex) {
                System.out.println("err " + ex.getMessage());
            }
        });
        
        
        //insert
        btninsert.addActionListener(e -> {
            int SoTK = Integer.parseInt(txtSoTK.getText());
            String Hoten = txtHoten.getText();
            String GT = txtGT.getText();
            String Diachi = txtDiachi.getText();
            double Sodu = Double.parseDouble(txtSodu.getText());
            
            if(xlkh.insertKH(SoTK, Hoten, GT, Diachi, Sodu)){
                
                tableModel.addRow(new Object[] {SoTK, Hoten, GT, Diachi, Sodu});
                JOptionPane.showMessageDialog(null, "insert success");
            }
            else{
                JOptionPane.showMessageDialog(this, "insert errr");
            }
        });
        
        //update
        btnupdate.addActionListener(e -> {
            int SoTK = Integer.parseInt(txtSoTK.getText());
            String Hoten = txtHoten.getText();
            String GT = txtGT.getText();
            String Diachi = txtDiachi.getText();
            double Sodu = Double.parseDouble(txtSodu.getText());
            
            if(xlkh.updateKH(SoTK, Hoten, GT, Diachi, Sodu)){
                for(int i = 0; i < tableModel.getRowCount(); i++){
                    if((int)tableModel.getValueAt(i, 0) == SoTK){
                        tableModel.setValueAt(Hoten, i, 1);
                        tableModel.setValueAt(GT, i, 2);
                        tableModel.setValueAt(Diachi, i, 3);
                        tableModel.setValueAt(Sodu, i, 4);
                        JOptionPane.showMessageDialog(this, "update success");
                        break;
                    }
                }
            }
        });
        
        //delete
        btndelete.addActionListener(e -> {
            int SoTK = Integer.parseInt(txtSoTK.getText());
            boolean success = false;
            if(xlkh.deleteKH(SoTK)){
                for(int i = 0; i < tableModel.getRowCount(); i++){
                    if((int)tableModel.getValueAt(i, 0) == SoTK){
                        tableModel.removeRow(i);
                        success = true;
                    }
                }
            }
            if(success)JOptionPane.showMessageDialog(this, "delete success");
        });
        
    }
    
    public static void main(String[] args) {
        new guiKH();
    }
}
