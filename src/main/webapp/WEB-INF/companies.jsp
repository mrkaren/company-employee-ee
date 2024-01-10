<%@ page import="org.example.companyemployeeee.model.Company" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Companies</title>
    <link rel="stylesheet" href="/css/style.css">

</head>
<body>

<%
    List<Company> companies = (List<Company>) request.getAttribute("companies");
%>

Companies | <a href="/addCompany" >Add Company</a>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Address</th>
        <th>Delete</th>
    </tr>
    <%
        if (!companies.isEmpty()) {
            for (Company company : companies) { %>
        <tr>
            <td><%=company.getId()%></td>
            <td><a href="/singleCompany?id=<%=company.getId()%>"> <%=company.getName()%></a></td>
            <td><%=company.getAddress()%></td>
            <td> <a href="/deleteCompany?id=<%=company.getId()%>">delete</a> </td>
        </tr>
    <% }
    }
    %>
</table>
</body>
</html>
