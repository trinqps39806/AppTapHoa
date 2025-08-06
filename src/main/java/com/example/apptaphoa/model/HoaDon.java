package com.example.apptaphoa.model;

public class HoaDon {
    private int maHD;
<<<<<<< HEAD
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
=======
    private Date thoiGian;
    private double tongTien;
    private String hinhThucTT;
    private String maNV;

    public HoaDon() {}

    public HoaDon(double tongTien, String hinhThucTT, String maNV) {
        this.tongTien = tongTien;
        this.hinhThucTT = hinhThucTT;
        this.maNV = maNV;
    }

    public int getMaHD() { return maHD; }
    public void setMaHD(int maHD) { this.maHD = maHD; }

    public Date getThoiGian() { return thoiGian; }
    public void setThoiGian(Date thoiGian) { this.thoiGian = thoiGian; }

    public double getTongTien() { return tongTien; }
    public void setTongTien(double tongTien) { this.tongTien = tongTien; }

    public String getHinhThucTT() { return hinhThucTT; }
    public void setHinhThucTT(String hinhThucTT) { this.hinhThucTT = hinhThucTT; }

    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }
>>>>>>> 7138b57 (E)
}

