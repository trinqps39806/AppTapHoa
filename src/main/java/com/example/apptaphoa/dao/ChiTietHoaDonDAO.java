package com.example.apptaphoa.dao;

<<<<<<< HEAD
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
=======
import com.example.apptaphoa.model.ChiTietHoaDon;
import com.example.apptaphoa.utils.JDBCUtil;

import java.sql.*;

public class ChiTietHoaDonDAO {
    public void insert(ChiTietHoaDon cthd) {
        String sql = "INSERT INTO ChiTietHoaDon (MaHD, MaSanPham, SoLuong, DonGia, ThanhTien) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
>>>>>>> 7138b57 (E)
            ps.setInt(1, cthd.getMaHD());
            ps.setInt(2, cthd.getMaSanPham());
            ps.setInt(3, cthd.getSoLuong());
            ps.setDouble(4, cthd.getDonGia());
            ps.setDouble(5, cthd.getThanhTien());
<<<<<<< HEAD
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
=======
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
>>>>>>> 7138b57 (E)
    }
}
