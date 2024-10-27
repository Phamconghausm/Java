package com.project.XayDungGioHang;

public abstract class SanPham {
    private final String ten;
    private final double gia;

    public SanPham(String ten, double gia) {
        this.ten = ten;
        this.gia = gia;
    }

    public String getTen() {
        return ten;
    }

    public double getGia() {
        return gia;
    }

    public abstract void hienThiThongTin();
}
