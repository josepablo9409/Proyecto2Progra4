package Controlador;

import Model.List.ListFacturas;
import Modelo.Factura;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Control_XML extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/xml");
        try {
            OutputStream os = response.getOutputStream();
            HttpSession session = request.getSession(false);

            Enumeration<String> parameterNames = request.getParameterNames();
            String p = parameterNames.nextElement();
            if (session != null) {
                if (p.contains("verXML_")) {
                    String[] split = p.split("verXML_");
                    int i = Integer.valueOf(split[1]);
                    ListFacturas f = (ListFacturas) session.getAttribute("facturas");
                    if (f != null) {
                        JAXBContext jaxbContext = JAXBContext.newInstance(Factura.class);
                        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML
                        StringWriter sw = new StringWriter();
                        jaxbMarshaller.marshal(f.getFacturas().get(i), sw);
                        System.out.print(sw.toString());
                        os.write(sw.toString().getBytes());
                        os.flush();
                        os.close();
                    } else {
                        response.sendRedirect("view_list_facturas.jsp");
                    }
                } else {
                    response.sendRedirect("index.jsp");
                }
            } else {
                response.sendRedirect("index.jsp");
            }

        } catch (IOException | NumberFormatException | JAXBException ex) {
            Logger.getLogger(Control_XML.class.getName()).log(Level.SEVERE, null, ex);
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
