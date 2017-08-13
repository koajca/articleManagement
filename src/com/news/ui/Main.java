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
            MainFrame guiMain = new MainFrame();

            guiMain.setVisible(true);
            guiMain.setTitle("Quản lý bài viết");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
