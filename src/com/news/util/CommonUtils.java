/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.util;

import java.util.ResourceBundle;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author phamt_000
 */
public class CommonUtils {

    private static ResourceBundle rb = ResourceBundle.getBundle("config");

    public static String getConfig(String key) {
        try {
            return rb.getString(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encryptData(String password) {
        String result = null;
        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());

            byte byteData[] = md.digest();

            //convert the byte to hex format method 1
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            System.out.println("Hex format : " + sb.toString());

            //convert the byte to hex format method 2
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                String hex = Integer.toHexString(0xff & byteData[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
//            System.out.println("Hex format : " + hexString.toString());
            result = hexString.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
