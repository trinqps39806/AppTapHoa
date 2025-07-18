package com.example.apptaphoa.utils;

import java.net.URL;

import javax.swing.ImageIcon;

public class IconUtil {
	public static ImageIcon getIcon(String path) {
        URL url = IconUtil.class.getResource("/Images/" + path);
        if (url != null) {
            return new ImageIcon(url);
        }
        return null;
    }
}
