/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GGV;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class GUIgiangVien extends JFrame implements ActionListener {

    private XLGV xldl = new XLGV();
    private int currentRow = -1;

    public GUIgiangVien() {
        setSize(920, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        //
        JLabel lbmdd = new JLabel("Mã định danh: ");
        lbmdd.setBounds(10, 10, 100, 30);
        JTextField tfmdd = new JTextField();
        tfmdd.setBounds(120, 10, 100, 30);

        JLabel lbht = new JLabel("Họ tên: ");
        lbht.setBounds(10, 50, 100, 30);
        JTextField tfht = new JTextField();
        tfht.setBounds(120, 50, 100, 30);

        JLabel lbgt = new JLabel("Giới tính: ");
        lbgt.setBounds(10, 90, 100, 30);
        JTextField tfgt = new JTextField();
        tfgt.setBounds(120, 90, 100, 30);

        JLabel lbdv = new JLabel("Đơn vị: ");
        lbdv.setBounds(10, 130, 100, 30);
        JTextField tfdv = new JTextField();
        tfdv.setBounds(120, 130, 100, 30);

        JLabel lbct = new JLabel("Số công trình: ");
        lbct.setBounds(10, 170, 100, 30);
        JTextField tfct = new JTextField();
        tfct.setBounds(120, 170, 100, 30);
        //button
        JButton btThem = new JButton("Thêm");
        btThem.setBounds(10, 210, 90, 20);

        JButton btSua = new JButton("Sửa");
        btSua.setBounds(110, 210, 90, 20);

        JButton btXoa = new JButton("Xóa");
        btXoa.setBounds(210, 210, 90, 20);

        JButton btSearch = new JButton("Tìm kiếm");
        btSearch.setBounds(310, 210, 90, 20);
        //table
        String columns[] = {"Mã định danh", "Họ tên", "Giới tính", "Đơn vị", "Số công trình"};
        //String data[][] = {};
        DefaultTableModel tabaModel = new DefaultTableModel();
        tabaModel.setColumnIdentifiers(columns);
//        DefaultTableModel tabaModel = new DefaultTableModel(data, columns) {
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return false;
//            }
//        };
        JTable tabel = new JTable(tabaModel);
        JScrollPane jsp = new JScrollPane(tabel);
        jsp.setBounds(410, 10, 490, 380);

        //add controls
        add(lbmdd);
        add(lbct);
        add(lbdv);
        add(lbgt);
        add(lbht);
        add(tfct);
        add(tfdv);
        add(tfgt);
        add(tfht);
        add(tfmdd);
        add(btSearch);
        add(btSua);
        add(btThem);
        add(btXoa);
        add(jsp);
        //
        xldl.getCon();
        loadData(tabaModel);
        //event
//        tabel.getSelectionModel().addListSelectionListener(e -> {// dùng biểu thức lamda để thay thế cho  new ListenSelectListener
//            try {
//                tfmdd.setText(tabel.getValueAt(tabel.getSelectedRow(), 0).toString());//kiểu text-> phải string
//                tfht.setText(tabel.getValueAt(tabel.getSelectedRow(), 1).toString());
//                tfgt.setText(tabel.getValueAt(tabel.getSelectedRow(), 2).toString());
//                tfdv.setText(tabel.getValueAt(tabel.getSelectedRow(), 3).toString());
//                tfct.setText(tabel.getValueAt(tabel.getSelectedRow(), 4).toString());
//                currentRow = tabel.getSelectedRow();
//            } catch (ArrayIndexOutOfBoundsException ex) {
//
//            }
//        });
//cbbox,jcombobox,radiobutton,menu
        tabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                currentRow = tabel.getSelectedRow();
                tfmdd.setText(tabel.getValueAt(currentRow, 0).toString());
                tfht.setText(tabel.getValueAt(currentRow, 1).toString());
                tfgt.setText(tabel.getValueAt(currentRow, 2).toString());
                tfdv.setText(tabel.getValueAt(currentRow, 3).toString());
                tfct.setText(tabel.getValueAt(currentRow, 4).toString());
            }
        });
        btThem.addActionListener(this);
