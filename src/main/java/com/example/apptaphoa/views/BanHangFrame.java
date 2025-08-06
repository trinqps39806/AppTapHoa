package com.example.apptaphoa.views;

import com.example.apptaphoa.dao.SanPhamDAO;
import com.example.apptaphoa.model.SanPham;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class BanHangFrame extends JFrame {
    private JPanel contentPane;
    private JTable tblSanPham;
    private SanPhamDAO sanPhamDAO = new SanPhamDAO();

    public BanHangFrame() {
        setTitle("Chọn sản phẩm");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.BLACK));
        panel.setBounds(0, 0, 900, 70);
        panel.setLayout(null);
        contentPane.add(panel);

        JLabel lblFilter = new JLabel("Lọc loại sản phẩm:");
        lblFilter.setFont(new Font("Dialog", Font.BOLD, 15));
        lblFilter.setBounds(20, 20, 150, 30);
        panel.add(lblFilter);

        JComboBox<String> cboLoaiSanPham = new JComboBox<>();
        cboLoaiSanPham.setBounds(180, 20, 180, 30);
        panel.add(cboLoaiSanPham);

        // Lấy loại sản phẩm cho combobox
        cboLoaiSanPham.addItem("Tất cả");
        List<String> loaiList = sanPhamDAO.getAllLoaiSanPham();
        for (String loai : loaiList) cboLoaiSanPham.addItem(loai);

        JPanel tablePanel = new JPanel();
        tablePanel.setBorder(new LineBorder(Color.BLACK));
        tablePanel.setBounds(0, 70, 900, 400);
        tablePanel.setLayout(null);
        contentPane.add(tablePanel);

        DefaultTableModel model = new DefaultTableModel(
            new Object[][] {},
            new String[] {"Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng tồn", "Loại sản phẩm"}
        ) {
            public boolean isCellEditable(int r, int c) { return false; }
        };

        tblSanPham = new JTable(model);
        tblSanPham.setFont(new Font("Dialog", Font.PLAIN, 15));
        JScrollPane scrollPane = new JScrollPane(tblSanPham);
        scrollPane.setBounds(0, 0, 900, 400);
        tablePanel.add(scrollPane);

        fillTable(sanPhamDAO.getAllSanPham());

        cboLoaiSanPham.addActionListener(e -> {
            String loai = cboLoaiSanPham.getSelectedItem().toString();
            if ("Tất cả".equals(loai)) fillTable(sanPhamDAO.getAllSanPham());
            else fillTable(sanPhamDAO.getSanPhamByLoai(loai));
        });

        // Sự kiện thêm vào giỏ khi click dòng
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tblSanPham.getSelectedRow();
                if (row >= 0) {
                    String maSP = tblSanPham.getValueAt(row, 0).toString();
                    String tenSP = tblSanPham.getValueAt(row, 1).toString();
                    double donGia = Double.parseDouble(tblSanPham.getValueAt(row, 2).toString());
                    int soLuong = 1;
                    double thanhTien = donGia * soLuong;

                    // Kiểm tra đã tồn tại trong giỏ chưa
                    boolean found = false;
                    for (int i = 0; i < HomeFrame.cartModel.getRowCount(); i++) {
                        String maSPTrongCart = HomeFrame.cartModel.getValueAt(i, 0).toString();
                        if (maSP.equals(maSPTrongCart)) {
                            int oldSL = Integer.parseInt(HomeFrame.cartModel.getValueAt(i, 3).toString());
                            int newSL = oldSL + soLuong;
                            HomeFrame.cartModel.setValueAt(newSL, i, 3);
                            HomeFrame.cartModel.setValueAt(donGia * newSL, i, 4);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        HomeFrame.cartModel.addRow(new Object[] {
                            maSP, tenSP, donGia, soLuong, thanhTien
                        });
                    }
                }
            }
        });
    }

    private void fillTable(List<SanPham> list) {
        DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (SanPham sp : list) {
            model.addRow(new Object[] {
                sp.getMaSanPham(), sp.getTenSanPham(), sp.getDonGia(),
                sp.getSoLuongTonKho(), sp.getLoaiSanPham()
            });
        }
    }
}
