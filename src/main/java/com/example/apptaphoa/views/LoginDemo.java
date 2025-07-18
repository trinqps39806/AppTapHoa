package com.example.apptaphoa.views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class LoginDemo extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JLabel lblMessage;
    private JLabel lblForgotPassword;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                LoginDemo frame = new LoginDemo();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LoginDemo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1350, 900);
        setLocationRelativeTo(null);
        setTitle("Đăng nhập hệ thống tạp hóa");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Panel hình ảnh (bên trái)
        int leftPanelWidth = 675;
        int frameHeight = 900;

        JPanel panelImg = new JPanel();
        panelImg.setBounds(0, 0, leftPanelWidth, frameHeight);
        contentPane.add(panelImg);
        panelImg.setLayout(null);

        JLabel lblImage = new JLabel();
        lblImage.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/Images/backgroundLogin.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(leftPanelWidth, frameHeight, Image.SCALE_SMOOTH);
        lblImage.setIcon(new ImageIcon(scaledImage));
        lblImage.setBounds(0, 0, leftPanelWidth, frameHeight);
        panelImg.add(lblImage);

        // Panel login (bên phải)
        JPanel panelLogin = new JPanel();
        panelLogin.setBounds(leftPanelWidth, 0, leftPanelWidth, frameHeight);
        panelLogin.setLayout(null);
        panelLogin.setBackground(new Color(242, 247, 255));
        contentPane.add(panelLogin);

        // Logo
        JLabel lblLogo = new JLabel();
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/Images/logo-Photoroom.png"));
        Image logoImg = logoIcon.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
        lblLogo.setIcon(new ImageIcon(logoImg));
        lblLogo.setBounds((leftPanelWidth-160)/2, 90, 160, 160);
        panelLogin.add(lblLogo);

        // Tiêu đề
        JLabel lblTitle = new JLabel("TẠP HÓA ĂN VẶT");
        lblTitle.setFont(new Font("Dialog", Font.BOLD, 32));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setForeground(new Color(32, 133, 207));
        lblTitle.setBounds(110, 270, 455, 70);
        Border border = BorderFactory.createLineBorder(new Color(32, 133, 207), 5, true);
        lblTitle.setBorder(border);
        panelLogin.add(lblTitle);

        // Tên đăng nhập
        JLabel lblUser = new JLabel("Tên đăng nhập");
        lblUser.setFont(new Font("Dialog", Font.BOLD, 15));
        lblUser.setBounds(185, 380, 300, 33);
        panelLogin.add(lblUser);

        txtUsername = new JTextField();
        txtUsername.setBounds(73, 415, 534, 48);
        txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        txtUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(32, 133, 207)));
        txtUsername.setBackground(new Color(242, 247, 255));
        txtUsername.setCaretColor(new Color(32, 133, 207));
        panelLogin.add(txtUsername);

        // Mật khẩu
        JLabel lblPass = new JLabel("Mật khẩu");
        lblPass.setFont(new Font("Dialog", Font.BOLD, 15));
        lblPass.setBounds(185, 485, 300, 33);
        panelLogin.add(lblPass);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(73, 523, 534, 48);
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        txtPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(32, 133, 207)));
        txtPassword.setBackground(new Color(242, 247, 255));
        txtPassword.setCaretColor(new Color(32, 133, 207));
        panelLogin.add(txtPassword);

        // "Quên mật khẩu?" node
        lblForgotPassword = new JLabel("<HTML><U>Quên mật khẩu?</U></HTML>");
        lblForgotPassword.setForeground(new Color(32, 133, 207));
        lblForgotPassword.setFont(new Font("Segoe UI", Font.ITALIC, 17));
        lblForgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblForgotPassword.setBounds(353, 605, 130, 28);
        panelLogin.add(lblForgotPassword);

        // Sự kiện mẫu cho "Quên mật khẩu?"
        lblForgotPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JOptionPane.showMessageDialog(LoginDemo.this,
                        "Chức năng quên mật khẩu sẽ được cập nhật sau!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Thông báo lỗi
        lblMessage = new JLabel(" ");
        lblMessage.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        lblMessage.setForeground(Color.RED);
        lblMessage.setBounds(155, 765, 300, 28);
        panelLogin.add(lblMessage);

        // Nút đăng nhập
        JButton btnLogin = new JButton("Đăng nhập");
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBackground(new Color(32, 133, 207));
        btnLogin.setBorder(new RoundedBorder(60));
        btnLogin.setFocusPainted(false);
        btnLogin.setBounds(168, 670, 146, 50);
        panelLogin.add(btnLogin);

        JButton btnExit = new JButton("Thoát");
        btnExit.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        btnExit.setBackground(Color.LIGHT_GRAY);
        btnExit.setBorder(new RoundedBorder(60));
        btnExit.setBounds(402, 670, 146, 50);
        panelLogin.add(btnExit);

    }

    static class RoundedBorder extends LineBorder {
        public RoundedBorder(int radius) {
            super(new Color(32, 133, 207), 1, true);
        }
    }
}
