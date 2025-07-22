package com.example.apptaphoa.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.example.apptaphoa.controller.NhanVienController;
import com.example.apptaphoa.model.NhanVien;
import com.example.apptaphoa.utils.AuthUtil;

import java.util.List;

import java.awt.*;
import java.awt.event.*;

public class NhanVienFrame extends JFrame {
    public JTable tblNhanVien;
    public DefaultTableModel tableModel;
    public JTextField txtMaNV, txtHoTen, txtTenDangNhap, txtMatKhau, txtEmail;
    public JComboBox<String> cboGioiTinh, cboVaiTro;
    public JButton btnThem, btnSua, btnXoa, btnMoi;
    
    NhanVienController controller =new NhanVienController();

    public NhanVienFrame() {
        setTitle("Quản lý nhân viên");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        // === HEADER ===
        JPanel header = new JPanel();
        header.setLayout(null);
        header.setBackground(new Color(30, 41, 59));
        header.setBounds(0, 0, 1000, 68);
        JLabel lblTitle = new JLabel("QUẢN LÝ NHÂN VIÊN");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 27));
        lblTitle.setForeground(new Color(37, 99, 235));
        lblTitle.setBounds(30, 15, 420, 38);
        header.add(lblTitle);
        getContentPane().add(header);

        // === TABLE DANH SÁCH NHÂN VIÊN ===
        JPanel panelTable = new JPanel(null);
        panelTable.setBackground(new Color(245, 249, 255));
        panelTable.setBounds(20, 78, 950, 240);
        panelTable.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 225, 230), 1, true),
                BorderFactory.createEmptyBorder(10, 12, 10, 12)
        ));

        String[] headerTbl = {"Mã NV", "Họ tên", "Tài khoản", "Mật khẩu", "Email", "Giới tính", "Vai trò"};
        tableModel = new DefaultTableModel(headerTbl, 0);
        tblNhanVien = new JTable(tableModel);
        tblNhanVien.setRowHeight(30);
        tblNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tblNhanVien.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tblNhanVien.setShowGrid(true);
        tblNhanVien.setGridColor(new Color(230, 230, 230));
        tblNhanVien.setSelectionBackground(new Color(232, 240, 254));
        tblNhanVien.setSelectionForeground(new Color(37, 99, 235));
        tblNhanVien.putClientProperty("FlatLaf.styleClass", "table striped");
        JScrollPane scrollPane = new JScrollPane(tblNhanVien);
        scrollPane.setBounds(0, 0, 950, 240);
        panelTable.add(scrollPane);
        getContentPane().add(panelTable);
        tblNhanVien.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = tblNhanVien.getSelectedRow();
                if (row >= 0) {
                    NhanVien nv = new NhanVien();
                    nv.setMaNV(tableModel.getValueAt(row, 0).toString());
                    nv.setHoTen(tableModel.getValueAt(row, 1).toString());
                    nv.setTenDangNhap(tableModel.getValueAt(row, 2).toString());
                    nv.setMatKhau(tableModel.getValueAt(row, 3).toString());
                    nv.setEmail(tableModel.getValueAt(row, 4).toString());
                    nv.setGioiTinh(tableModel.getValueAt(row, 5).toString());
                    nv.setVaiTro(tableModel.getValueAt(row, 6).toString());
                    setForm(nv);
                }
            }
        });

        // === FORM PANEL ===
        JPanel formPanel = new JPanel(null);
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 225, 230), 1, true),
                BorderFactory.createEmptyBorder(22, 28, 20, 28)
        ));
        formPanel.setBounds(20, 335, 950, 180);

        // Mã NV
        JLabel lblMaNV = new JLabel("Mã NV");
        lblMaNV.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblMaNV.setForeground(new Color(30, 64, 175));
        lblMaNV.setBounds(18, 10, 80, 26);
        formPanel.add(lblMaNV);
        txtMaNV = new JTextField();
        txtMaNV.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtMaNV.setBounds(18, 38, 110, 36);
        formPanel.add(txtMaNV);

        // Họ tên
        JLabel lblHoTen = new JLabel("Họ tên");
        lblHoTen.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblHoTen.setForeground(new Color(30, 64, 175));
        lblHoTen.setBounds(152, 10, 80, 26);
        formPanel.add(lblHoTen);
        txtHoTen = new JTextField();
        txtHoTen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtHoTen.setBounds(152, 38, 180, 36);
        formPanel.add(txtHoTen);

        // Tài khoản
        JLabel lblTenDN = new JLabel("Tài khoản");
        lblTenDN.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblTenDN.setForeground(new Color(30, 64, 175));
        lblTenDN.setBounds(356, 10, 80, 26);
        formPanel.add(lblTenDN);
        txtTenDangNhap = new JTextField();
        txtTenDangNhap.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtTenDangNhap.setBounds(356, 38, 150, 36);
        formPanel.add(txtTenDangNhap);

        // Mật khẩu
        JLabel lblMatKhau = new JLabel("Mật khẩu");
        lblMatKhau.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblMatKhau.setForeground(new Color(30, 64, 175));
        lblMatKhau.setBounds(530, 10, 80, 26);
        formPanel.add(lblMatKhau);
        txtMatKhau = new JTextField();
        txtMatKhau.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtMatKhau.setBounds(530, 38, 120, 36);
        formPanel.add(txtMatKhau);

        // Giới tính
        JLabel lblGioiTinh = new JLabel("Giới tính");
        lblGioiTinh.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblGioiTinh.setForeground(new Color(30, 64, 175));
        lblGioiTinh.setBounds(678, 10, 80, 26);
        formPanel.add(lblGioiTinh);
        cboGioiTinh = new JComboBox<>(new String[]{"Nam", "Nữ", "Khác"});
        cboGioiTinh.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        cboGioiTinh.setBounds(678, 38, 120, 36);
        cboGioiTinh.setBackground(Color.WHITE);
        formPanel.add(cboGioiTinh);

        // Email
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblEmail.setForeground(new Color(30, 64, 175));
        lblEmail.setBounds(818, 10, 80, 26);
        formPanel.add(lblEmail);
        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtEmail.setBounds(818, 38, 110, 36);
        formPanel.add(txtEmail);

        // Vai trò
        JLabel lblVaiTro = new JLabel("Vai trò");
        lblVaiTro.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblVaiTro.setForeground(new Color(30, 64, 175));
        lblVaiTro.setBounds(18, 90, 80, 26);
        formPanel.add(lblVaiTro);
        cboVaiTro = new JComboBox<>(new String[] {"Quản lý", "Nhân viên"});
        cboVaiTro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        cboVaiTro.setBounds(18, 120, 180, 36);
        cboVaiTro.setBackground(Color.WHITE);
        formPanel.add(cboVaiTro);

        btnThem = new JButton("Thêm");
        btnThem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		NhanVien nv = getForm();
                if (nv.getMaNV().isEmpty() || nv.getHoTen().isEmpty()) {
                    JOptionPane.showMessageDialog(NhanVienFrame.this, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                boolean ok = controller.addNhanVien(nv);
                if (ok) {
                    JOptionPane.showMessageDialog(NhanVienFrame.this, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    loadTable();
                    clearForm();
                } else {
                    JOptionPane.showMessageDialog(NhanVienFrame.this, "Thêm thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
        	}
        });
        btnThem.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnThem.setBounds(370, 120, 110, 36);
        btnThem.setBackground(new Color(34, 197, 94));
        btnThem.setForeground(Color.WHITE);
        formPanel.add(btnThem);

        btnSua = new JButton("Sửa");
        btnSua.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		NhanVien nv = getForm();
                if (nv.getMaNV().isEmpty()) {
                    JOptionPane.showMessageDialog(NhanVienFrame.this, "Vui lòng chọn nhân viên để sửa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                boolean ok = controller.updateNhanVien(nv);
                if (ok) {
                    JOptionPane.showMessageDialog(NhanVienFrame.this, "Cập nhật thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    loadTable();
                } else {
                    JOptionPane.showMessageDialog(NhanVienFrame.this, "Cập nhật thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
        	}
        });
        btnSua.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnSua.setBounds(495, 120, 110, 36);
        btnSua.setBackground(new Color(37, 99, 235));
        btnSua.setForeground(Color.WHITE);
        formPanel.add(btnSua);
        
        btnXoa = new JButton("Xóa");
        btnXoa.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String maNV = txtMaNV.getText().trim();
        		if(maNV.equals(AuthUtil.getUser().getMaNV())) {
                    JOptionPane.showMessageDialog(NhanVienFrame.this, "Bạn không thể xóa tài khoản đang đăng nhập!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (maNV.isEmpty()) {
                    JOptionPane.showMessageDialog(NhanVienFrame.this, "Vui lòng chọn nhân viên để xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                int confirm = JOptionPane.showConfirmDialog(NhanVienFrame.this, "Xóa nhân viên này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    boolean ok = controller.deleteNhanVien(maNV);
                    if (ok) {
                        JOptionPane.showMessageDialog(NhanVienFrame.this, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        loadTable();
                        clearForm();
                    } else {
                        JOptionPane.showMessageDialog(NhanVienFrame.this, "Xóa thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                }
        	}
        });
        btnXoa.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnXoa.setBounds(620, 120, 110, 36);
        btnXoa.setBackground(new Color(224, 27, 36));
        btnXoa.setForeground(Color.WHITE);
        formPanel.add(btnXoa);

        btnMoi = new JButton("Mới");
        btnMoi.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		clearForm();
        	}
        });
        btnMoi.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnMoi.setBounds(745, 120, 110, 36);
        btnMoi.setBackground(new Color(120, 120, 120));
        btnMoi.setForeground(Color.WHITE);
        formPanel.add(btnMoi);

        getContentPane().add(formPanel);
        loadTable();
    }
    
    private void loadTable() {
        tableModel.setRowCount(0); // clear
        List<NhanVien> list = controller.getAllNhanVien();
        for (NhanVien nv : list) {
            tableModel.addRow(new Object[]{
                    nv.getMaNV(), nv.getHoTen(), nv.getTenDangNhap(),
                    nv.getMatKhau(), nv.getEmail(),
                    nv.getGioiTinh(), nv.getVaiTro()
            });
        }
    }
    
    private void setForm(NhanVien nv) {
        txtMaNV.setText(nv.getMaNV());
        txtHoTen.setText(nv.getHoTen());
        txtTenDangNhap.setText(nv.getTenDangNhap());
        txtMatKhau.setText(nv.getMatKhau());
        txtEmail.setText(nv.getEmail());
        cboGioiTinh.setSelectedItem(nv.getGioiTinh());
        cboVaiTro.setSelectedItem(nv.getVaiTro());
    }

    private void clearForm() {
        txtMaNV.setText("");
        txtHoTen.setText("");
        txtTenDangNhap.setText("");
        txtMatKhau.setText("");
        txtEmail.setText("");
        cboGioiTinh.setSelectedIndex(0);
        cboVaiTro.setSelectedIndex(0);
    }

    private NhanVien getForm() {
        NhanVien nv = new NhanVien();
        nv.setMaNV(txtMaNV.getText().trim());
        nv.setHoTen(txtHoTen.getText().trim());
        nv.setTenDangNhap(txtTenDangNhap.getText().trim());
        nv.setMatKhau(txtMatKhau.getText());
        nv.setEmail(txtEmail.getText().trim());
        nv.setGioiTinh((String) cboGioiTinh.getSelectedItem());
        nv.setVaiTro((String) cboVaiTro.getSelectedItem());
        return nv;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NhanVienFrame().setVisible(true));
    }
}
