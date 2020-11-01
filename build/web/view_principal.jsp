<%@page import="Modelo.Emisor"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <link href="css/view_principal.css" rel="stylesheet" type="text/css"/>
        <link href='https://fonts.googleapis.com/css?family=Bad Script' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet'>
        <title>Sistema de Facturación</title>
    </head>
    <body>
        <%@include file="encabezado.jsp" %>
        <%
            Emisor emisor = (Emisor) request.getSession(false).getAttribute("emisor");
            if (emisor != null) {
        %>

        <h1>Bienvenido <%= emisor.getName()%> </h1>
        <% } else {
                response.sendRedirect(String.format("mensajes.jsp?msj=%s", "No ha iniciado sesión"));
            }%>

    </body>
</html >
