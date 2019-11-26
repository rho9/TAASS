<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="it.rud.rudmarket.model.Sezione" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>RUDMarket</title>
</head>
<body>
<h1>Questo è l'inizio di RUDMarket</h1>
<hr>


<% List cList = (ArrayList)request.getAttribute("list"); %>
....
<table>
    <%
        for(int i = 0; i< cList.size(); i++){%>
    <tr>
        <td><%= ((Sezione) cList.get(i)).getNomeSezione() %></td>
    </tr>
    <%}%>
</table>
<a href="/">Home</a>
</body>
</html>