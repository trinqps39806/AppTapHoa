package com.example.apptaphoa.controller;

<<<<<<< HEAD
import java.util.List;

import com.example.apptaphoa.dao.ChiTietHoaDonDAO;
import com.example.apptaphoa.dao.HoaDonDAO;
import com.example.apptaphoa.dao.SanPhamDAO;
import com.example.apptaphoa.model.ChiTietHoaDon;
import com.example.apptaphoa.model.HoaDon;

public class BanHangController {
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();
    private ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();
    private SanPhamDAO spDAO = new SanPhamDAO();

    
=======
import com.example.apptaphoa.dao.*;
import com.example.apptaphoa.model.*;
import java.util.*;

public class BanHangController {
    private List<ChiTietHoaDon> gioHang = new ArrayList<>();
    private SanPhamDAO sanPhamDAO = new SanPhamDAO();
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();
    private ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();

    public void themSanPhamVaoGio(SanPham sp, int soLuong) {
        for (ChiTietHoaDon cthd : gioHang) {
            if (cthd.getMaSanPham() == sp.getMaSanPham()) {
                cthd.setSoLuong(cthd.getSoLuong() + soLuong);
                cthd.setThanhTien(cthd.getSoLuong() * cthd.getDonGia());
                return;
            }
        }
        gioHang.add(new ChiTietHoaDon(0, sp.getMaSanPham(), soLuong, sp.getDonGia(), soLuong * sp.getDonGia()));
    }

    public void thanhToan(String hinhThucTT, String maNV) {
        double tongTien = gioHang.stream().mapToDouble(ChiTietHoaDon::getThanhTien).sum();
        HoaDon hd = new HoaDon();
        hd.setThoiGian(new Date());
        hd.setTongTien(tongTien);
        hd.setHinhThucTT(hinhThucTT);
        hd.setMaNV(maNV); // String
        int maHD = hoaDonDAO.insertAndReturnId(hd);
        for (ChiTietHoaDon cthd : gioHang) {
            cthd.setMaHD(maHD);
            chiTietHoaDonDAO.insert(cthd);
            sanPhamDAO.giamSoLuongTonKho(cthd.getMaSanPham(), cthd.getSoLuong());
        }
        gioHang.clear();
    }

    public List<ChiTietHoaDon> getGioHang() {
        return gioHang;
    }
>>>>>>> 7138b57 (E)
}
