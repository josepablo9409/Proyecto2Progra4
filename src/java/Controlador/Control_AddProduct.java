package Controlador;

import DAO.DAO_Product;
import Model.List.List_category;
import Modelo.Producto;
import Modelo.Emisor;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Control_AddProduct extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String detail = request.getParameter("detail");
        int category = Integer.valueOf(request.getParameter("category"));
        float price = Float.valueOf(request.getParameter("price"));
        DAO_Product dao = new DAO_Product();
        HttpSession session = request.getSession(false);
        if (session != null) {
            Emisor emisor = (Emisor) session.getAttribute("emisor");
            if (emisor != null) {
                List_category categories = (List_category) session.getAttribute("categories");
                Producto product = new Producto(-1, detail, price, categories.get(category));
                if (dao.create(product, emisor.getDni())) {
                    response.sendRedirect("mensajes.jsp?msj=Ingresado&link=view_addProduct.jsp");
                } else {
                    response.sendRedirect("mensajes.jsp?msj=No se pudo relacionar su producto a su cuenta"
                            + "&link=view_addProduct.jsp");
                }
            } else {
                response.sendRedirect("mensajes.jsp?msj=El emisor no se encuentra"
                        + "&link=view_addProduct.jsp");
            }
        } else {
            response.sendRedirect("mensajes.jsp?msj=Error en sesion&link=view_addProduct.jsp");
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
