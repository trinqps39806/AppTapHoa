package com.example.apptaphoa.controller;
import java.util.List;

import com.example.apptaphoa.dao.NhanVienDAO;
import com.example.apptaphoa.model.NhanVien;

public class NhanVienController {
    private NhanVienDAO nhanVienDAO = new NhanVienDAO();

    // Lấy danh sách tất cả nhân viên
    public List<NhanVien> getAllNhanVien() {
        return nhanVienDAO.getAllNhanVien();
    }

    // Thêm mới nhân viên
    public boolean addNhanVien(NhanVien nv) {
        return nhanVienDAO.insert(nv);
    }

    // Cập nhật thông tin nhân viên
    public boolean updateNhanVien(NhanVien nv) {
        return nhanVienDAO.update(nv);
    }

    // Xóa nhân viên
    public boolean deleteNhanVien(String maNV) {
        return nhanVienDAO.delete(maNV);
    }

    // Tìm nhân viên theo mã
    public NhanVien findNhanVienById(String maNV) {
        return nhanVienDAO.findById(maNV);
    }

}

