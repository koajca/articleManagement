/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.core;

import com.news.util.CommonUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author phamt_000
 */
public class DBUtil {

    public static Connection getConnection() {
        try {
            
//            String url = "jdbc:ucanaccess://D:/article.accdb";
            String url = CommonUtils.getConfig("url.connection.database.access");
            return DriverManager.getConnection(url, "", "");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {

            Connection con = getConnection();
            PreparedStatement st = con.prepareStatement("select count(*) countDb from articles");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                System.out.println("result: " + rs.getLong("countDb"));
            }

            System.out.println("XXXXXXXXXXXXXXXXXXXXXX");
        } catch (Exception ex) {

            System.out.println("exception is" + ex);
        }
    }

}
