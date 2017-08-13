/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.news.dao;

import com.news.core.ArticleBO;
import com.news.core.DBUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phamt_000
 */
public class ArticleDAO {

    public static void insert(String title, String shortContent, String content, Long accountId) {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = " INSERT INTO articles (title, short_content, status, create_time, update_time, content, account_id)"
                    + "  VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, title);
            pstm.setString(2, shortContent);
            pstm.setInt(3, 0);
            pstm.setDate(4, new Date((new java.util.Date()).getTime()));
            pstm.setDate(5, new Date((new java.util.Date()).getTime()));
            pstm.setString(6, content);
            pstm.setLong(7, accountId);

            pstm.execute();

            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
    }

    public static void delete(Long id) {
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = " DELETE articles WHERE ID = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setLong(1, id);

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);

        }
    }

    public static List getAllArticle() {
        Connection conn = null;
        List result = null;
        try {
            result = new ArrayList();
            conn = DBUtil.getConnection();

            String sql = "SELECT art.id, art.title, art.short_content, art.status, art.create_time, art.update_time, art.content,"
                    + " art.account_id, acc.username "
                    + " FROM articles art, accounts acc "
                    + " WHERE art.account_id = acc.id "
                    + " ORDER BY art.create_time DESC ";
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                ArticleBO bo = new ArticleBO();
                bo.setId(rs.getLong(1));
                bo.setTitle(rs.getString(2));
                bo.setShortContent(rs.getString(2));
                bo.setStatus(rs.getInt(4));
                bo.setCreateTime(rs.getDate(5));
                bo.setUpdateTime(rs.getDate(6));
                bo.setContent(rs.getString(7));
                bo.setAccountId(rs.getLong(8));
                bo.setAccountName(rs.getString(9));

                result.add(bo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return result;
    }
}
