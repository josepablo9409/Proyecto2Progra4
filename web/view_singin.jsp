<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <link href="css/view_singin.css" rel="stylesheet" type="text/css"/>
        <link href='https://fonts.googleapis.com/css?family=Bad Script' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet'>
        <title>Registro al Sistema</title>
    </head>
    <body>
        <div class="div_centrado">
            <h1>Registro</h1>
            <div class="div_form">
                <form action="Control_Signin" method="POST">                                                            
                    <label for="select_tipoId" class="element_form">Tipo de identificación</label>
                    <select id="select_tipoId" name="type_id" value="Tipo de identificación" class="element_form">
                        <option value="1">Física</option>
                        <option value="2">Jurídica</option>
                    </select>
                    <label for="input_dni" class="element_form">Número de cédula</label>
                    <input id="input_dni" class="element_form" type="text" name="dni" placeholder="Ingrese el número de cédula">                        

                    <label for="input_nom" class="element_form">Nombre completo</label>
                    <input id="input_nom" class="element_form" type="text" name="name" placeholder="Ingrese el nombre completo">
                    <label for="input_tel" class="element_form">Número de teléfono</label>
                    <input id="input_tel" class="element_form" type="tel" name="num_tel" placeholder="Ingrese el número de teléfono">

                    <label for="input_email" class="element_form" >Correo electrónico</label>
                    <input id="input_email" class="element_form"  type="email" name="mail" placeholder="Ingrese el correo electrónico">
                    <label for="input_province" class="element_form" >Provincia</label>
                    <input id="input_province" class="element_form" type="text" name="province" placeholder="Provincia">

                    <label for="input_canton" class="element_form" >Cantón</label>
                    <input id="input_canton" class="element_form"  type="text" name="canton" placeholder="Cantón">
                    <label for="input_dist" class="element_form" >Distrito</label>
                    <input id="input_dist" class="element_form"  type="text" name="district" placeholder="Distrito">	                   
                    <label for="input_dir" class="element_form" >Dirección</label>
                    <input id="input_dir" class="element_form"  type="text" name="address" placeholder="Direccion (Opcional)">  
                    <label for="tradename" class="element_form" >Nombre del negocio</label>
                    <input type="text" id="tradename" name="tradename" placeholder="Ingrese el nombre de su negocio">
                    <label for="user" class="element_form" >Nombre de usuario</label>
                    <input type="text" id="user" name="user" placeholder="Ingrese un nombre de usuario">
                    <input type="text" name="pass" placeholder="Ingrese una contraseña">
                    <input type="submit" value="Registrarse">
                    <a class="boton4" href="index.jsp">Volver al inicio</a>                    
            </div>


        </form>
    </div>
</div>
</body>
</html>