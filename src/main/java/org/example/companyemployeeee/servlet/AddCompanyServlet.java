package org.example.companyemployeeee.servlet;


import org.example.companyemployeeee.manager.CompanyManager;
import org.example.companyemployeeee.model.Company;
import org.example.companyemployeeee.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/companies/add")
public class AddCompanyServlet extends HttpServlet {

    private CompanyManager companyManager = new CompanyManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/addCompany.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        String companyName = req.getParameter("companyName");
        String companyAddress = req.getParameter("companyAddress");

        companyManager.add(Company.builder()
                .address(companyAddress)
                .name(companyName)
                        .user(user)
                .build());
        resp.sendRedirect("/companies");
    }
}
