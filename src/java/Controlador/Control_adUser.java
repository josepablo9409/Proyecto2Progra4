package Controlador;

import DAO.DAO_User;
import Model.List.List_Users;
import Modelo.User;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Control_adUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Enumeration<String> parameterNames = request.getParameterNames();
        String param = parameterNames.nextElement();
        String[] split = param.split("btnUser_");
        int i = Integer.valueOf(split[1]);
        String option = request.getParameter(param);
        HttpSession session = request.getSession(false);
        if (session != null) {
            DAO_User daoU = new DAO_User();
            List_Users usuarios = (List_Users) session.getAttribute("usuarios");
            User u = usuarios.getUsuarios().get(i);
            if (option.equals("Habilitar")) {
                if (u.getStatus() == 0) {
                    if (daoU.changeStatus(u.getUser(), 1)) {
                        usuarios = daoU.read();
                        if (usuarios.getUsuarios().size() > 0) {
                            session.setAttribute("usuarios", usuarios);
                        }
                    }
                }
                request.getRequestDispatcher("view_users.jsp").forward(request, response);
            } else {
                if (option.equals("Deshabilitar")) {
                    if (u.getStatus() == 1) {
                        if (daoU.changeStatus(u.getUser(), 0)) {
                            usuarios = daoU.read();
                            if (usuarios.getUsuarios().size() > 0) {
                                session.setAttribute("usuarios", usuarios);
                            }
                        }
                        request.getRequestDispatcher("view_users.jsp").forward(request, response);
                    }
                }
            }
        } else {
            response.sendRedirect("index.jsp");
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
