package com.example.apptaphoa.controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.example.apptaphoa.utils.AuthUtil;
import com.example.apptaphoa.model.NhanVien;

public class HomeController {
	NhanVien nv = new NhanVien();
	// Đăng xuất
	public void logout(JFrame homeFrame) {
		int confirm = JOptionPane.showConfirmDialog(homeFrame, "Bạn có chắc chắn muốn đăng xuất?", "Xác nhận đăng xuất",
				JOptionPane.YES_NO_OPTION);

		if (confirm == JOptionPane.YES_OPTION) {
			AuthUtil.logout();
			homeFrame.dispose();
			new com.example.apptaphoa.views.LoginFrame().setVisible(true);
		}
	}

	// Set tên người dùng lên label, và kiểm tra vai trò để enable/disable nút
	public void phanQuyenUser(JLabel lblHoTen, JButton btnSanPham, JButton btnNhaCungCap, JButton btnHoaDon, JButton btnNhanVien, JButton btnDoanhThu) {
		nv = AuthUtil.getUser();
		if (nv != null) {
			lblHoTen.setText(nv.getHoTen());
			if ("Admin".equalsIgnoreCase(nv.getVaiTro())) {
				// Quản lý: hiện tất cả các nút
				btnSanPham.setVisible(true);
				btnNhaCungCap.setVisible(true);
				btnHoaDon.setVisible(true);
				btnNhanVien.setVisible(true);
				btnDoanhThu.setVisible(true);
			} else {
				// Nhân viên: ẩn các nút này
				btnSanPham.setVisible(false);
				btnNhaCungCap.setVisible(false);
				btnHoaDon.setVisible(false);
				btnNhanVien.setVisible(false);
				btnDoanhThu.setVisible(false);
			}
		} else {
			lblHoTen.setText("Chưa đăng nhập");
			btnSanPham.setVisible(false);
			btnNhaCungCap.setVisible(false);
			btnHoaDon.setVisible(false);
			btnNhanVien.setVisible(false);
			btnDoanhThu.setVisible(false);
		}
	}
	
	// Hàm cập nhật tổng số sản phẩm
    public void capNhatTongSanPham(DefaultTableModel cartModel, JLabel lblTongSanPham) {
        int tong = 0;
        for (int i = 0; i < cartModel.getRowCount(); i++) {
            try {
                int sl = Integer.parseInt(cartModel.getValueAt(i, 3).toString());
                tong += sl;
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        lblTongSanPham.setText(String.valueOf(tong));
    }

}
