/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.dao;

import com.news.core.DBUtil;
import com.news.core.Employee;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author phamt_000
 */
public class UserDAO {

    public boolean authenticate(String userName, String password) {
        boolean result = false;
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = " SELECT count(*) FROM accounts WHERE user_name = ? AND password = ? and status = 1 ";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, userName);
            pstm.setString(2, password);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                result = rs.getLong(0) == 1;
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return result;
    }
}
