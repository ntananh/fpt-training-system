/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fts.models;

import fts.db.DBConnection;
import fts.entities.User;
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
public class UserModel {

    public List<User> getUsers() {
        List<User> list = new ArrayList<>();

        String sql = "SELECT * FROM tblUser";
        Connection conn = DBConnection.getConnection();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setFirstname(rs.getString(5));
                user.setLastname(rs.getString(6));
                user.setAvatar(rs.getString(7));
                user.setPhone(rs.getString(8));
                user.setDetail(rs.getString(9));
                user.setAddress(rs.getString(10));
                user.setRole_id(rs.getInt(11));
                user.setDob(rs.getDate(12));

                list.add(user);
            }

            // close resourses
            rs.close();
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    // id is roleid
    public List<User> getUsersByRole(int id) {
        List<User> users = new ArrayList();
        String sql = "SELECT * FROM tblUser Where _role_id = ?";
        Connection conn = DBConnection.getConnection();

        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setFirstname(rs.getString(5));
                user.setLastname(rs.getString(6));
                user.setAvatar(rs.getString(7));
                user.setPhone(rs.getString(8));
                user.setDetail(rs.getString(9));
                user.setAddress(rs.getString(10));
                user.setRole_id(rs.getInt(11));
                user.setDob(rs.getDate(12));

                users.add(user);
            }

            // close resourses
            rs.close();
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }

    
    
}
