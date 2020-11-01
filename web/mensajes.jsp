
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <link href="css/view_singin.css" rel="stylesheet" type="text/css"/>
        <link href='https://fonts.googleapis.com/css?family=Bad Script' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet'>
        <title>Sistema de Facturación</title>        
    </head>
    <body>
        <%
            String msj = request.getParameter("msj");
            String link = request.getParameter("link");
            if (link == null || link.isEmpty()) {
                link = "index.jsp";
            }
        %>
        <h1> <%=msj%></h1>
        <a href="<%= link%>">Volver al inicio</a>
    </body>
</html>
