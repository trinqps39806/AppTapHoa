package com.example.apptaphoa.views;

import com.example.apptaphoa.controller.LoginController;
import com.example.apptaphoa.model.NhanVien;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
	JButton btnLogin;
	JTextField txtUsername;
	JPasswordField txtPassword;
	public JButton getBtnLogin() { return btnLogin; }
	public JTextField getTxtUsername() { return txtUsername; }
	public JPasswordField getTxtPassword() { return txtPassword; }
	LoginController loginController = new LoginController();
	
    public LoginFrame() {
        setTitle("Login - App Tạp Hóa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 800);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel() {
            BufferedImage bgImg = null;
            {
                try {
                    bgImg = ImageIO.read(getClass().getResource("/Images/bg.png"));
                } catch (IOException | IllegalArgumentException e) {
                    System.out.println("Không tìm thấy background!");
                }
            }
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if(bgImg != null)
                    g.drawImage(bgImg, 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainPanel.setLayout(null);

        JLabel lblImage = new JLabel();
        try {
            BufferedImage img = ImageIO.read(getClass().getResource("/Images/logo_art.png"));
            Image scaled = img.getScaledInstance(585, 450, Image.SCALE_SMOOTH);
            lblImage.setIcon(new ImageIcon(scaled));
        } catch (IOException | IllegalArgumentException e) {
            lblImage.setText("Image not found");
        }
        lblImage.setBounds(12, 184, 460, 445);
        mainPanel.add(lblImage);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(Color.white);
        formPanel.setOpaque(true);
        formPanel.setBounds(560, 173, 471, 458);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(230, 236, 240), 2, true),
                BorderFactory.createEmptyBorder(35, 45, 35, 45)
        ));

        JLabel lblTitle = new JLabel("Đăng nhập");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 36));
        lblTitle.setForeground(new Color(37, 99, 235));
        lblTitle.setBounds(12, 31, 300, 45);

        txtUsername = new JTextField();
        txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtUsername.setBounds(34, 104, 408, 48);
        txtUsername.setBorder(BorderFactory.createTitledBorder("Username"));

        txtPassword = new JPasswordField();
        txtPassword.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		loginController.login(LoginFrame.this, txtUsername, txtPassword);
        	}
        });
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtPassword.setBounds(34, 195, 408, 48);
        txtPassword.setBorder(BorderFactory.createTitledBorder("Password"));

        JLabel lblForgot = new JLabel("<HTML><U>Quên mật khẩu?</U></HTML>");
        lblForgot.setForeground(new Color(130, 130, 130));
        lblForgot.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lblForgot.setBounds(237, 267, 120, 35);
        lblForgot.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnLogin = new JButton("Đăng nhập");
        btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		loginController.login(LoginFrame.this, txtUsername, txtPassword);
        	}
        });
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnLogin.setBackground(new Color(37, 99, 235));
        btnLogin.setForeground(Color.white);
        btnLogin.setFocusPainted(false);
        btnLogin.setBounds(60, 327, 350, 48);
        btnLogin.setBorder(BorderFactory.createLineBorder(new Color(37, 99, 235), 1, true));
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));

        formPanel.add(lblTitle);
        formPanel.add(txtUsername);
        formPanel.add(txtPassword);
        formPanel.add(lblForgot);
        formPanel.add(btnLogin);

        mainPanel.add(formPanel);
        setContentPane(mainPanel);
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(new FlatLightLaf()); } catch(Exception ignored){}
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}

