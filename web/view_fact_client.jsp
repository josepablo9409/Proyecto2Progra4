<%@page import="Model.List.List_category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/stylesheet.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Facturación</title>

    </head>
    <body>
        <h1>Cliente</h1>
        <div>
            <form action="Control_Facturar" method="POST">
                <input type="submit" name="btn_buscar" value="Buscar Cliente">
            </form>
            <form action="Control_Facturar" method="POST">
                <select name="tipo_id"></select>
                <input type="text" name="id" placeholder="Número de identificación">
                <input type="text" name="name" placeholder="Nombre completo">
                <input type="tel" name="num_tel" placeholder="Número de teléfono">
                <input type="email" name="mail" placeholder="Correo electrónico">				 
                <input type="text" name="province" placeholder="Provincia">
                <input type="text" name="canton" placeholder="Cantón">
                <input type="text" name="district" placeholder="Distrito">						
                <input type="text" name="address" placeholder="Direccion (Opcional)">
                <input type="submit" name="btn_next" value="Siguiente">
            </form>
            <a href="view_principal.jsp">Volver al inicio</a>
        </div>

    </body>
</html>
