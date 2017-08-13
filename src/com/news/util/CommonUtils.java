/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.util;

import java.util.ResourceBundle;

/**
 *
 * @author phamt_000
 */
public class CommonUtils {

    private static ResourceBundle rb = ResourceBundle.getBundle("/config.properties");

    public static String getConfig(String key) {
        try {
            return rb.getString(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
