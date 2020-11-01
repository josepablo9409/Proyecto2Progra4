<%@page import="Modelo.ListProduct"%>
<%@page import="Model.List.List_category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <link href="css/view_fact_prod.css" rel="stylesheet" type="text/css"/>
        <link href='https://fonts.googleapis.com/css?family=Bad Script' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet'>
        <title>Sistema de Facturación</title>

    </head>
    <body>
        <%@include file="encabezado.jsp" %>
        <div class="div_centrado">
            <h1>Facturacion de producto</h1>
            <div id="div_principal">
                <div id=div_table">
                    <form action="Control_Fac_P" method="POST">
                        <jsp:useBean class="Modelo.ListProduct" id="productos" scope="session"></jsp:useBean>                
                            <table border="1">
                                <thead>
                                    <tr>
                                        <th>Categoria</th>
                                        <th>Descripción</th>
                                        <th>Precio</th>
                                        <th>I.V.A.</th>
                                        <th>Cantidad(unidades)</th>
                                        <th></th>									
                                    </tr>
                                </thead>
                                <tbody>
                                <%
                                    for (int i = 0; i < productos.size(); i++) {
                                %>
                                <tr>
                                    <td><%= productos.get(i).getCategory().getDescripcion()%></td>
                                    <td><%= productos.get(i).getDetail()%></td>
                                    <td><%= productos.get(i).getPrice()%></td>									
                                    <td><%= productos.get(i).getCategory().getIva() * 100%>%</td>
                                    <td><input name="cantidad_<%= i%>" type="number" min="0" step="1"></td>
                                    <td><input name="btnAdd_<%= i%>" type="submit" value="Agregar"></td>
                                </tr>
                                <% }%>							 
                            </tbody>
                        </table>
                    </form>
                </div>
                <form action="Control_Facturar" method="GET">
                    <input type="submit" name="btn_next" value="Total">
                </form>
                <a href="view_principal.jsp">Volver al inicio</a>
            </div>
        </div>
    </body>
</html>
