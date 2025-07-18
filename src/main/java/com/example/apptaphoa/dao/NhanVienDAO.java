package com.example.apptaphoa.dao;

import com.example.apptaphoa.utils.JDBCUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.apptaphoa.model.NhanVien;


public class NhanVienDAO {
    // Thêm nhân viên mới
    public boolean insert(NhanVien nv) {
        String sql = "INSERT INTO NhanVien (HoTen, TenDangNhap, MatKhau, GioiTinh, Email, VaiTro) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nv.getHoTen());
            ps.setString(2, nv.getTenDangNhap());
            ps.setString(3, nv.getMatKhau());
            ps.setString(4, nv.getGioiTinh());
            ps.setString(5, nv.getEmail());
            ps.setString(6, nv.getVaiTro());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    // Sửa thông tin nhân viên
    public boolean update(NhanVien nv) {
        String sql = "UPDATE NhanVien SET HoTen=?, TenDangNhap=?, MatKhau=?, GioiTinh=?, Email=?, VaiTro=? WHERE MaNV=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nv.getHoTen());
            ps.setString(2, nv.getTenDangNhap());
            ps.setString(3, nv.getMatKhau());
            ps.setString(4, nv.getGioiTinh());
            ps.setString(5, nv.getEmail());
            ps.setString(6, nv.getVaiTro());
            ps.setInt(7, nv.getMaNV());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    // Xóa nhân viên theo mã
    public boolean delete(int maNV) {
        String sql = "DELETE FROM NhanVien WHERE MaNV=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, maNV);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    // Tìm nhân viên theo mã
    public NhanVien findById(int maNV) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, maNV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapNhanVien(rs);
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    // Lấy tất cả nhân viên
    public List<NhanVien> findAll() {
        List<NhanVien> list = new ArrayList<>();
        String sql = "SELECT * FROM NhanVien";
        try (Connection con = JDBCUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) list.add(mapNhanVien(rs));
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    // Tìm nhân viên theo tên đăng nhập và mật khẩu (login)
    public NhanVien findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM NhanVien WHERE TenDangNhap = ? AND MatKhau = ?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapNhanVien(rs);
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    // Hàm chuyển ResultSet thành object NhanVien
    private NhanVien mapNhanVien(ResultSet rs) throws SQLException {
        NhanVien nv = new NhanVien();
        nv.setMaNV(rs.getInt("MaNV"));
        nv.setHoTen(rs.getString("HoTen"));
        nv.setTenDangNhap(rs.getString("TenDangNhap"));
        nv.setMatKhau(rs.getString("MatKhau"));
        nv.setGioiTinh(rs.getString("GioiTinh"));
        nv.setEmail(rs.getString("Email"));
        nv.setVaiTro(rs.getString("VaiTro"));
        return nv;
    }
}