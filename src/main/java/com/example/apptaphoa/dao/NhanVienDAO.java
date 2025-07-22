package com.example.apptaphoa.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.apptaphoa.model.NhanVien;
import com.example.apptaphoa.utils.JDBCUtil;

public class NhanVienDAO {
    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> list = new ArrayList<>();
        String sql = "SELECT * FROM NhanVien";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setTenDangNhap(rs.getString("TenDangNhap"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setEmail(rs.getString("Email"));
                nv.setVaiTro(rs.getString("VaiTro"));
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(NhanVien nv) {
        String sql = "INSERT INTO NhanVien (MaNV, HoTen, TenDangNhap, MatKhau, GioiTinh, Email, VaiTro) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getHoTen());
            ps.setString(3, nv.getTenDangNhap());
            ps.setString(4, nv.getMatKhau());
            ps.setString(5, nv.getGioiTinh());
            ps.setString(6, nv.getEmail());
            ps.setString(7, nv.getVaiTro());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(NhanVien nv) {
        String sql = "UPDATE NhanVien SET HoTen=?, TenDangNhap=?, MatKhau=?, GioiTinh=?, Email=?, VaiTro=? WHERE MaNV=?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nv.getHoTen());
            ps.setString(2, nv.getTenDangNhap());
            ps.setString(3, nv.getMatKhau());
            ps.setString(4, nv.getGioiTinh());
            ps.setString(5, nv.getEmail());
            ps.setString(6, nv.getVaiTro());
            ps.setString(7, nv.getMaNV());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String maNV) {
        String sql = "DELETE FROM NhanVien WHERE MaNV=?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maNV);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public NhanVien findById(String maNV) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV=?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maNV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setTenDangNhap(rs.getString("TenDangNhap"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setEmail(rs.getString("Email"));
                nv.setVaiTro(rs.getString("VaiTro"));
                return nv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
        nv.setMaNV(rs.getString("MaNV"));
        nv.setHoTen(rs.getString("HoTen"));
        nv.setTenDangNhap(rs.getString("TenDangNhap"));
        nv.setMatKhau(rs.getString("MatKhau"));
        nv.setGioiTinh(rs.getString("GioiTinh"));
        nv.setEmail(rs.getString("Email"));
        nv.setVaiTro(rs.getString("VaiTro"));
        return nv;
    }
}
