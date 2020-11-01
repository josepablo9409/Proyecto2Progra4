<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>Sistema de Facturacion</title>
    </head>
    <body>
        <div>
            <h1>Lista de Proveedores</h1>
            <a href="view_admin.jsp">Página Principal</a>
        </div>
        <jsp:useBean class="Model.List.List_Users" id="usuarios" scope="session"></jsp:useBean>
            <form action="Control_Admin_User" method="GET">
                <table border="1">
                    <thead>
                        <tr>
                            <th>Nombre de Usuario</th>
                            <th>Estado</th>
                            <th></th>
                            <th></th>									
                        </tr>
                    </thead>
                <%
                    for (int i = 0; i < usuarios.getUsuarios().size(); i++) {
                %>												
                <tbody>
                    <tr>
                        <%
                            String status = null;
                            if (usuarios.getUsuarios().get(i).getStatus() == 1) {
                                status = "Habilitado";
                            } else {
                                status = "Deshabilitado";
                            }
                        %>
                        <td><%= usuarios.getUsuarios().get(i).getUser()%></td>
                        <td><%= status%></td>
                        <td><input type="submit" name="btnUser_<%= i%>" value="Habilitar"></td>
                        <td><input type="submit" name="btnUser_<%= i%>" value="Deshabilitar"></td>									
                    </tr>
                </tbody>
                <%
                    }
                %>
            </table>
        </form>
    </body>
</html>
