<%@page import="java.util.List"%>
<%@page import="Modelo.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <link href="css/view_list_client.css" rel="stylesheet" type="text/css"/>
        <link href='https://fonts.googleapis.com/css?family=Bad Script' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet'>
        <title>Sistema de Facturación</title>
    </head>
    <body>
        <%@include file="encabezado.jsp" %>
        <%
            HttpSession s = request.getSession(false);
            if (s == null) {
                response.sendRedirect(String.format("mensajes.jsp?msj=%s", "No ha iniciado sesión"));
            }
        %>
        <div id="div_principal">
            <h1>Lista de clientes</h1>
            <div id="div_listC">  
                <form action="Control_Fac_C" method="GET">
                    <div id=div_table">
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>Tipo de identificación</th>
                                    <th>Número de cédula</th>
                                    <th>Nombre completo</th>
                                    <th>Número de teléfono</th>
                                    <th>E-Mail</th>
                                    <th>Provincia</th>
                                    <th>Cantón</th>
                                    <th>Distrito</th>
                                    <th>Dirección</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <jsp:useBean class="Model.List.List_Clients" id="list_clients" scope="session" ></jsp:useBean>
                                <%
                                    List<Person> l = list_clients.getClientes();
                                    for (int i = 0; i < l.size(); i++) {
                                %>
                                <tr>
                                    <%
                                        String type = "";
                                        if (l.get(i).getId_type() == 1) {
                                            type = "Físico";
                                        } else if (l.get(i).getId_type() == 2) {
                                            type = "Jurídico";
                                        }
                                    %>
                                    <td><%= type%></td>
                                    <td><%= l.get(i).getDni()%></td>
                                    <td><%= l.get(i).getName()%></td>
                                    <td><%= l.get(i).getTelephone()%></td>
                                    <td><%= l.get(i).getE_mail()%></td>
                                    <td><%= l.get(i).getLocation().getProvince()%></td>
                                    <td><%= l.get(i).getLocation().getCanton()%></td>
                                    <td><%= l.get(i).getLocation().getDistrito()%></td>
                                    <td><%= l.get(i).getLocation().getAddress()%></td>							 
                                    <td><input type="submit" name="btnAddC_<%= i%>" value="Agregar Cliente"></td>
                                </tr>						
                                <%
                                    }
                                %>
                            </tbody>
                        </table>
                    </div>
                </form>
                <a class="boton4" href="view_principal.jsp">Volver al inicio</a>
            </div>
        </div>
    </body>
</html>
