<%@page import="Modelo.Emisor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Facturación</title>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <link href="css/view_add_client.css" rel="stylesheet" type="text/css"/>
        <link href='https://fonts.googleapis.com/css?family=Bad Script' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet'>
    </head>
    <body>
        <%@include file="encabezado.jsp" %>
        <%
            Emisor emisor = (Emisor) request.getSession(false).getAttribute("emisor");
            if (emisor != null || request.getSession(false) != null) {
        %>
        <div id="div_main_addC" class="div_centrado">
            <div>    
                <h1>Agregar Cliente</h1>
            </div>
            <div id="div_form_add_cliente">
                <form action="Control_AddClient" method="POST">
                    <div>
                        <span>
                            <label for="select_tipoId" class="element_form">Tipo de identificación</label>
                            <select id="select_tipoId" name="type_id" value="Tipo de identificación" class="element_form">
                                <option value="1">Física</option>
                                <option value="2">Jurídica</option>
                            </select>
                        </span>
                        <span>
                            <label for="input_dni" class="element_form">Número de cédula</label>
                            <input id="input_dni" class="element_form" type="text" name="dni" placeholder="Ingrese el número de cédula">
                        </span>
                    </div>
                    <div>
                        <label for="input_nom" class="element_form">Nombre completo</label>
                        <input id="input_nom" class="element_form" type="text" name="name" placeholder="Ingrese el nombre completo">
                        <label for="input_tel" class="element_form">Número de teléfono</label>
                        <input id="input_tel" class="element_form" type="tel" name="num_tel" placeholder="Ingrese el número de teléfono">
                    </div>
                    <div>
                        <label for="input_email" class="element_form" >Correo electrónico</label>
                        <input id="input_email" class="element_form"  type="email" name="mail" placeholder="Ingrese el correo electrónico">
                        <label for="input_province" class="element_form" >Provincia</label>
                        <input id="input_province" class="element_form" type="text" name="province" placeholder="Provincia">
                    </div>
                    <div>
                        <label for="input_canton" class="element_form" >Cantón</label>
                        <input id="input_canton" class="element_form"  type="text" name="canton" placeholder="Cantón">
                        <label for="input_dist" class="element_form" >Distrito</label>
                        <input id="input_dist" class="element_form"  type="text" name="district" placeholder="Distrito">	
                    </div>
                    <div>
                        <label for="input_dir" class="element_form" >Dirección</label>
                        <input id="input_dir" class="element_form"  type="text" name="address" placeholder="Direccion (Opcional)">  
                    </div>
                    <div>
                        <input type="submit" value="Agregar">                    
                        <a href="view_principal.jsp">Volver a la página principal</a>
                    </div>
                    <% } else {
                            response.sendRedirect(String.format("mensajes.jsp?msj=%s", "Perfil sin datos. No se pudo cargar su perfil"));
                        }
                    %>
                </form>
            </div>
        </div>
    </body>
</html>
