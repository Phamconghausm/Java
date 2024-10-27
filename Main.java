package com.project.XayDungGioHang;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        SanPham product1 = new SanPhamDienTu("Laptop", 2000.00);
        SanPham product2 = new SanPhamDienTu("Smartphone", 1000.00);
        SanPham product3 = new SanPhamQuanAo("T-Shirt", 30.00);
        SanPham product4 = new SanPhamQuanAo("Shirt", 20.00);
        boolean running = true;
        while (running) {
            System.out.println("\n1. Thêm sản phẩm vào giỏ hàng");
            System.out.println("2. Xóa sản phẩm khỏi giỏ hàng");
            System.out.println("3. Cập nhật số lượng sản phẩm");
            System.out.println("4. Áp dụng mã khuyến mãi");
            System.out.println("5. Hiển thị giỏ hàng");
            System.out.println("6. Thoát");

            System.out.print("Chọn một tùy chọn: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Chọn sản phẩm:");
                    System.out.println("1. Laptop - $2000");
                    System.out.println("2. Smartphone - $1000");
                    System.out.println("3. T-Shirt - $30");
                    System.out.println("4. Shirt - $20");

                    System.out.println("Nhập lựa chọn của bạn: ");
                    int productChoice = scanner.nextInt();
                    System.out.print("Nhập số lượng: ");
                    int quantity = scanner.nextInt();

                    if (productChoice == 1) {
                        cart.addProduct(product1, quantity);
                    } else if (productChoice == 2) {
                        cart.addProduct(product2, quantity);
                    } else if (productChoice == 3) {
                        cart.addProduct(product3, quantity);
                    } else if (productChoice == 4) {
                        cart.addProduct(product4, quantity);
                    } else {
                        System.out.println("Sản phẩm không hợp lệ.");
                    }
                    break;

                case 2:
                    System.out.print("Nhập tên sản phẩm cần xóa: ");
                    String productNameToRemove = scanner.next();
                    cart.removeProduct(productNameToRemove);
                    break;

                case 3:
                    System.out.print("Nhập tên sản phẩm cần cập nhật số lượng: ");
                    String productNameToUpdate = scanner.next();
                    System.out.print("Nhập số lượng mới: ");
                    int newQuantity = scanner.nextInt();
                    cart.updateProductQuantity(productNameToUpdate, newQuantity);
                    break;

                case 4:
                    System.out.print("Nhập mã khuyến mãi (CONGHAU10 hoặc CONGHAU20): ");
                    String discountCode = scanner.next();
                    cart.applyDiscountCode(discountCode);
                    break;

                case 5:
                    cart.showCart();
                    break;

                case 6:
                    running = false;
                    break;

                default:
                    System.out.println("Tùy chọn không hợp lệ.");
            }
        }

        scanner.close();
    }
}

