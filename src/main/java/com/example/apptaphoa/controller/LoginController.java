package com.example.apptaphoa.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.example.apptaphoa.dao.NhanVienDAO;
import com.example.apptaphoa.model.NhanVien;
import com.example.apptaphoa.utils.AuthUtil;
import com.example.apptaphoa.views.HomeFrame;
import com.example.apptaphoa.views.LoginFrame;

public class LoginController {
	public static void login(JFrame frame, JTextField txtUsername, JPasswordField txtPassword) {
        String username = txtUsername.getText().trim();
        String password = String.valueOf(txtPassword.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ tên đăng nhập và mật khẩu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        NhanVienDAO dao = new NhanVienDAO();
        NhanVien nv = dao.findByUsernameAndPassword(username, password);
        if (nv != null) {
            AuthUtil.login(nv);
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.dispose();
            JOptionPane.showMessageDialog(null, "Đăng nhập thành công! Xin chào " + nv.getHoTen());
            HomeFrame homeFrame = new HomeFrame();
            homeFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}