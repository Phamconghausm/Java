package com.project.XayDungGioHang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    private final List<CartItem> items;
    private double phanTramGiamGia;
    private boolean kiemTraMaGiamGia;

    public ShoppingCart() {
        items = new ArrayList<>();
        phanTramGiamGia = 0;
        kiemTraMaGiamGia = false;
    }

    public boolean isKiemTraMaGiamGia() {
        return kiemTraMaGiamGia;
    }

    public double getPhanTramGiamGia() {
        return phanTramGiamGia;
    }

    public void addProduct(SanPham sanPham, int soLuong) {
        for (CartItem item : items) {
            if (item.getSanPham().getTen().equals(sanPham.getTen())) {
                item.setSoLuong(item.getSoLuong() + soLuong);
                return;
            }
        }
        items.add(new CartItem(sanPham, soLuong));
    }


    public void removeProduct(String tenSanPham) {
        Scanner scanner = new Scanner(System.in);

        for (CartItem item : items) {
            if (item.getSanPham().getTen().equals(tenSanPham)) {
                System.out.println("Nhập số lượng muốn xóa của sản phẩm " + tenSanPham + ": ");
                int soLuongMuonXoa = scanner.nextInt();

                if (soLuongMuonXoa >= item.getSoLuong()) {
                    items.remove(item);
                    System.out.println("Sản phẩm " + tenSanPham + " đã được xóa khỏi giỏ hàng.");
                } else {
                    item.setSoLuong(item.getSoLuong() - soLuongMuonXoa);
                    System.out.println("Số lượng của sản phẩm " + tenSanPham + " đã được cập nhật. Số lượng còn lại: " + item.getSoLuong());
                }
                return;
            }
        }
        System.out.println("Sản phẩm không tồn tại trong giỏ hàng.");
    }


    public void updateProductQuantity(String tenSanPham, int soLuongMoi) {
        for (CartItem item : items) {
            if (item.getSanPham().getTen().equals(tenSanPham)) {
                item.setSoLuong(soLuongMoi);
                System.out.println("Số lượng của sản phẩm " + tenSanPham + " đã được cập nhật.");
                return;
            }
        }
        System.out.println("Sản phẩm không tồn tại trong giỏ hàng.");
    }

    public void applyDiscountCode(String maGiamGia) {
        if (isKiemTraMaGiamGia()) {
            System.out.println("Bạn đã nhập mã giảm giá. Không thể nhập thêm mã khác.");
            return;
        }
        switch (maGiamGia) {
            case "CONGHAU10":
                phanTramGiamGia = 10;
                System.out.println("Mã giảm giá 10% đã được áp dụng.");
                break;
            case "CONGHAU20":
                phanTramGiamGia = 20;
                System.out.println("Mã giảm giá 20% đã được áp dụng.");
                break;
            default:
                System.out.println("Mã giảm giá không hợp lệ.");
                phanTramGiamGia = 0;
        }
        kiemTraMaGiamGia = true;
    }

    public double getTongGia() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTongGia();
        }
        if (phanTramGiamGia > 0) {
            total = total - (total * phanTramGiamGia / 100);
        }
        return total;
    }

    public void showCart() {
        if (items.isEmpty()) {
            System.out.println("Giỏ hàng trống.");
        } else {
            for (CartItem item : items) {
                System.out.println(item);
            }
            System.out.println("Tổng giá trị sau khuyến mãi " + (int)getPhanTramGiamGia() +"%: $" + getTongGia());
        }
    }
}

