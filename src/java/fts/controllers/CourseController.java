/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fts.controllers;

import fts.entities.Category;
import fts.entities.Course;
import fts.entities.Topic;
import fts.models.CategoryModel;
import fts.models.CourseModel;
import fts.models.TopicModel;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tan Anh
 */
public class CourseController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("ac");
        String id = request.getParameter("id");

        switch (action) {
            case "view": {
                viewAllCourses(request, response);
                break;
            }
            case "add": {
                addCourse(request, response);
                break;
            }
            case "save": {
                saveCourse(request, response);
                break;
            }
            case "edit": {
                editCourse(request, response, id);
                break;
            }
            case "update": {
                updateCourse(request, response, id);
                break;
            }
            case "delete": {
                deleteCourse(request, response, id);
                break;
            }
        }
    }

    public static void viewAllCourses(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CourseModel courseModel = new CourseModel();
        TopicModel topicModel = new TopicModel();
        CategoryModel cateModel = new CategoryModel();

        List<Course> listCourse = courseModel.getCourses();
        List<Topic> listTopic = topicModel.getTopics();
        List<Category> listCate = cateModel.getCategorys();

        request.setAttribute("courses", listCourse);
        request.setAttribute("topics", listTopic);
        request.setAttribute("cates", listCate);

        RequestDispatcher dispatcher = request.getRequestDispatcher("course.jsp");
        dispatcher.forward(request, response);
    }

    // Action add new course
    public static void addCourse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TopicModel topicModel = new TopicModel();
        CategoryModel cateModel = new CategoryModel();

        List<Topic> listTopic = topicModel.getTopics();
        List<Category> listCate = cateModel.getCategorys();

        request.setAttribute("topics", listTopic);
        request.setAttribute("cates", listCate);
        RequestDispatcher dispatcher = request.getRequestDispatcher("addCourse.jsp");
        dispatcher.forward(request, response);
    }

    public static void saveCourse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String name = request.getParameter("name");
        int topic_id = Integer.parseInt(request.getParameter("topic_id"));
        int cate_id = Integer.parseInt(request.getParameter("cate_id"));
        String start_date = request.getParameter("start_date");
        String end_date = request.getParameter("end_date");
        String created_date = dateFormat.format(new Date());
        String description = request.getParameter("description");

        CourseModel cm = new CourseModel();
        if (cm.addCourse(name, start_date, end_date, created_date, description, topic_id, cate_id)) {
            response.sendRedirect("course.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }

    }

    // Action edit course
    public static void editCourse(HttpServletRequest request, HttpServletResponse response, String id)
            throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("id"));
        TopicModel topicModel = new TopicModel();
        CategoryModel cateModel = new CategoryModel();
        CourseModel courseModel = new CourseModel();

        Course course = courseModel.getCourseById(cid);
        List<Topic> listTopic = topicModel.getTopics();
        List<Category> listCate = cateModel.getCategorys();

        request.setAttribute("course", course);
        request.setAttribute("topics", listTopic);
        request.setAttribute("cates", listCate);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editCourse.jsp");
        dispatcher.forward(request, response);
    }

    public static void updateCourse(HttpServletRequest request, HttpServletResponse response, String id)
            throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("id")); 
        String name = request.getParameter("name");
        int topic_id = Integer.parseInt(request.getParameter("topic_id"));
        int cate_id = Integer.parseInt(request.getParameter("cate_id"));
        String start_date = request.getParameter("start_date");
        String end_date = request.getParameter("end_date");
        String description = request.getParameter("description");

        CourseModel cm = new CourseModel();
        if (cm.updateCourse(cid, name, start_date, end_date, description, topic_id, cate_id)) {
            response.sendRedirect("course.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }

    }

    public static void deleteCourse(HttpServletRequest request, HttpServletResponse response, String id)
            throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("id"));
        
        CourseModel courseModel = new CourseModel();
        if (courseModel.delCourse(cid)) {
            response.sendRedirect("course.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
