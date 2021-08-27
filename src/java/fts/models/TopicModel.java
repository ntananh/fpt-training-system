/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fts.models;

import fts.db.DBConnection;
import fts.entities.Topic;
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
public class TopicModel {

 
    // get all topics in database
    public List<Topic> getTopics() {

        List<Topic> list = new ArrayList<>();

        String sql = "SELECT * FROM tblTopic";
        Connection conn = DBConnection.getConnection();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Topic topic = new Topic();
                topic.setId(rs.getInt(1));
                topic.setName(rs.getString(2));
                topic.setDescription(rs.getString(3));

                list.add(topic);
            }
            
            // close resourses
            rs.close();
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(TopicModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    // get topic by id 
    public Topic getTopicById(String id) {

        Topic topic = null;

        String sql = "SELECT * FROM tblTopic WHERE _id=?";
        Connection conn = DBConnection.getConnection();

        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                topic = new Topic();
                topic.setId(rs.getInt(1));
                topic.setName(rs.getString(2));
                topic.setDescription(rs.getString(3));
            }

            rs.close();
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(TopicModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return topic;
    }
   

//    public boolean addTopic(String id, String name, float price) {
//        int result = 0;
//        Connection conn = DBConnection.getConnection();
//
//        String sql = "INSERT INTO tblTopic VALUES (? , ?, ?)";
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
//            Logger.getLogger(TopicModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return result > 0;
//
//    }
//
//    public boolean delTopic(String id) {
//        int result = 0;
//        Connection conn = DBConnection.getConnection();
//
//        String sql = "DELETE FROM tblTopic WHERE _id=?";
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
//            Logger.getLogger(TopicModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return result > 0;
//
//    }
//

//
//    public boolean updateTopic(String id, String name, float price) {
//        int result = 0;
//        Connection conn = DBConnection.getConnection();
//
//        String sql = "UPDATE tblTopic SET _name=?, _price=? WHERE _id=?";
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
//            Logger.getLogger(TopicModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return result > 0;
//
//    }

}
