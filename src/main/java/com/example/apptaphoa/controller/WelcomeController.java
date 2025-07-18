package com.example.apptaphoa.controller;

import javax.swing.*;

import com.example.apptaphoa.views.LoginFrame;

import java.awt.*;

public class WelcomeController {

    private JProgressBar progressBar;
    private JLabel statusLabel;
    private Runnable onFinish;

    public WelcomeController(JProgressBar progressBar, JLabel statusLabel, Runnable onFinish) {
        this.progressBar = progressBar;
        this.statusLabel = statusLabel;
        this.onFinish = onFinish;
    }

    public void startLoading() {
        new Thread(() -> {
            String base = "Đang khởi động";
            try {
                for (int i = 0; i <= 100; i++) {
                    int percent = i;
                    int dots = (i / 10) % 4;
                    String status = base + ".".repeat(dots);

                    SwingUtilities.invokeLater(() -> {
                        progressBar.setValue(percent);
                        statusLabel.setText(status);
                    });

                    Thread.sleep(40);
                }

                SwingUtilities.invokeLater(onFinish);
                LoginFrame login = new LoginFrame();
                login.setVisible(true);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
