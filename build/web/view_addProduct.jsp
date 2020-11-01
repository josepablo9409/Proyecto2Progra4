<%@page import="Model.List.List_category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <link href="css/view_addProduct.css" rel="stylesheet" type="text/css"/>
        <link href='https://fonts.googleapis.com/css?family=Bad Script' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet'>
        <title>Sistema de Facturación</title>
    </head>
    <body>
        <%@include file="encabezado.jsp" %>
        <div class="div_centrado">
            <h1>Agregar Producto</h1>
            <div id="div_main_addP">
                <form action="Control_AddProduct" method="POST">
                    <%
                        HttpSession s = request.getSession(false);
                        if (s != null) {
                            List_category lista = (List_category) s.getAttribute("categories");
                    %>
                    <select name="category">                
                        <option value="-1">Categoria</option>
                        <%
                            for (int i = 0; i < lista.size(); i++) {
                                int d = (int) (lista.get(i).getIva() * 100);
                        %>
                        <option value="<%= i%>">
                            <%= String.format("%1$s\tIVA: %2$d%3$s",
                                    lista.get(i).getDescripcion(), d, "%")%>
                        </option>
                        <% }
                            } else {
                                response.sendRedirect(String.format("mensajes.jsp?msj=%s", "No ha iniciado sesión"));
                            }
                        %>
                    </select>
                    <label for="txt_detail">Detalle del producto: </label>                    
                    <input type="text" id="txt_detail" name="detail">
                    <br>
                    <label for="txt_price">Precio: </label>
                    <input type="number" id="txt_price" min="1" name="price">
                    <br>
                    <input type="submit" name="bnt_addProduct" value="Agregar Producto">
                    <a href="view_principal.jsp">Volver a la página principal</a>
                </form>
            </div>
        </div>
    </body>
</html>
