package com.Controller.Admin;

import com.Dao.Dao;
import com.Model.Model;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AdminLogin", value="/AdminLogin")
public class AdminLogin extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AdminLogin() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessionAdmin = request.getSession();
        String action = request.getParameter("action");
        if (action == null) {
            request.getRequestDispatcher("adminPanel.jsp").forward(request, response);
        } else {
            if (action.equalsIgnoreCase("logout")) {
                sessionAdmin.removeAttribute("adminId");
                sessionAdmin.removeAttribute("adminName");
                response.sendRedirect("adminPanel.jsp");
            }
        }
    }

    @SuppressWarnings("static-access")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessionAdmin = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Assuming Dao and Model classes are used for database operations
        Dao dao = new Dao();
        Model model = new Model();
        model.setUserName(username);
        model.setPass(password);

        try {
            ResultSet rs = dao.adminValid(model);
            if (rs.next()) {
                sessionAdmin.setAttribute("adminId", rs.getInt("adminId"));
                sessionAdmin.setAttribute("adminName", rs.getString("username"));
                response.sendRedirect("adminPanel.jsp"); // Ensure this path is correct
            } else {
                request.setAttribute("message", "invalid");
                request.getRequestDispatcher("adminPanel.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
