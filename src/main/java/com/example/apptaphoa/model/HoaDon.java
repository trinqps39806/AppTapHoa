package com.example.apptaphoa.model;

public class HoaDon {
    private int maHD;
    private java.sql.Timestamp thoiGian;
    private double tongTien;
    private String hinhThucTT;
    private int maNV;

    // Getter/Setter
    public int getMaHD() { return maHD; }
    public void setMaHD(int maHD) { this.maHD = maHD; }
    public java.sql.Timestamp getThoiGian() { return thoiGian; }
    public void setThoiGian(java.sql.Timestamp thoiGian) { this.thoiGian = thoiGian; }
    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }
    public String getHinhThucTT() { return hinhThucTT; }
    public void setHinhThucTT(String hinhThucTT) { this.hinhThucTT = hinhThucTT; }
    public int getMaNV() { return maNV; }
    public void setMaNV(int maNV) { this.maNV = maNV; }
}

