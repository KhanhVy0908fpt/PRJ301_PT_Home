/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.TodoDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Todo;

/**
 *
 * @author Admin
 */
@WebServlet(name = "EditServlet", urlPatterns = {"/edit"})
public class EditServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //processRequest(request, response);

            // lay id tu request(trang list)
            int id = Integer.parseInt(request.getParameter("id"));
            // tao 1 doi tuong todoDAO de lay doi tuong co id = ? tu database dan vao cho todo
            TodoDAO todoDAO = new TodoDAO();
            Todo todo = todoDAO.getById(id);

            // Gui todo sang cho JSP de hien thi len form
            request.setAttribute("todo", todo);

            // Tao mot doi tuong chuyen tiep tai nguyen (JSP)
            RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
            // Chuyen yeu cau hien tai den tai nguyen khac
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            boolean status = request.getParameter("status") != null;
            // checkbox duoc tich thi status true, khong duoc tich thi status false
            Todo todo = new Todo(id, title, status);
            TodoDAO todoDAO = new TodoDAO();
            todoDAO.update(todo);
            
            response.sendRedirect("list");
        } catch (SQLException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
