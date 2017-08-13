package com.news.core;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBTest {

    public static void main(String[] args) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:odbc:article");
            Statement st = conn.createStatement();
            String sql = "Select * from articles";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println("\n" + rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
