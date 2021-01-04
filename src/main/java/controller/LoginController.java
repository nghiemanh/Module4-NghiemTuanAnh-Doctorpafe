package controller;

import dao.AccountDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/login-controller"})
public class LoginController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

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
        } catch (SQLException | ServletException e) {
            e.printStackTrace();
        }
    }

}
