package com.project.XayDungGioHang;

class SanPhamDienTu extends SanPham {


    public SanPhamDienTu(String name, double price) {
        super(name, price);
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("Sản phẩm điện tử: " + getTen() + " - $" + getGia());
    }
}

