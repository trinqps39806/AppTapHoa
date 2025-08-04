package com.example.apptaphoa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import com.example.apptaphoa.model.HoaDon;
import com.example.apptaphoa.utils.JDBCUtil;
import java.sql.*;

public class HoaDonDAO {
    public int insertAndReturnId(HoaDon hd) {
        String sql = "INSERT INTO HoaDon (ThoiGian, TongTien, HinhThucTT, MaNV) VALUES (?, ?, ?, ?)";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setTimestamp(1, hd.getThoiGian());
            ps.setDouble(2, hd.getTongTien());
            ps.setString(3, hd.getHinhThucTT());
            ps.setInt(4, hd.getMaNV());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        } catch (Exception e) { e.printStackTrace(); }
        return -1;
    }
}

