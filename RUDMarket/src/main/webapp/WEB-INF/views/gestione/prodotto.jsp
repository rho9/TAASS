<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="it.rud.rudmarket.model.Sezione" %>
<html>
<head>
    <title>Please enter product</title>
</head>
<body>
<% List cList = (ArrayList)request.getAttribute("sezioni"); %>
<div>
    <form action="/gestione/doAddProdotto" method="post">
        <fieldset>
            <legend>Effettuare la Registrazione</legend>
            <table>
                <tr>
                    <td>Nome:</td><td><input type="text" name="nomeProdotto"/></td>
                </tr>
                <tr>
                    <td>Sezione:</td>
                    <td>
                        <select name="nomeSezione">
                            <%
                                for(int i = 0; i< cList.size(); i++){
                                	Sezione sezione = (Sezione) cList.get(i);
                            %>
                                <option value="<%= sezione.getNome() %>"><%= sezione.getNome() %></option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td><td><button type="submit" class="btn">Aggiungi</button></td>
                </tr>
            </table>
        </fieldset>
    </form>
    <p><a href="/">Home</a></p>
</div>
</body>
</html>

