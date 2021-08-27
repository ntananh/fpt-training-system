/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fts.models;

import fts.db.DBConnection;
import fts.entities.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tan Anh
 */
public class CategoryModel {

    public List<Category> getCategorys() {

        List<Category> list = new ArrayList<>();

        String sql = "SELECT * FROM tblCategory";
        Connection conn = DBConnection.getConnection();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt(1));
                category.setName(rs.getString(2));
                category.setDescription(rs.getString(3));

                list.add(category);
            }

            // close resourses
            rs.close();
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryModel.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return list;
    }

    public Category getCategoryById(String id) {

        Category category = null;

        String sql = "SELECT * FROM tblCategory WHERE _id=?";
        Connection conn = DBConnection.getConnection();

        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                category = new Category();
                category.setId(rs.getInt(1));
                category.setName(rs.getString(2));
                category.setDescription(rs.getString(3));
            }

            rs.close();
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(CategoryModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return category;
    }

//    public boolean addCategory(String id, String name, float price) {
//        int result = 0;
//        Connection conn = DBConnection.getConnection();
//
//        String sql = "INSERT INTO tblCategory VALUES (? , ?, ?)";
//        try {
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, id);
//            statement.setString(2, name);
//            statement.setFloat(3, price);
//
//            result = statement.executeUpdate();
//
//            statement.close();
//            conn.close();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(CategoryModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return result > 0;
//
//    }
//
//    public boolean delCategory(String id) {
//        int result = 0;
//        Connection conn = DBConnection.getConnection();
//
//        String sql = "DELETE FROM tblCategory WHERE _id=?";
//        try {
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, id);
//
//            result = statement.executeUpdate();
//
//            statement.close();
//            conn.close();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(CategoryModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return result > 0;
//
//    }
//
//    public Category getCategoryById(String id) {
//
//        Category c = null;
//
//        String sql = "SELECT * FROM tblCategory WHERE _id=?";
//        Connection conn = DBConnection.getConnection();
//
//        try {
//            PreparedStatement st = conn.prepareStatement(sql);
//            st.setString(1, id);
//
//            ResultSet rs = st.executeQuery();
//
//            while (rs.next()) {
//                c = new Category();
//                c.setId(rs.getString(1));
//                c.setName(rs.getString(2));
//                c.setPrice(rs.getFloat(3));
//            }
//
//            rs.close();
//            st.close();
//            conn.close();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(CategoryModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return c;
//    }
//
//    public boolean updateCategory(String id, String name, float price) {
//        int result = 0;
//        Connection conn = DBConnection.getConnection();
//
//        String sql = "UPDATE tblCategory SET _name=?, _price=? WHERE _id=?";
//        try {
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, name);
//            statement.setFloat(2, price);
//            statement.setString(3, id);
//
//            result = statement.executeUpdate();
//
//            statement.close();
//            conn.close();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(CategoryModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return result > 0;
//
//    }
}
