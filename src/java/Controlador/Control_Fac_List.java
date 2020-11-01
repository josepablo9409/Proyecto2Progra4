package Controlador;

import Model.List.ListFacturas;
import Modelo.Pdf;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Control_Fac_List extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        OutputStream os = response.getOutputStream();
        HttpSession session = request.getSession(false);
        Enumeration<String> parameterNames = request.getParameterNames();
        String p = parameterNames.nextElement();
        if (session != null) {
            if (p.contains("verPdf_")) {
                String[] split = p.split("verPdf_");
                int i = Integer.valueOf(split[1]);
                ListFacturas f = (ListFacturas) session.getAttribute("facturas");
                if (f != null) {
                    Pdf pdf = new Pdf();
                    pdf.render(os, f.getFacturas().get(i));
                    os.flush();
                    os.close();
                } else {
                    String msj = "No se pudo generar la factura";
                    response.sendRedirect("mensajes.jsp?msj=" + msj + "&link=view_list_facturas.jsp");
                }
            } else {
                response.sendRedirect("view_list_facturas.jsp");
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
