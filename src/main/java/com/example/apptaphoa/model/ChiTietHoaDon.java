package com.example.apptaphoa.model;

public class ChiTietHoaDon {
	private int maHD;
    private int maSanPham;
    private int soLuong;
    private double donGia;
    private double thanhTien;
    
    public ChiTietHoaDon(int maHD, int maSanPham, int soLuong, double donGia, double thanhTien) {
        this.maHD = maHD;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }
	public ChiTietHoaDon() {
		// Constructor rỗng
	}

	public int getMaHD() {
		return maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public int getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
    
    
}
