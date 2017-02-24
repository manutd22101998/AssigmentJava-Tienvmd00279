/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.java.view;

import assignment.java.controller.UserController;
import assignment.java.demo.DAO;
import assignment.java.model.UserModel;
import assignment.java.utility.ScannerUtil;
import java.util.Scanner;

/**
 *
 * @author daolinh
 */
public class ConsoleMenu {

    public static void main(String[] args) {
        printMenu();
    }

    static void printMenu() {
        while (true) {
            // Local variable
            int choice;
            // Display menu graphics
            System.out.println("=====================================================");
            System.out.println("|               Phần mềm quản lý sinh viên          |");
            System.out.println("=====================================================");
            System.out.println("|   **********         Lựa chọn:        **********  |");
            System.out.println("|               1. Danh sách sinh viên.             |");
            System.out.println("|               2. Thêm mới sinh viên.              |");
            System.out.println("|               3. Sửa thông tin sinh viên.         |");
            System.out.println("|               4. Xoá sinh viên.                   |");
            System.out.println("|               5. Tìm kiếm sinh viên.              |");
            System.out.println("|               6. Thoát chương trình               |");
            System.out.println("=====================================================");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = ScannerUtil.getInt();

            // Switch construct
            switch (choice) {
                case 1:
                    UserModel.viewList();
//                    UserModel.viewList();
//                    System.out.println("Hiển thị danh sách sinh viên.");
                    break;
                case 2:
                    UserModel.create();
//                    UserController.processInsert();
                    break;
                case 3:
                    UserModel.insert();
                    break;
                case 4:
                    UserModel.delete();
                    break;
                case 5:
                    UserModel.search();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Lựa chọn sai. Vui lòng lựa chọn trong khoảng từ 1 đến 6.");
                    break; // This break is not really necessary
            }
            if (choice == 6) {
                break;
            }
        }
    }
}
