<%@ page import="org.example.companyemployeeee.model.Company" %>
<%@ page import="org.example.companyemployeeee.model.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: karen
  Date: 10.01.24
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Company company = (Company) request.getAttribute("company");%>
<%List<Employee> employeeList = (List<Employee>) request.getAttribute("employees");%>
<html>
<head>
    <title><%=company.getName()%>
    </title>
</head>
<body>

<h2><%=company.getName()%> | <%=company.getId()%>
</h2>
Address: <span><%=company.getAddress()%></span>
Employees:

<%
    if (employeeList != null && !employeeList.isEmpty()) { %>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
    </tr>
    <%
        for (Employee employee : employeeList) { %>
    <tr>
        <td><%=employee.getId()%>
        </td>
        <td><%=employee.getName()%>
        </td>
        <td><%=employee.getSurname()%>
        </td>
        <td><%=employee.getEmail()%>
        </td>
    </tr>
    <% }
    %>
</table>
<%}%>
</body>
</html>
