package com.project.XayDungGioHang;

public class CartItem {
    private final SanPham sanPham;
    private int soLuong;


    public CartItem(SanPham sanPham, int soLuong) {
        this.sanPham = sanPham;
        this.soLuong = soLuong;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getTongGia() {
        return sanPham.getGia() * soLuong;
    }

    @Override
    public String toString() {
        return sanPham.getTen() + " x " + soLuong + " = $" + getTongGia();
    }
}

