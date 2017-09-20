/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.ui;

/**
 *
 * @author phamt_000
 */
public class Main {

    public static void main(String[] args) {
        try {
            LoginFrame guiMain = new LoginFrame();
//            MainFrame guiMain = new MainFrame();
//            UpdateArticle guiMain = new UpdateArticle();
            

            guiMain.setVisible(true);
            guiMain.setTitle("Đăng nhập hệ thống");
//            guiMain.setTitle("Hệ thống quản lý tin bài");
//            guiMain.setTitle("Cập nhật tin bài");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
