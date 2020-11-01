package Controlador;

import DAO.DAO_Emisor;
import DAO.DAO_Ubication;
import DAO.DAO_User;
import Modelo.Emisor;
import Modelo.Ubication;
import Modelo.User;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlRegistrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            int type_id = Integer.valueOf(request.getParameter("type_id"));
            String num_id = request.getParameter("dni");
            String name_full = request.getParameter("name");
            String num_tel = request.getParameter("num_tel");
            String mail = request.getParameter("mail");
            String tradename = request.getParameter("tradename");
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            String province = request.getParameter("province");
            String canton = request.getParameter("canton");
            String district = request.getParameter("district");
            String address = "";
            if (num_id == "" || name_full == "" || num_tel == "" || mail == ""
                    || tradename == "" || user == "" || pass == "" || province == "") {
                String msj = "Todos los campos deben ser rellenados";
                response.sendRedirect(String.format("mensajes.jsp?msj=%s", msj));
            } else {
                Emisor emisor = new Emisor(
                        tradename,
                        new User(user, pass),
                        null, num_id, name_full, num_tel, mail, type_id,
                        new Ubication(
                                0, province, canton, district, address)
                );
                DAO_Ubication ubi = new DAO_Ubication();
                if (ubi.create(emisor.getLocation())) {
                    DAO_User i_u = new DAO_User();
                    if (i_u.create(emisor.getUser())) {
                        DAO_Emisor emi = new DAO_Emisor();
                        if (emi.create(emisor)) {
                            response.sendRedirect("mensajes.jsp?msj=Registro completo");
                        } else {
                            i_u.delete(user);
                            response.sendRedirect("mensajes.jsp?msj=Error al registrar la info");
                        }
                    } else {
                        response.sendRedirect("mensajes.jsp?msj=Error al registrar el user");
                    }
                } else {
                    response.sendRedirect("mensajes.jsp?msj=Error al registrar el usuario");
                }
            }
        } catch (NumberFormatException ex) {
            String msj = "Todos los campos deben ser rellenados";
            response.sendRedirect(String.format("mensajes.jsp?msj=%s", msj));
            System.err.println(Arrays.toString(ex.getStackTrace()));
        } catch (IOException | SQLException ex) {
            if (ex instanceof SQLIntegrityConstraintViolationException) {
                response.sendRedirect("mensajes.jsp?msj=El usuario ya existe&&link=index.jsp");
            }
            Logger.getLogger(ControlRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
