package com.example.apptaphoa.views;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.apptaphoa.controller.WelcomeController;

import java.awt.BorderLayout;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Font;

public class WelcomeFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeFrame frame = new WelcomeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WelcomeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JProgressBar progressBarLoading = new JProgressBar();
		progressBarLoading.setValue(16);
		progressBarLoading.setBounds(235, 704, 853, 26);
		panel.add(progressBarLoading);
		progressBarLoading.setStringPainted(true);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/Images/logo-Photoroom.png"));
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		lblNewLabel_1.setIcon(new ImageIcon(scaledImage));
		lblNewLabel_1.setBounds(0, 320, 1340, 271);
		panel.add(lblNewLabel_1);
		
		JLabel lblStatus = new JLabel("Đang khởi động...");
		lblStatus.setFont(new Font("Dialog", Font.BOLD, 16));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(0, 761, 1340, 39);
		panel.add(lblStatus);
		addWindowListener(new java.awt.event.WindowAdapter() {
		    public void windowOpened(java.awt.event.WindowEvent evt) {
		        WelcomeController controller = new WelcomeController(progressBarLoading, lblStatus, () -> dispose());
		        controller.startLoading();
		    }
		});
		
		JLabel lblTpHan = new JLabel("TẠP HÓA ĂN VẶT");
		lblTpHan.setFont(new Font("Arial", Font.BOLD, 69));
		lblTpHan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTpHan.setForeground(new Color(26, 95, 180));
		lblTpHan.setBounds(0, 131, 1340, 177);
		panel.add(lblTpHan);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/Images/bg.png")));
		lblNewLabel.setBounds(0, 0, 1340, 890);
		panel.add(lblNewLabel);
		setLocationRelativeTo(null);
		
	}
}
