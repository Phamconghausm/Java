package com.project.XayDungGioHang;

class SanPhamQuanAo extends SanPham {

    public SanPhamQuanAo(String ten, double gia) {
        super(ten, gia);
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("Sản phẩm quần áo: " + getTen() + " - $" + getGia());
    }
}