<%@page import="Modelo.Factura"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <link href="css/view_list_facturas.css" rel="stylesheet" type="text/css"/>
        <link href='https://fonts.googleapis.com/css?family=Bad Script' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet'>
        <title>Sistema de Facturacion</title>
    </head>
    <body>
        <%
            HttpSession s = request.getSession(false);
            if (s == null) {
                response.sendRedirect(String.format("mensajes.jsp?msj=%s", "No ha iniciado sesión"));
            }
        %>
        <%@include file="encabezado.jsp" %>
        <div id="div_main_listFac" class="div_centrado">
            <h1>Lista de facturas</h1>
            <div id="div_form">
                <jsp:useBean class="Model.List.ListFacturas" id="facturas" scope="session"></jsp:useBean>
                    <div id="div_tabla">
                        <table border="1" id="tabla_list_facturas">
                            <thead>
                                <tr>
                                    <th>Numero de factura</th>
                                    <th>Número de cédula</th>
                                    <th>Nombre del cliente</th>
                                    <th>Número de teléfono</th>
                                    <th>Cantidad de productos vendidos</th>
                                    <th>Total de la factura</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                                for (int i = 0; i < facturas.getFacturas().size(); i++) {
                                    Factura f = facturas.getFacturas().get(i);
                            %>
                            <tr>
                                <td>
                                    <%= f.getId()%>
                                </td>
                                <td>
                                    <%= f.getCliente().getDni()%>
                                </td>
                                <td><%= f.getCliente().getName()%></td>
                                <td><%= f.getCliente().getTelephone()%></td>
                                <td><%= f.getProductos().size()%></td>
                                <td><%= f.getTotal()%></td>
                                <td>
                                    <form action="Control_Fac_List" method="POST">
                                        <input type="submit" name="verPdf_<%= i%>" value="Ver PDF">										 
                                    </form>
                                </td>
                                <td>
                                    <form action="Control_XML" method="POST">
                                        <input type="submit" name="verXML_<%= i%>" value="Ver XML">
                                    </form>
                                </td> 
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </div>
                <a href="view_principal.jsp">Volver a la página principal</a>
            </div>
        </div>
    </body>
</html>
