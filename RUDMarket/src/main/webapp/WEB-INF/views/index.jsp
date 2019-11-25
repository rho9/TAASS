<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">

<title>RUDMarket</title>
</head>
<body>
  <h1>Questo è l'inizio di RUDMarket</h1>
  <hr>
  <security:authorize access="isAuthenticated()">
    <h1>Benvenuto <security:authentication property="principal.username" /></h1>
  </security:authorize>
  <security:authorize access="!isAuthenticated()">
    <h1>Benvenuto Ospite</h1>
  </security:authorize>
  <div class="form">
    <form action="/catalogo/findAllSezioni" method="post">
      <table>
        <tr>
          <td><input type="submit" value="Visulizza Catalogo"></td>
        </tr>
      </table>
    </form>
  </div>
  <security:authorize access="hasRole('ROLE_ADMIN')">
    <p>Go to <a href="/gestione/viewAdmin">Admin</a></p>
  </security:authorize>
  <security:authorize access="isAuthenticated()">
    <p><a href="/logout">Logout</a></p>
  </security:authorize>
  <security:authorize access="!isAuthenticated()">
    <p><a href="/login">Login</a></p>
  </security:authorize>
  <p>Go to <a href="/register/viewRegister">Register</a></p>
</body>
</html>