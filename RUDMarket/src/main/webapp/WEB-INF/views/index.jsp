<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
  <div class="form">
    <form action="/catalogo/findAllSezioni" method="post">
      <table>
        <tr>
          <td><input type="submit" value="Visulizza Catalogo"></td>
        </tr>
      </table>
    </form>
  </div>
  <p>Go to <a href="/user">User</a></p>
  <p>Go to <a href="/admin">Admin</a></p>
  <p>Go to <a href="/register">Register</a></p>
</body>
</html>