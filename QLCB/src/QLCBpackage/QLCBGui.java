
package QLCBpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.table.*;


public class QLCBGui extends JFrame {
    private QLCB qlcb = new QLCB();
    
    //components
    private JTextField txtSoTK, txtHoten, txtGT, txtDiachi, txtLuong;
    private JButton btnView, btnCreate, btnUpdate, btnDelete;
    private JTable table;
    private DefaultTableModel tableModel;
    
    public QLCBGui(){
        
        //setup frame
        setTitle("Manage CB");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //Panel form input
        JPanel panelForm = new JPanel(new GridLayout(6, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        
        //add component to panelForm
        panelForm.add(new JLabel("SoTK: "));
        txtSoTK = new JTextField();
        panelForm.add(txtSoTK);
        
        panelForm.add(new JLabel("Hoten: "));
        txtHoten = new JTextField();
        panelForm.add(txtHoten);
        
        panelForm.add(new JLabel("GT: "));
        txtGT = new JTextField();
        panelForm.add(txtGT);
        
        panelForm.add(new JLabel("Diachi: "));
        txtDiachi = new JTextField();
        panelForm.add(txtDiachi);
        
        panelForm.add(new JLabel("Luong: "));
        txtLuong = new JTextField();
        panelForm.add(txtLuong);
        
        
        //text area for display data
        String[] columnNames = {"SoTK", "Hoten", "GT", "Diachi", "Luong"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        
        
        //button
        btnView = new JButton("Show");
        btnCreate = new JButton("Create");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        
        JPanel panelBtns = new JPanel(new GridLayout(1, 4, 10, 10));
        panelBtns.add(btnView);
        panelBtns.add(btnCreate);
        panelBtns.add(btnUpdate);
        panelBtns.add(btnDelete);

        
        add(panelBtns, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelForm, BorderLayout.NORTH);
        
        addBtnActions();
        
        setVisible(true);
    }
    
    private void addBtnActions(){
        //render
        try {
                List<Canbo> listCB = Test_insertCB.doGetCB(qlcb);
                tableModel.setRowCount(0);
                if (listCB != null && !listCB.isEmpty()) {
                    for (Canbo cb : listCB) {
                        Object[] row = {
                            cb.getSoTK(), 
                            cb.getHoten(), 
                            cb.getGT(), 
                            cb.getDiachi(), 
                            cb.getLuong()
                        };
                        tableModel.addRow(row);
                    }
                } else {
                    tableModel.addRow(new Object[] {"No data", "", "", "", ""});
                }
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        //view
        btnView.addActionListener(e -> {
            try {
                List<Canbo> listCB = Test_insertCB.doGetCB(qlcb);
                tableModel.setRowCount(0);
                if (listCB != null && !listCB.isEmpty()) {
                    for (Canbo cb : listCB) {
                        Object[] row = {
                            cb.getSoTK(), 
                            cb.getHoten(), 
                            cb.getGT(), 
                            cb.getDiachi(), 
                            cb.getLuong()
                        };
                        tableModel.addRow(row);
                    }
                } else {
                    tableModel.addRow(new Object[] {"No data", "", "", "", ""});
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
        
        //create
        btnCreate.addActionListener(e -> {
            try {
                int SoTK = Integer.parseInt(txtSoTK.getText());
                String Hoten = txtHoten.getText();
                String GT = txtGT.getText();
                String Diachi = txtDiachi.getText();
                double Luong = Double.parseDouble(txtLuong.getText());
                
                qlcb.insertCB(SoTK, Hoten, GT, Diachi, Luong);
                tableModel.addRow(new Object[] {SoTK, Hoten, GT, Diachi, Luong});
                JOptionPane.showMessageDialog(this, "add success");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
        
        //update
        btnUpdate.addActionListener(e -> {
            try {
                int SoTK = Integer.parseInt(txtSoTK.getText());
                String Hoten = txtHoten.getText();
                String GT = txtGT.getText();
                String Diachi = txtDiachi.getText();
                double Luong = Double.parseDouble(txtLuong.getText());
                
                qlcb.updateCB(SoTK, Hoten, GT, Diachi, Luong);
                
                JOptionPane.showMessageDialog(this, "update success");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
        
        //delete
        btnDelete.addActionListener(e -> {
            try {
                int SoTK = Integer.parseInt(txtSoTK.getText());
                
                qlcb.deleteCB(SoTK);
                JOptionPane.showMessageDialog(this, "delete success");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
    }
    
    public static void main(String[] args) {
        new QLCBGui();
    }
}
