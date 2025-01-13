package GGV;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class GuiGV extends JFrame {
    
    private XLGV xlgv = new XLGV();
    
    private JLabel lbMaDD, lbHoten, lbGT, lbDonvi, lbSoct;
    private JTextField tfMaDD, tfHoten, tfGT, tfDonvi, tfSoct;
    private JButton btnC, btnR, btnU, btnD;
    private JTable table;
    private DefaultTableModel dftable;
    
    
    public GuiGV(){
        
        setLayout(new BorderLayout());
        setTitle("QLGV");
        setSize(600, 700);
        
        
        JPanel panelInput = new JPanel(new GridLayout(6, 2, 5, 10));
        
        lbMaDD = new JLabel("Ma DD");
        panelInput.add(lbMaDD);
        tfMaDD = new JTextField();
        panelInput.add(tfMaDD);
        
        lbHoten = new JLabel("Ho ten");
        panelInput.add(lbHoten);
        tfHoten = new JTextField();
        panelInput.add(tfHoten);
        
        lbGT = new JLabel("Gioi tinh");
        panelInput.add(lbGT);
        tfGT = new JTextField();
        panelInput.add(tfGT);
        
        lbDonvi = new JLabel("Don vi");
        panelInput.add(lbDonvi);
        tfDonvi = new JTextField();
        panelInput.add(tfDonvi);
        
        lbSoct = new JLabel("So cong trinh");
        panelInput.add(lbSoct);
        tfSoct = new JTextField();
        panelInput.add(tfSoct);
        
        
        String[] tableName = {"Ma DD", "Ho ten", "Gioi tinh", "Don vi", "So cong trinh"};
        dftable = new DefaultTableModel(tableName, 0);
        table = new JTable(dftable);
        JScrollPane scroll = new JScrollPane(table);
        
        
        JPanel panelBtn = new JPanel(new GridLayout(1, 4, 5, 5));
        
        btnC = new JButton("Create");
        panelBtn.add(btnC);
        btnR = new JButton("Read");
        panelBtn.add(btnR);
        btnU = new JButton("Update");
        panelBtn.add(btnU);
        btnD = new JButton("Delete");
        panelBtn.add(btnD);
        
        add(panelInput, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(panelBtn, BorderLayout.SOUTH);
        
        
        addEvent();
        
        setVisible(true);
    }
    
    public void addEvent(){
        
        btnC.addActionListener(e -> {
            int MaDD = Integer.parseInt(tfMaDD.getText());
            String Hoten = tfHoten.getText();
            String GT = tfGT.getText();
            String Donvi = tfDonvi.getText();
            int Soct = Integer.parseInt(tfSoct.getText());
            
            if(xlgv.insertGV(MaDD, Hoten, GT, Donvi, Soct)){
                dftable.addRow(new Object[] {MaDD, Hoten, GT, Donvi, Soct});
                resetTF();
                JOptionPane.showMessageDialog(null, "add success");
            }else{
                JOptionPane.showMessageDialog(null, "add false");
            }
        });
        
        btnR.addActionListener(e -> {
            getAllGV();
        });
        
        btnU.addActionListener(e -> {
            int MaDD = Integer.parseInt(tfMaDD.getText());
            String Hoten = tfHoten.getText();
            String GT = tfGT.getText();
            String Donvi = tfDonvi.getText();
            int Soct = Integer.parseInt(tfSoct.getText());
            
            if(xlgv.upDateGV(MaDD, Hoten, GT, Donvi, Soct)){
               getAllGV();
               JOptionPane.showMessageDialog(null, "Update success");
               resetTF();
            }
        });
        
        btnD.addActionListener(e -> {
            int MaDD = Integer.parseInt(tfMaDD.getText());
            
            if(xlgv.deleteGV(MaDD)){
                getAllGV();
                resetTF();
                JOptionPane.showMessageDialog(null, "delete success");
            }
        });
    }
    
    public void resetTF(){
        tfMaDD.setText("");
        tfHoten.setText("");
        tfGT.setText("");
        tfDonvi.setText("");
        tfSoct.setText("");
    }
    
    public void getAllGV(){
        ArrayList<Giangvien> listgv = new ArrayList<>();
                listgv = xlgv.getGV();
                if(listgv != null){
                    dftable.setRowCount(0);
                    for(Giangvien gv : listgv){
                        dftable.addRow(new Object[] {gv.getMaDD(), gv.getHoten(), gv.getGT(), gv.getDonvi(), gv.getSoct()});
                    }
                }
    }
    
    public static void main(String[] args) {
        new GuiGV();
    }
}
