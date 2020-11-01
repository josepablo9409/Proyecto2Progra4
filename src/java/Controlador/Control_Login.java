package Controlador;

import DAO.DAO_Emisor;
import DAO.DAO_User;
import Modelo.Emisor;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Modelo.User;

public class Control_Login extends HttpServlet {
 /*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("input_idUser");
        String pass = request.getParameter("input_password");
        if (user.isEmpty() || pass.isEmpty()) {
            response.sendRedirect("index.jsp");
        } else {
            DAO_User dao = new DAO_User();
            User u = dao.validate(user, pass);
            if (u != null) {
                if (u.getRol() == 1) {
                    if (u.getStatus() != 1) {
                        String msj = "Su perfil todavia no se ha habilitado";
                        response.sendRedirect("mensajes.jsp?msj=" + msj + "&link=index.jsp");
                    } else {
                        DAO_Emisor dao_e = new DAO_Emisor();
                        Emisor emisor = dao_e.search(user);
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
    }*/

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
        //processRequest(request, response);
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
        //processRequest(request, response);
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
