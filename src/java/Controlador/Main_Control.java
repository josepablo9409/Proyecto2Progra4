package Controlador;

import DAO.DAO_Categories;
import DAO.DAO_Factura;
import DAO.DAO_Person;
import Model.List.ListFacturas;
import Model.List.List_Clients;
import Model.List.List_category;
import Modelo.Emisor;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Main_Control extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String option = request.getParameter("btn_option");
        HttpSession session = request.getSession(false);
        Emisor emisor = null;
        if (session != null) {
            switch (option) {
                case "Agregar Cliente":
                    request.getRequestDispatcher("view_add_client.jsp").forward(request, response);
                    break;
                case "Agregar un Producto":
                    DAO_Categories dao = new DAO_Categories();
                    List_category lista = dao.read();
                    session.setAttribute("categories", lista);
                    request.getRequestDispatcher("view_addProduct.jsp").forward(request, response);
                    break;
                case "Perfil":
//                    DAO_Person daop = new DAO_Person();
//                    emisor = (Emisor) session.getAttribute("emisor");
                    request.getRequestDispatcher("view_perfil.jsp").forward(request, response);
                    break;
                case "Facturar":
                    emisor = (Emisor) session.getAttribute("emisor");
                    if (emisor != null) {
                        DAO_Person daoP = new DAO_Person();
                        List_Clients clientes = daoP.searchClients(emisor.getDni());
                        session.setAttribute("list_clients", clientes);
                        request.getRequestDispatcher("view_list_client.jsp").forward(request, response);
                    } else {
                        String msj = "No ha iniciado sesión";
                        response.sendRedirect("mensajes.jsp?msj=" + msj + "link=index.jsp");
                    }
                    break;
                case "Ver Facturas":
                    emisor = (Emisor) session.getAttribute("emisor");
                    DAO_Factura dao_f = new DAO_Factura();
                    ListFacturas facturas = dao_f.findByOwner(emisor);
                    if (facturas != null) {
                        session.setAttribute("facturas", facturas);
                        request.getRequestDispatcher("view_list_facturas.jsp").forward(request, response);
                    } else {
                        String msj = "No hay facturas";
                        response.sendRedirect("mensajes.jsp?msj=" + msj + "&link=view_principal.jsp");
                    }
                    break;
                case "Logout":
                    if (session != null) {
                        session.removeAttribute("emisor");
                        session.invalidate();
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    } else {
                        response.sendRedirect("index.jsp");
                    }
                    break;
                default:
                    break;
            }
        } else {
            String msj = "No ha iniciado sesión";
            response.sendRedirect("mensajes.jsp?msj=" + msj + "&&link=index.jsp");
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
