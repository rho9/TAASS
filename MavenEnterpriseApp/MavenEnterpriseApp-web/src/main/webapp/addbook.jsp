<%-- 
    Document   : addbook
    Created on : Sep 8, 2014, 2:58:38 PM
    Author     : giovanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="include/css/bootstrap.min.css">

        <style>
            body {
                padding-top: 50px;
                padding-bottom: 20px;
            }
        </style>
        <link rel="stylesheet" href="include/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="include/css/main.css">
      
        <script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
     
    </head>
    <body>
        <%@ include file="header2.jsp" %>
        <div class="bs-example">
            <h2>Inserisci libro</h2>
            <form class="form-horizontal" action="BookServlet" >

                <div class="form-group">
                    <label class="control-label col-xs-3" for="Titolo">Titolo:</label>
                    <div class="col-xs-9">
                        <input type="text" class="form-control" id="titolo" placeholder="Titolo" name="titolo">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-3" for="Autore">Autore:</label>
                    <div class="col-xs-9">
                        <input type="hidden" name="action" value="reg">
                        <input type="text" class="form-control" id="autore" placeholder="Autore" name="autore">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-offset-3 col-xs-9">
                        <input type="submit" class="btn btn-primary" value="Submit" >
                        <input type="reset" class="btn btn-default" value="Reset">
                    </div>
                </div>
            </form>
        </div>
    <%@ include file="footer.jsp" %>
    </body>
</html>
