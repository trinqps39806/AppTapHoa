package com.example.apptaphoa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.example.apptaphoa.utils.JDBCUtil;

public class SanPhamDAO {
    public boolean truSoLuong(int maSP, int soLuong) {
        String sql = "UPDATE SanPham SET SoLuong = SoLuong - ? WHERE MaSanPham = ?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, soLuong);
            ps.setInt(2, maSP);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }
}
