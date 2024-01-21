package org.example.companyemployeeee.filter;


import org.example.companyemployeeee.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "filter1", urlPatterns = {
        "/home", "/companies", "/employees",
        "/addCompany", "/addEmployee", "/deleteCompany",
        "/deleteEmployee", "/logout", "/singleCompany", "/updateCompany"
})

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AuthFilter created!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect("/");
        }

    }

    @Override
    public void destroy() {
        System.out.println("AuthFilter destroyed!");

    }
}
