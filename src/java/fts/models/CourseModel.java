/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fts.models;

import fts.db.DBConnection;
import fts.entities.Course;
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
public class CourseModel {

    public List<Course> getCourses() {

        List<Course> list = new ArrayList<>();

        String sql = "SELECT * FROM tblCourse";
        Connection conn = DBConnection.getConnection();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getInt(1));
                course.setName(rs.getString(2));
                course.setThumbnail(rs.getString(3));
                course.setStart_date(rs.getDate(4));
                course.setEnd_date(rs.getDate(5));
                course.setCreated_date(rs.getDate(6));

                course.setContent(rs.getString(7));
                course.setDescription(rs.getString(8));
                course.setEnroll_code(rs.getString(9));
                course.setCate_id(rs.getInt(10));
                course.setTopic_id(rs.getInt(11));

                list.add(course);
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

    public boolean addCourse(String name, String start_date, String end_date, String created_date, String description, int cate_id, int topic_id) {
        int result = 0;
        Connection conn = DBConnection.getConnection();

        String sql = "INSERT INTO tblCourse ("
                + "_name,"
                + "_start_date,"
                + "_end_date,"
                + "_course_created_date, "
                + "_description, "
                + "_category_id, "
                + "_topic_id) VALUES"
                + "(?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, start_date);
            statement.setString(3, end_date);
            statement.setString(4, created_date);
            statement.setString(5, description);
            statement.setInt(6, cate_id);
            statement.setInt(7, topic_id);

            result = statement.executeUpdate();

            statement.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result > 0;

    }

    public boolean updateCourse(int id, String name, String start_date, String end_date, String description, int cate_id, int topic_id) {
        int result = 0;
        
        Connection conn = DBConnection.getConnection();

        String sql = "UPDATE tblCourse SET _name=?, _start_date=?, _end_date=?, _description=?, _topic_id=?, _category_id=? WHERE _id=?;";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, start_date);
            statement.setString(3, end_date);
            statement.setString(4, description);
            statement.setInt(5, cate_id);
            statement.setInt(6, topic_id);
            statement.setInt(7, id);

            result = statement.executeUpdate();

            statement.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result > 0;

    }

    public Course getCourseById(int id) {
        
        Course course = null;
        
        String sql = "SELECT * FROM tblCourse WHERE _id = ?";
        Connection conn = DBConnection.getConnection();
        
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {                
                course = new Course();
                course.setId(rs.getInt(1));
                course.setName(rs.getString(2));
                course.setStart_date(rs.getDate("_start_date"));
                course.setEnd_date(rs.getDate("_end_date"));
                course.setDescription(rs.getString("_description"));
                course.setCate_id(rs.getInt("_category_id"));
                course.setTopic_id(rs.getInt("_topic_id"));
            }
            
            rs.close();
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return course;
    }
    
    public boolean delCourse(int id) {
        int result = 0;
        Connection conn = DBConnection.getConnection();

        String sql = "DELETE FROM tblCourse WHERE _id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            result = statement.executeUpdate();

            statement.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(CourseModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result > 0;
    }
}
