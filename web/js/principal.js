/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
console.log('activo');

$("#login").click(
        function login()
        {

            var a = 0;
            var b = 0;
            a = document.getElementById("input_idUser").value;
            b = document.getElementById("input_password").value;
            User = {username: a, password: b};
            console.log(a + " " + b);
            v = validar(a, b);
            if (v)
            {
                alert("espacios en blanco");
               window.location.href = 'index.jsp';


            } else
            {
                console.log(a + " " + b);
               $.ajax({type: "POST", url: "login", data: JSON.stringify(User),
                    contentType: "application/json"}).then(alert("se ha logueado"));
              
               
            }


        });



function validar(a, b)
{
    if (a === "" || b === "")
        return true;
}