//        btThem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String mdd = tfmdd.getText().trim();
//                String ht = tfht.getText().trim();
//                String dv = tfdv.getText().trim();
//                String gt = tfgt.getText().trim();
//                int soCT = 0;
//                boolean isVaild = true;
//                try {
//                    soCT = Integer.parseInt(tfct.getText().trim());
//
//                } catch (NumberFormatException ex) {
//            
//                    JOptionPane.showMessageDialog(null, "Nhập số công trình không hợp lệ");
//                    isVaild = false;
//                }
//                if (mdd.isEmpty() || ht.isEmpty() || dv.isEmpty() || gt.isEmpty() || !isVaild) {
//                    JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin hợp lệ");
//                } else {
//
//                    boolean res = xldl.insertData(new Giangvien(dv, soCT, mdd, ht, gt));//chú ý ghi đúng hàm khởi tạo != theo thứ tự trong sql
//                    if (res) {
//                        loadData(tabaModel);
//                        //tabaModel.addRow(new String[]{dv,soCT+"",mdd,ht,gt} );
//                        JOptionPane.showMessageDialog(null, "Thêm thành công");
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Thêm thất bại");
//                    }
//                }
//            }
//
//        }
//        );
        btSua.addActionListener(this);
//        btSua.addActionListener(e -> {
//            String mdd = tfmdd.getText().trim();
//            String ht = tfht.getText().trim();
//            String dv = tfdv.getText().trim();
//            String gt = tfgt.getText().trim();
//            int soCT = 0;
//            boolean isVaild = true;
//            ResultSet res = xldl.getDataByMa(mdd);
//            try {
//                if (res != null && res.next()) {
//                    try {
//                        soCT = Integer.parseInt(tfct.getText().trim());
//
//                    } catch (NumberFormatException ex) {
//                        JOptionPane.showMessageDialog(this, "Nhập số công trình không hợp lệ");
//                        isVaild = false;
//                    }
//                    if (mdd.isEmpty() || ht.isEmpty() || dv.isEmpty() || gt.isEmpty() || !isVaild) {
//                        JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin hợp lệ");
//                    } else {
//
//                        boolean rs = xldl.updateData(mdd, new Giangvien(dv, soCT, mdd, ht, gt));
//                        if (rs) {
//                            loadData(tabaModel);
//                            //getValuedAt
//                            JOptionPane.showMessageDialog(this, "Sửa thành công");
//                        } else {
//                            JOptionPane.showMessageDialog(this, "Sửa thất bại");
//                        }
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(this, "Không tồn tại mã định danh: " + mdd);
//                }
//            } catch (SQLException ex) {
//
//            }
//
//        });
        btXoa.addActionListener(e -> {
            if (currentRow >= 0 && currentRow < tabel.getRowCount()) {
                String madd = tabel.getValueAt(currentRow, 0).toString();
                boolean rs = xldl.deleteData(madd);
                if (rs) {
                    loadData(tabaModel);
                    //tabaModel.removeRow(ERROR);
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại ");

                }
            }
        });
        btSearch.addActionListener(e -> {
            try {
                tabaModel.setRowCount(0);
                tabaModel.fireTableDataChanged();
                String mdd = tfmdd.getText().trim();
                ResultSet res;
                if (mdd == "") {
                    res = xldl.getAllData();

                } else {
                    res = xldl.getDataByMa(mdd);

                }
                if (res != null) {
                    while (res.next()) {
                        tabaModel.addRow(new String[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5) + ""});
                    }
                }
            } catch (SQLException ex) {
                System.out.println("Error load data: " + ex.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        new GUIgiangVien().setVisible(true);
    }

    private void loadData(DefaultTableModel tableModel) {
        try {
            tableModel.setRowCount(0);
            tableModel.fireTableDataChanged();

            ResultSet res = xldl.getAllData();
            if (res != null) {
                while (res.next()) {
                    tableModel.addRow(new String[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5) + ""});
                }
            }
        } catch (SQLException e) {
            System.out.println("Error load data: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //JOptionPane.showMessageDialog(null, "Hello");//null: ko goi cua thang cha
        Object obj = e.getSource();//tra ve nguon su kien=> kiểu object
        if (obj instanceof JButton) {//neu object la button
            JButton jbtn = (JButton) obj;

            if (jbtn.getText() == "Thêm") {
                JOptionPane.showMessageDialog(null, "Hello");//null: ko goi cua thang cha
            } else if (jbtn.getText() == "Sửa") {
                JOptionPane.showMessageDialog(null, "Không Hello");//null: ko goi cua thang cha

            }
        }
    }
}
