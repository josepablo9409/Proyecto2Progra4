package Controlador;

import Modelo.Factura;
import Modelo.ListProduct;
import Modelo.Producto;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Control_Fac_P extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Enumeration<String> parameterNames = request.getParameterNames();
        String[] split = null;
        while (parameterNames.hasMoreElements()) {
            String aux = parameterNames.nextElement();
            if (aux.contains("btnAdd_")) {
                split = aux.split("btnAdd_");
            }
        }
        int i = Integer.valueOf(split[1]);
        try {
            int cant = Integer.valueOf(request.getParameter("cantidad_" + i));
            HttpSession session = request.getSession(false);
            if (session != null) {
                ListProduct productos = (ListProduct) session.getAttribute("productos");
                Factura f = (Factura) session.getAttribute("factura");
                if (productos != null && f != null) {
                    Producto p_new = productos.get(i);
                    Producto p_old = f.getProductos().search(p_new.getId());
                    if (p_old == null) {
                        p_new.setCantidad(cant);
                        f.getProductos().add(p_new);
                    } else {
                        p_old.setCantidad(p_old.getCantidad() + cant);
                    }
                    request.getRequestDispatcher("view_fact_prod.jsp").forward(request, response);
                }
            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (NumberFormatException ex) {
            response.sendRedirect("view_fact_prod.jsp");
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
