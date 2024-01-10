package org.example.companyemployeeee.servlet;


import org.example.companyemployeeee.manager.CompanyManager;
import org.example.companyemployeeee.manager.EmployeeManager;
import org.example.companyemployeeee.model.Company;
import org.example.companyemployeeee.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/addEmployee")
public class AddEmployeeServlet extends HttpServlet {

    private CompanyManager companyManager = new CompanyManager();
    private EmployeeManager employeeManager = new EmployeeManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Company> companies = companyManager.getCompanies();
        req.setAttribute("companies", companies);
        req.getRequestDispatcher("/WEB-INF/addEmployee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        int companyId = Integer.parseInt(req.getParameter("companyId"));
        employeeManager.add(Employee.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .company(companyManager.getCompanyById(companyId))
                .build());
        resp.sendRedirect("/employees");
    }
}
