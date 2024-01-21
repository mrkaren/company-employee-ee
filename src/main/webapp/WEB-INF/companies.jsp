<%@ page import="org.example.companyemployeeee.model.Company" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Companies</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.min.css">


</head>
<body>

<%
    List<Company> companies = (List<Company>) request.getAttribute("companies");
%>

Companies | <a href="/companies/add">Add Company</a>

<div style="width: 800px;">
    <table id="companiesTable" style="width: 100%">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>User added</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>
        </thead>
        <%
            if (!companies.isEmpty()) {
                for (Company company : companies) { %>
        <tbody>
        <tr>
            <td><%=company.getId()%>
            </td>
            <td><a href="/singleCompany?id=<%=company.getId()%>"><%=company.getName()%>
            </a></td>
            <td><%=company.getAddress()%>
            </td>
            <td>
                <% if (company.getUser() != null) { %>
                <%=company.getUser().getName() + " " + company.getUser().getSurname()%>
                <%}%>
            </td>
            <td><a href="/deleteCompany?id=<%=company.getId()%>">delete</a></td>
            <td><a href="/updateCompany?id=<%=company.getId()%>">Update</a></td>
        </tr>
        </tbody>
        <% }
        }
        %>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>
<script>
    var table = $('#companiesTable').DataTable();


    // #myInput is a <input type="text"> element
    $('#companiesTable_filter').find('input').on( 'keyup', function () {
        table.search( this.value ).draw();
    } );
</script>
</body>
</html>
