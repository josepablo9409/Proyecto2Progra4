package Controlador;

import DAO.DAO_Product;
import Modelo.Factura;
import Model.List.List_Clients;
import Modelo.ListProduct;
import Modelo.Person;
import Modelo.Emisor;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Control_Fac_C extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Enumeration<String> parameterNames = request.getParameterNames();
        String param = parameterNames.nextElement();
        String[] split = param.split("btnAddC_");
        int i = Integer.valueOf(split[1]);
        HttpSession session = request.getSession(false);
        if (session != null) {
            Emisor emisor = (Emisor) session.getAttribute("emisor");
            List_Clients clients = (List_Clients) session.getAttribute("list_clients");
            if (clients != null) {
                Person cliente = clients.getClientes().get(i);
                Factura f = new Factura(emisor, cliente);
                session.setAttribute("factura", f);
                DAO_Product dao = new DAO_Product();
                ListProduct lista = dao.read(emisor.getDni());
                if (lista != null) {
                    session.setAttribute("productos", lista);
                    request.getRequestDispatcher("view_fact_prod.jsp").forward(request, response);
                } else {
                    String msj = "No se encontraron productos asociados a su cuenta por favor agregue productos";
                    response.sendRedirect("mensajes.jsp?msj=" + msj + "&link=view_addProduct.jsp");
                }
            } else {
                String msj = "No se encontraron clientes asociados a su cuenta por favor agregue clientes";
                response.sendRedirect("mensajes.jsp?msj=" + msj + "link=view_add_client.jsp");
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
