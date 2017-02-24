/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.java.model;

import assignment.java.demo.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Nahut Family
 */
public class UserModel {

    private static String id = "";
    private static String name = "";

    public static void viewList() {
//        System.out.println("Bat dau ket noi ...");
//        Connection conn;
//        String sql = "";
//
//        try {
//            conn = DAO.connectNow();
//            System.out.println("Ket noi thanh cong " + conn);
//            Statement stm = conn.createStatement();
//            stm.execute(sql);
//            ResultSet rs = stm.executeQuery("SELECT * FROM assignment_vuminhtien");
//            while (rs.next()) {
//                String id = rs.getString("id");
//                String name = rs.getString("name");
//                System.out.println(id + " " + name);
//            }
//        } catch (Exception e) {
//            System.err.println("Khong the ket noi DB" + e.getMessage());
//        }
//        System.out.println("Hiển thị danh sách sinh viên");

        String sql = "SELECT * FROM assignment_vuminhtien";
        String leftAlignFormat = "| %-5s | %-35s |%n";
        System.out.println("Hiển thị danh sách sinh viên");
        System.out.format("+-----------------+-------------------------------------+%n");
        System.out.format(leftAlignFormat, "ID", "Name");
        System.out.format("+-----------------+-------------------------------------+%n");
        try {
            Statement stm = DAO.createStm();

            ResultSet viewList = stm.executeQuery(sql);
            while (viewList.next()) {
                String id = viewList.getString("ID");
                String name = viewList.getString("Name");
//                String userName = viewList.getString("Username");
//                String password = viewList.getString("Password");
                System.out.format(leftAlignFormat, id, name);
            }
        } catch (SQLException ex) {
            System.err.println("\nCannot view list !!!");
        }
        System.out.format("+-----------------+-------------------------------------+%n");
    }

    public static void create() {
        Connection conn;
        try {
            conn = DAO.connect();
            Statement statement = conn.createStatement();
            String id = "";
            String name = "";
            System.out.println("Thêm mới ID: ");
            id = new Scanner(System.in).next();
            System.out.println("Thêm mới Name: ");
            name = new Scanner(System.in).next();
            statement.execute("INSERT INTO assignment_vuminhtien(id, name)" + "VALUES ('" + id + "', '" + name + "')");
            System.out.println("Thêm mới thành công: ");
            System.out.println("ID:  " + id);
            System.out.println("name:  " + name);

        } catch (SQLException e) {
            System.out.println("Thêm mới không thành công." + e.getMessage());

        }
    }

    public static void insert() {
//        System.out.println("Sửa thông tin sinh viên");
//        sql = "INSERT INTO assignment_vuminhtien (id,name) VALUES ('" + user.getid() + "','" + user.getName() + "')";
//        try {
//            Statement stm = DAO.createStm();
//
//            //Validate username and password
//            ResultSet validate = stm.executeQuery("SELECT * FROM assignment_vuminhtien WHERE Username = '" + user.getName() + "'");
//
//            if (validate.next() == true) {
//                System.err.println("Sorry ,usename already exists !!!");
//            } else {
//                stm.execute(sql);
//                System.out.println("\nCreate successful !!!");
//            }
//        } catch (SQLException e) {
//            System.err.println("\nError while creating !!!");
//        }
//    }

        Connection conn;
        String id = "";
        String name = "";
        try {
            conn = DAO.connect();
            Statement statement = conn.createStatement();

            System.out.println("Nhập ID bạn muốn sửa: ");
            id = new Scanner(System.in).next();
            System.out.println("Nhập tên mới: ");
            name = new Scanner(System.in).next();
            statement.execute("UPDATE assignment_vuminhtien SET name ='" + name + "' WHERE id = '" + id + "'");

            System.out.println("Success, u have update a student: ");
            System.out.println("id:  " + id);
            System.out.println("name:  " + name);

        } catch (SQLException e) {
            System.out.println("Sửa thông tin không thành công." + e.getMessage());

        }
    }

    public static void delete() {
        Connection conn;
        
        try {
            conn = DAO.connect();
            Statement statement = conn.createStatement();
            String id = "";
            String name = "";
            System.out.println("Nhập ID ban muốn xóa: ");
            id = new Scanner(System.in).next();
            statement.execute("DELETE FROM assignment_vuminhtien " + "WHERE id = '" + id + "'");
            System.out.println("Bạn đã xóa thông tin thành công.");
            System.out.println("id:  " + id);
            System.out.println("name:  " + name);

        } catch (SQLException e) {
            System.out.println("Xóa thông tin không thành công." + e.getMessage());

        }

    }

    public static void search() {
        System.out.println("Tìm thông tin sinh viên");
        Connection conn;
        String sql = "";
        String id = "";
        String name = "";
        try {
            conn = DAO.connect();
            System.out.println("Kết nối thành công" + conn);
            Statement statement = conn.createStatement();
             System.out.println("Nhập ID bạn muốn tìm kiếm: ");
            id = new Scanner(System.in).next();
            sql = "SELECT * FROM assignment_vuminhtien WHERE id = '" + id + "'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                id = rs.getString("id");
                name = rs.getString("name");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
            }

        } catch (SQLException e) {
            System.out.println("Tìm kiếm thất bại." + e.getMessage());

        }
    }

}

