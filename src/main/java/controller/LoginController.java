package controller;

import dao.AccountDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


public class LoginController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String username = request.getParameter("txtusername");
            String password = request.getParameter("txtpassword");

            boolean isValid = AccountDAO.checkLogin(username, password);

            if (isValid) {
                HttpSession session = request.getSession();
                session.setAttribute("tendangnhap", username);

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/admin/doctor/doctor-list.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/admin/home.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

}
