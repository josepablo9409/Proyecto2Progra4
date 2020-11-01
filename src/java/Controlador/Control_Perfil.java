package Controlador;

import DAO.DAO_Emisor;
import Modelo.Emisor;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Control_Perfil extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession ses = request.getSession(false);
        if (ses != null) {
            try {
                Emisor t = (Emisor) ses.getAttribute("emisor");

                String name_full = request.getParameter("name");
                String num_tel = request.getParameter("num_tel");
                String mail = request.getParameter("mail");
                String tradename = request.getParameter("tradename");

                if ("".equals(name_full)) {
                    String msj = "Todos los campos deben ser rellenados";
                    response.sendRedirect(String.format("mensajes.jsp?msj=%s&&link=view_perfil.jsp", msj));
                } else {
                    Emisor emisor = new Emisor();
                    emisor.setDni(t.getDni());
                    emisor.setE_mail(mail);
                    emisor.setName(name_full);
                    emisor.setTelephone(num_tel);
                    emisor.setTradename(tradename);
                    emisor.setUser(t.getUser());
                    DAO_Emisor emi = new DAO_Emisor();
                    if (emi.update(emisor)) {
                        emisor = emi.search(emisor.getUser().getUser());
                        ses.setAttribute("emisor", emisor);
                        response.sendRedirect("mensajes.jsp?msj=Registro completo&&link=view_perfil.jsp");
                    } else {
                        response.sendRedirect("mensajes.jsp?msj=Error al registrar la info&&link=view_perfil.jsp");
                    }

                }
            } catch (NumberFormatException ex) {
                String msj = "Debe digitar numeros donde corresponde";
                response.sendRedirect(String.format("mensajes.jsp?msj=%s&&link=view_perfil.jsp", msj));
                System.err.println(Arrays.toString(ex.getStackTrace()));
            }
        } else {
            String msj = "No ha iniciado sessión";
            response.sendRedirect("mensajes.jsp?msj=" + msj + "link=index.jsp");
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
