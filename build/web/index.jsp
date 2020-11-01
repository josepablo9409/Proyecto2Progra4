<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Facturación</title>        
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <link href="css/index.css" rel="stylesheet" type="text/css"/>
       <link href='https://fonts.googleapis.com/css?family=Bad Script' rel='stylesheet'>
        <link href='https://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet'>   
           <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>       

    </head>
    <body>
        <div id="div_index">
            <form method="Post" >
                <div class="div_inputs"> 
                    <label for="input_idUser" id="label_user"> Usuario</label>
                    <input id="input_idUser" name="input_idUser"type="text"placeholder="Digite su usuario" required>
                </div>
                <div class="div_inputs">
                    <label for="input_password"> Contraseña</label>
                    <input id="input_password" name="input_password"type="password" placeholder="Digite su contraseña" required>
                </div>
                <div class="div_inputs">                    
                    <input id="login" type="submit" value="Aceptar" style="margin-bottom: 15px">
                    <a href="view_singin.jsp">Registrarse</a>  
                   
                </div>          
            </form>
        </div>
       
           <script type="text/javascript" src="js/principal.js"></script>
           
        </script>
    </body>
</html>