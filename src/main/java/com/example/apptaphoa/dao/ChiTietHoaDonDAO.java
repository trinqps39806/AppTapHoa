package com.example.apptaphoa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.example.apptaphoa.model.ChiTietHoaDon;
import com.example.apptaphoa.utils.JDBCUtil;
import java.sql.*;

public class ChiTietHoaDonDAO {
    public boolean insert(ChiTietHoaDon cthd) {
        String sql = "INSERT INTO ChiTietHoaDon (MaHD, MaSanPham, SoLuong, DonGia, ThanhTien) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cthd.getMaHD());
            ps.setInt(2, cthd.getMaSanPham());
            ps.setInt(3, cthd.getSoLuong());
            ps.setDouble(4, cthd.getDonGia());
            ps.setDouble(5, cthd.getThanhTien());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }
}
