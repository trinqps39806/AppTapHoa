package com.example.apptaphoa.views;

import com.example.apptaphoa.controller.HomeController;
import com.example.apptaphoa.dao.ChiTietHoaDonDAO;
import com.example.apptaphoa.dao.HoaDonDAO;
import com.example.apptaphoa.dao.SanPhamDAO;
import com.example.apptaphoa.model.ChiTietHoaDon;
import com.example.apptaphoa.model.HoaDon;
import com.example.apptaphoa.utils.AuthUtil;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class HomeFrame extends JFrame {
    private JButton btnLichSu, btnNhapHang, btnThanhToan, btnBanHang, 
    btnSanPham, btnNhaCungCap,btnHoaDon, btnNhanVien, btnDoanhThu, btnDuNo ;
    private JLabel lblHoTen, lblDoanhThu, lblSoDon, lblSanPhamTon, lblTongTien, lblTongSanPham;
    JComboBox cboThanhToan;
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();
    private ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();

    HomeController homeController = new HomeController();

    private JPanel statBox1;
    private JPanel statBox2;
    private JPanel statBox3;

    private JTable tblCart;
    private DefaultTableModel cartModel;

    public HomeFrame() {
        setTitle("Quản lý tạp hóa - Trang chủ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 890);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // ==== SIDEBAR ====
        JPanel sideBar = new JPanel();
        sideBar.setLayout(null);
        sideBar.setBackground(new Color(30, 41, 59));
        sideBar.setBounds(0, 0, 210, 900);

        JLabel lblApp = new JLabel("QUẢN LÝ TẠP HÓA");
        lblApp.setHorizontalAlignment(SwingConstants.CENTER);
        lblApp.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblApp.setForeground(Color.white);
        lblApp.setBounds(1, 28, 209, 32);

        btnLichSu = new JButton("Lịch sử");
        btnLichSu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnLichSu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        btnLichSu.setBackground(new Color(51, 65, 85));
        btnLichSu.setForeground(Color.white);
        btnLichSu.setFocusPainted(false);
        btnLichSu.setBorder(BorderFactory.createEmptyBorder(7, 16, 7, 16));
        btnLichSu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLichSu.setHorizontalAlignment(SwingConstants.LEFT);
        btnLichSu.setBounds(35, 255, 140, 38);

        btnNhapHang = new JButton("Nhập hàng");
        btnNhapHang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnNhapHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        btnNhapHang.setBackground(new Color(51, 65, 85));
        btnNhapHang.setForeground(Color.white);
        btnNhapHang.setFocusPainted(false);
        btnNhapHang.setBorder(BorderFactory.createEmptyBorder(7, 16, 7, 16));
        btnNhapHang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNhapHang.setHorizontalAlignment(SwingConstants.LEFT);
        btnNhapHang.setBounds(35, 315, 140, 38);

        btnSanPham = new JButton("Sản phẩm");
        btnSanPham.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnSanPham.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        btnSanPham.setBackground(new Color(51, 65, 85));
        btnSanPham.setForeground(Color.white);
        btnSanPham.setFocusPainted(false);
        btnSanPham.setBorder(BorderFactory.createEmptyBorder(7, 16, 7, 16));
        btnSanPham.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSanPham.setHorizontalAlignment(SwingConstants.LEFT);
        btnSanPham.setBounds(35, 374, 140, 38);

        btnNhaCungCap = new JButton("Nhà cung cấp");
        btnNhaCungCap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnNhaCungCap.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        btnNhaCungCap.setBackground(new Color(51, 65, 85));
        btnNhaCungCap.setForeground(Color.white);
        btnNhaCungCap.setFocusPainted(false);
        btnNhaCungCap.setBorder(BorderFactory.createEmptyBorder(7, 16, 7, 16));
        btnNhaCungCap.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNhaCungCap.setHorizontalAlignment(SwingConstants.LEFT);
        btnNhaCungCap.setBounds(35, 618, 140, 38);

        btnHoaDon = new JButton("Hóa đơn");
        btnHoaDon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

            }
        });
        btnHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        btnHoaDon.setBackground(new Color(51, 65, 85));
        btnHoaDon.setForeground(Color.white);
        btnHoaDon.setFocusPainted(false);
        btnHoaDon.setBorder(BorderFactory.createEmptyBorder(7, 16, 7, 16));
        btnHoaDon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
        btnHoaDon.setBounds(35, 559, 140, 38);

        btnNhanVien = new JButton("Nhân viên");
        btnNhanVien.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new NhanVienFrame().setVisible(true);	
            }
        });
        btnNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        btnNhanVien.setBackground(new Color(51, 65, 85));
        btnNhanVien.setForeground(Color.white);
        btnNhanVien.setFocusPainted(false);
        btnNhanVien.setBorder(BorderFactory.createEmptyBorder(7, 16, 7, 16));
        btnNhanVien.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
        btnNhanVien.setBounds(35, 436, 140, 38);
        
        btnDuNo = new JButton("Dư nợ hàng");
        btnDuNo.setHorizontalAlignment(SwingConstants.LEFT);
        btnDuNo.setForeground(Color.WHITE);
        btnDuNo.setFont(new Font("Dialog", Font.PLAIN, 15));
        btnDuNo.setFocusPainted(false);
        btnDuNo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDuNo.setBorder(BorderFactory.createEmptyBorder(7, 16, 7, 16));
        btnDuNo.setBackground(new Color(51, 65, 85));
        btnDuNo.setBounds(35, 679, 140, 38);
        sideBar.add(btnDuNo);

        sideBar.add(lblApp);
        sideBar.add(btnLichSu);
        sideBar.add(btnNhapHang);
        sideBar.add(btnSanPham);
        sideBar.add(btnNhaCungCap);
        sideBar.add(btnHoaDon);
        sideBar.add(btnNhanVien);

        getContentPane().add(sideBar);

        btnDoanhThu = new JButton("Doanh thu");
        btnDoanhThu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnDoanhThu.setHorizontalAlignment(SwingConstants.LEFT);
        btnDoanhThu.setForeground(Color.WHITE);
        btnDoanhThu.setFont(new Font("Dialog", Font.PLAIN, 15));
        btnDoanhThu.setFocusPainted(false);
        btnDoanhThu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDoanhThu.setBorder(BorderFactory.createEmptyBorder(7, 16, 7, 16));
        btnDoanhThu.setBackground(new Color(51, 65, 85));
        btnDoanhThu.setBounds(35, 497, 140, 38);
        sideBar.add(btnDoanhThu);

        JPanel topBar = new JPanel();
        topBar.setLayout(null);
        topBar.setBackground(Color.white);
        topBar.setBounds(210, 0, 1140, 64);
        topBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(232, 240, 254)));

        lblHoTen = new JLabel("Nhân viên A");
        lblHoTen.setBounds(25, 84, 129, 24);
        sideBar.add(lblHoTen);
        lblHoTen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblHoTen.setForeground(new Color(37, 99, 235));

        btnBanHang = new JButton("Bán hàng");
        btnBanHang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnBanHang.setHorizontalAlignment(SwingConstants.LEFT);
        btnBanHang.setForeground(Color.WHITE);
        btnBanHang.setFont(new Font("Dialog", Font.PLAIN, 15));
        btnBanHang.setFocusPainted(false);
        btnBanHang.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBanHang.setBorder(BorderFactory.createEmptyBorder(7, 16, 7, 16));
        btnBanHang.setBackground(new Color(51, 65, 85));
        btnBanHang.setBounds(35, 194, 140, 38);
        sideBar.add(btnBanHang);

        JLabel lblClock = new JLabel("Real-time");
        lblClock.setForeground(new Color(37, 99, 235));
        lblClock.setBounds(25, 120, 163, 32);
        sideBar.add(lblClock);
        Timer timer = new Timer(1000, new ActionListener() {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentTime = sdf.format(new Date());
                lblClock.setText(currentTime);
            }
        });
        timer.start();

        JLabel lblTitle = new JLabel("Bán hàng");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 25));
        lblTitle.setForeground(new Color(30, 64, 175));
        lblTitle.setBounds(28, 16, 220, 32);

        JButton btnLogout = new JButton("Đăng xuất");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                homeController.logout(HomeFrame.this);
            }
        });
        btnLogout.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        btnLogout.setBackground(new Color(30, 41, 59));
        btnLogout.setForeground(Color.white);
        btnLogout.setFocusPainted(false);
        btnLogout.setBorder(BorderFactory.createEmptyBorder(5, 16, 5, 16));
        btnLogout.setBounds(864, 23, 100, 28);

        topBar.add(lblTitle);
        topBar.add(btnLogout);

        getContentPane().add(topBar);

        //Panel nội dung
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBackground(new Color(245, 249, 255));
        contentPanel.setBounds(210, 64, 1140, 836);

        //Box doanh thu
        statBox1 = new JPanel(null);
        statBox1.setBackground(Color.white);
        statBox1.setBounds(30, 20, 250, 80);
        statBox1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 225, 230), 1, true),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));
        JLabel statTitle1 = new JLabel("Tổng doanh thu hôm nay");
        statTitle1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        statTitle1.setBounds(10, 4, 200, 22);
        lblDoanhThu = new JLabel("2.540.000 đ");
        lblDoanhThu.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblDoanhThu.setForeground(new Color(37,99,235));
        lblDoanhThu.setBounds(10, 32, 200, 38);
        statBox1.add(statTitle1);
        statBox1.add(lblDoanhThu);

        //Box số đơn
        statBox2 = new JPanel(null);
        statBox2.setBackground(Color.white);
        statBox2.setBounds(305, 20, 250, 80);
        statBox2.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 225, 230), 1, true),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));
        JLabel statTitle2 = new JLabel("Số đơn bán hôm nay");
        statTitle2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        statTitle2.setBounds(10, 4, 200, 22);
        lblSoDon = new JLabel("8");
        lblSoDon.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblSoDon.setForeground(new Color(34,197,94));
        lblSoDon.setBounds(10, 32, 200, 38);
        statBox2.add(statTitle2);
        statBox2.add(lblSoDon);

        //Box hàng tồn
        statBox3 = new JPanel(null);
        statBox3.setBackground(Color.white);
        statBox3.setBounds(580, 20, 250, 80);
        statBox3.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 225, 230), 1, true),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));
        JLabel statTitle3 = new JLabel("Số sản phẩm tồn");
        statTitle3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        statTitle3.setBounds(10, 4, 200, 22);
        lblSanPhamTon = new JLabel("250");
        lblSanPhamTon.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblSanPhamTon.setForeground(new Color(245,158,11));
        lblSanPhamTon.setBounds(10, 32, 200, 38);
        statBox3.add(statTitle3);
        statBox3.add(lblSanPhamTon);

        contentPanel.add(statBox1);
        contentPanel.add(statBox2);
        contentPanel.add(statBox3);

        //Khu vực bán hàng
        JPanel sellPanel = new JPanel(null);
        sellPanel.setBounds(12, 129, 964, 630);
        sellPanel.setBackground(Color.white);
        sellPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 225, 230), 1, true),
                BorderFactory.createEmptyBorder(22, 28, 18, 28)
        ));

        JLabel lblBanHang = new JLabel("Bán hàng");
        lblBanHang.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblBanHang.setBounds(10, 10, 300, 38);

        JLabel lblMaSP = new JLabel("Mã sản phẩm:");
        lblMaSP.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblMaSP.setBounds(10, 60, 120, 30);
        JTextField txtMaSP = new JTextField();
        txtMaSP.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtMaSP.setBounds(125, 60, 170, 30);

        JLabel lblSoLuong = new JLabel("Số lượng:");
        lblSoLuong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblSoLuong.setBounds(320, 60, 90, 30);
        JTextField txtSoLuong = new JTextField("1");
        txtSoLuong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        txtSoLuong.setBounds(395, 60, 60, 30);

        JButton btnThem = new JButton("Thêm vào giỏ");
        btnThem.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnThem.setBackground(new Color(37, 99, 235));
        btnThem.setForeground(Color.white);
        btnThem.setBounds(480, 60, 150, 30);
        btnThem.setFocusPainted(false);

        //Bảng giỏ hàng
        String[] cartCols = {"Mã SP", "Tên SP", "Đơn giá", "Số lượng", "Thành tiền"};
        cartModel = new DefaultTableModel(cartCols, 0);
        cartModel.addRow(new Object[]{"SP01", "Sữa tươi", "28000", "2", "56000"});
        cartModel.addRow(new Object[]{"SP12", "Bánh mì", "15000", "3", "45000"});
        tblCart = new JTable(cartModel);
        tblCart.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tblCart.setRowHeight(30);
        tblCart.setDefaultEditor(Object.class, null);
        JScrollPane cartScroll = new JScrollPane(tblCart);
        cartScroll.setBounds(10, 110, 920, 350);

        JLabel lblTongSanPham1 = new JLabel("Tổng sản phẩm:");
        lblTongSanPham1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTongSanPham1.setForeground(new Color(37, 99, 235));
        lblTongSanPham1.setBounds(10, 501, 175, 38);

        btnThanhToan = new JButton("Thanh toán");
        btnThanhToan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                xuLyThanhToan();
            }
        });

        btnThanhToan.setFont(new Font("Segoe UI", Font.BOLD, 17));
        btnThanhToan.setBackground(new Color(34, 197, 94));
        btnThanhToan.setForeground(Color.white);
        btnThanhToan.setBounds(705, 539, 140, 44);
        btnThanhToan.setFocusPainted(false);

        sellPanel.add(lblBanHang);
        sellPanel.add(lblMaSP);
        sellPanel.add(txtMaSP);
        sellPanel.add(lblSoLuong);
        sellPanel.add(txtSoLuong);
        sellPanel.add(btnThem);
        sellPanel.add(cartScroll);
        sellPanel.add(lblTongSanPham1);
        sellPanel.add(btnThanhToan);

        contentPanel.add(sellPanel);

        lblTongTien = new JLabel("101000");
        lblTongTien.setForeground(new Color(37, 99, 235));
        lblTongTien.setFont(new Font("Dialog", Font.BOLD, 20));
        lblTongTien.setBounds(132, 545, 140, 38);
        sellPanel.add(lblTongTien);

        JLabel lblTngCng = new JLabel("Tổng tiền:");
        lblTngCng.setForeground(new Color(37, 99, 235));
        lblTngCng.setFont(new Font("Dialog", Font.BOLD, 20));
        lblTngCng.setBounds(10, 545, 118, 38);
        sellPanel.add(lblTngCng);

        JLabel lblVND = new JLabel("VNĐ");
        lblVND.setForeground(new Color(37, 99, 235));
        lblVND.setFont(new Font("Dialog", Font.BOLD, 20));
        lblVND.setBounds(247, 545, 78, 38);
        sellPanel.add(lblVND);

        lblTongSanPham = new JLabel("6");
        lblTongSanPham.setForeground(new Color(37, 99, 235));
        lblTongSanPham.setFont(new Font("Dialog", Font.BOLD, 20));
        lblTongSanPham.setBounds(197, 501, 90, 38);
        sellPanel.add(lblTongSanPham);

        JLabel lblSnPhm = new JLabel("Sản phẩm");
        lblSnPhm.setForeground(new Color(37, 99, 235));
        lblSnPhm.setFont(new Font("Dialog", Font.BOLD, 20));
        lblSnPhm.setBounds(249, 501, 99, 38);
        sellPanel.add(lblSnPhm);

        JButton btnXoa = new JButton("X");
        btnXoa.setForeground(Color.WHITE);
        btnXoa.setFont(new Font("Dialog", Font.BOLD, 10));
        btnXoa.setFocusPainted(false);
        btnXoa.setBackground(new Color(224, 27, 36));
        btnXoa.setBounds(868, 65, 41, 24);
        sellPanel.add(btnXoa);
        
        cboThanhToan = new JComboBox(new String[] {"Tiền mặt", "Chuyển khoản"});
        cboThanhToan.setFont(new Font("Segoe UI", Font.BOLD, 15));
        cboThanhToan.setForeground(new Color(37, 99, 235));
        cboThanhToan.setBackground(Color.WHITE);
        cboThanhToan.setFocusable(false);
        cboThanhToan.setBounds(680, 489, 185, 36);
        cboThanhToan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cboThanhToan.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 225, 230), 1, true),
            BorderFactory.createEmptyBorder(4, 14, 4, 14)
        ));
        sellPanel.add(cboThanhToan);

        //Sửa action cho nút Xóa
        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = tblCart.getSelectedRow();
                if (row >= 0) {
                    cartModel.removeRow(row);
                    homeController.capNhatTongSanPham(cartModel, lblTongSanPham);
                    homeController.capNhatTongTien(cartModel, lblTongTien);
                } else {
                    JOptionPane.showMessageDialog(HomeFrame.this, "Vui lòng chọn sản phẩm cần xóa!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        getContentPane().add(contentPanel);

        //Set tên user và ẩn nút theo quyền
        homeController.phanQuyenUser(
                lblHoTen,
                btnBanHang,
                btnNhapHang,
                btnLichSu,
                btnSanPham,
                btnNhaCungCap,
                btnHoaDon,
                btnNhanVien,
                btnDoanhThu,
                btnThanhToan,
                btnDuNo
        );
        
    }
    
    private void xuLyThanhToan() {
        try {
            double tongTien = 0;
            for (int i = 0; i < cartModel.getRowCount(); i++) {
                tongTien += Double.parseDouble(cartModel.getValueAt(i, 4).toString());
            }

            // 2. Lấy mã nhân viên đăng nhập
            String maNV = com.example.apptaphoa.utils.AuthUtil.getUser().getMaNV();
            String hinhThucTT = cboThanhToan.getSelectedItem().toString();

            // 3. Tạo hóa đơn
            HoaDon hd = new HoaDon();
            hd.setThoiGian(new java.sql.Timestamp(System.currentTimeMillis()));
            hd.setTongTien(tongTien);
            hd.setHinhThucTT(hinhThucTT);
            hd.setMaNV(Integer.parseInt(maNV));

            int maHD = hoaDonDAO.insertAndReturnId(hd);
            if (maHD == -1) {
                JOptionPane.showMessageDialog(this, "Không thể tạo hóa đơn!");
                return;
            }

            // 4. Thêm từng chi tiết hóa đơn
            for (int i = 0; i < cartModel.getRowCount(); i++) {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setMaHD(maHD);
                cthd.setMaSanPham(Integer.parseInt(cartModel.getValueAt(i, 0).toString()));
                cthd.setSoLuong(Integer.parseInt(cartModel.getValueAt(i, 3).toString()));
                cthd.setDonGia(Double.parseDouble(cartModel.getValueAt(i, 2).toString()));
                cthd.setThanhTien(Double.parseDouble(cartModel.getValueAt(i, 4).toString()));
                chiTietHoaDonDAO.insert(cthd);
            }

            JOptionPane.showMessageDialog(this, "Thanh toán thành công! Hóa đơn #" + maHD);
            cartModel.setRowCount(0);
            lblTongSanPham.setText("0");
            lblTongTien.setText("0");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi thanh toán: " + ex.getMessage());
        }
    }


    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(new FlatLightLaf()); } catch(Exception ignored) {}
        SwingUtilities.invokeLater(() -> new HomeFrame().setVisible(true));
    }
}
