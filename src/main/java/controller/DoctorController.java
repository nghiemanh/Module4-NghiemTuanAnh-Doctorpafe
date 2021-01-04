package controller;

import dao.DoctorDAO;
import model.DoctorModel;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-doctor"})
public class DoctorController extends HttpServlet {

    @Inject
    private DoctorDAO doctorDAO;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DoctorModel> listDoctor = doctorDAO.selectAllDoctor();
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/doctor/doctor-list.jsp");
        rd.forward(req, resp);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<DoctorModel> listUser = doctorDAO.selectAllDoctor();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/doctor/doctor-list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

