<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Please enter user name</title>
</head>
<body>
<% List uList = (ArrayList)request.getAttribute("utenti"); %>
<div>
    <form action="/gestione/upgradeRole" method="post">
        <fieldset>
            <legend>Gestire i ruoli</legend>
            <table>
                <tr>
                    <td>Utente:</td>
                    <td>
                        <select name="nomeUtente">
                            <%
                                for(int i = 0; i< uList.size(); i++){
                                    String user = (String) uList.get(i);
                            %>
                            <option value="<%= user %>"><%= user %></option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td><td><button type="submit" class="btn">Modifica</button></td>
                </tr>
            </table>
        </fieldset>
    </form>
    <p><a href="/">Home</a></p>
</div>
</body>
</html>

