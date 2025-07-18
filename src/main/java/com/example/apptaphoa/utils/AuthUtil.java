package com.example.apptaphoa.utils;

import com.example.apptaphoa.model.NhanVien;

public class AuthUtil {
    private static NhanVien currentUser = null;

    // Đăng nhập: gán user vào AuthUtil
    public static void login(NhanVien nv) {
        currentUser = nv;
    }

    // Đăng xuất: xóa user
    public static void logout() {
        currentUser = null;
    }

    // Lấy user hiện tại
    public static NhanVien getUser() {
        return currentUser;
    }

    // Kiểm tra đã đăng nhập chưa
    public static boolean isLogin() {
        return currentUser != null;
    }

    // Kiểm tra vai trò quản lý
    public static boolean isManager() {
        return currentUser != null && 
               currentUser.getVaiTro() != null &&
               currentUser.getVaiTro().equalsIgnoreCase("Quản lý");
    }

    // Kiểm tra vai trò nhân viên
    public static boolean isStaff() {
        return currentUser != null && 
               currentUser.getVaiTro() != null &&
               currentUser.getVaiTro().equalsIgnoreCase("Nhân viên");
    }
}
