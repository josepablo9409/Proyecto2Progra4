/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Universidad
 */
import DAO.DAO_Emisor;
import DAO.DAO_User;
import Modelo.Emisor;
import Modelo.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class login {

    @Context
    HttpServletRequest request;
    HttpServletResponse response;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
   
    public void login(User user)
            throws ServletException, IOException {
        {

            if (user.getUser().isEmpty() || user.getPass().isEmpty()) {
                response.sendRedirect("index.jsp");
            } else {
                DAO_User dao = new DAO_User();
                User u = dao.validate(user.getUser(), user.getPass());
                if (u != null) {
                    if (u.getRol() == 1) {
                        if (u.getStatus() != 1) {
                            String msj = "Su perfil todavia no se ha habilitado";
                            response.sendRedirect("mensajes.jsp?msj=" + msj + "&link=index.jsp");
                        } else {
                            DAO_Emisor dao_e = new DAO_Emisor();
                            Emisor emisor = dao_e.search(user.getUser());
                            if (emisor != null) {
                                HttpSession session = request.getSession();
                                session.setAttribute("emisor", emisor);
                                request.getRequestDispatcher("view_principal.jsp").forward(request, response);
                            } else {
                                response.sendRedirect("index.jsp");
                            }
                        }
                    } else {
                        response.sendRedirect("view_admin.jsp");
                    }
                } else {
                    request.getRequestDispatcher("view_singin.jsp").forward(request, response);
                }
            }

        }
    }
}
