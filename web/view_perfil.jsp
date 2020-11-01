<%@page import="Modelo.Emisor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Facturación</title>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <link href="css/view_perfil.css" rel="stylesheet" type="text/css"/>
        <link href='https://fonts.googleapis.com/css?family=Bad Script' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet'>        
    </head>
    <body>
        <%@include file="encabezado.jsp" %>
        <div class="div_centrado">
            <h1>Perfil</h1>
            <div id="div_principal_perfil">
                <form action="Control_Perfil" method="POST">
                    <%
                        Emisor emisor = (Emisor) request.getSession(false).getAttribute("emisor");
                        if (emisor != null) {
                    %>

                    <label for="input_dni">Cédula</label>                
                    <input id="input_dni" type="text" name="dni" placeholder="Ingrese su número de cédula" value="<%= emisor.getDni()%>" readonly>
                    <label for="input_nom">Nombre</label>
                    <input id="input_nom" type="text" name="name" placeholder="Ingrese su nombre completo" value="<%= emisor.getName()%>">
                    <br>
                    <label for="input_tel">Teléfono</label>
                    <input id="input_tel" type="tel" name="num_tel" placeholder="Ingrese su número de teléfono" value="<%= emisor.getTelephone()%>">
                    <label for="input_email">E-Mail</label>                
                    <input id="input_email" type="email" name="mail" placeholder="Ingrese su correo electrónico" value="<%= emisor.getE_mail()%>">
                    <br>
                    <label for="input_negocio">Nombre del negocio</label>
                    <input id="input_negocio" type="text"  name="tradename" placeholder="Ingrese el nombre de su negocio" value="<%= emisor.getTradename()%>">
                    <label for="input_province">Provincia</label>
                    <input id="input_province" type="text" name="province" placeholder="Provincia" value="<%= emisor.getLocation().getProvince()%>">
                    <br>
                    <label for="input_canton">Cantón</label>
                    <input id="input_canton" type="text" name="canton" placeholder="Cantón" value="<%= emisor.getLocation().getCanton()%>">
                    <label for="input_dist">Distrito</label>
                    <input id="input_dist" type="text" name="district" placeholder="Distrito" value="<%= emisor.getLocation().getDistrito()%>">
                    <br>
                    <label for="input_dir">Dirección</label>                    
                    <input id="input_dir" type="text" name="address" placeholder="Dirección" value="<%= emisor.getLocation().getAddress()%>">                
                    <input id="" type="submit" name="btn_updtPerfil" value="Actualizar Datos">
                    <% } else {
                            response.sendRedirect(String.format("mensajes.jsp?msj=%s", "Perfil sin datos. No se pudo cargar su perfil"));
                        }
                    %>
                </form>
                <a id="link_principal" href="view_principal.jsp">Ir a la ventana principal</a>
            </div>
        </div>
    </body>
</html>
