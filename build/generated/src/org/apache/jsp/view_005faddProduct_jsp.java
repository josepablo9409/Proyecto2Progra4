package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.List.List_category;

public final class view_005faddProduct_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/encabezado.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link href=\"css/main.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <link href=\"css/view_addProduct.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <link href='https://fonts.googleapis.com/css?family=Bad Script' rel='stylesheet'>\r\n");
      out.write("        <link href='https://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet'>\r\n");
      out.write("        <title>Sistema de Facturación</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      out.write("<header>\n");
      out.write("    <form method = \"GET\" action = \"Main_Control\">\n");
      out.write("        <input class=\"btn_menu_principal\" type = \"submit\"  name = \"btn_option\" value = \"Logout\">\n");
      out.write("        <input class=\"btn_menu_principal\" type = \"submit\"  name = \"btn_option\" value = \"Agregar Cliente\">\n");
      out.write("        <input class=\"btn_menu_principal\" type = \"submit\" name = \"btn_option\" value = \"Agregar un Producto\">\n");
      out.write("        <input class=\"btn_menu_principal\" type = \"submit\" name = \"btn_option\" value = \"Perfil\">\n");
      out.write("        <input class=\"btn_menu_principal\" type = \"submit\" name = \"btn_option\" value = \"Facturar\">\n");
      out.write("        <input class=\"btn_menu_principal\" type = \"submit\" name = \"btn_option\" value = \"Ver Facturas\">\n");
      out.write("    </form>\n");
      out.write("</header>");
      out.write("\r\n");
      out.write("        <div class=\"div_centrado\">\r\n");
      out.write("            <h1>Agregar Producto</h1>\r\n");
      out.write("            <div id=\"div_main_addP\">\r\n");
      out.write("                <form action=\"Control_AddProduct\" method=\"POST\">\r\n");
      out.write("                    ");

                        HttpSession s = request.getSession(false);
                        if (s != null) {
                            List_category lista = (List_category) s.getAttribute("categories");
                    
      out.write("\r\n");
      out.write("                    <select name=\"category\">                \r\n");
      out.write("                        <option value=\"-1\">Categoria</option>\r\n");
      out.write("                        ");

                            for (int i = 0; i < lista.size(); i++) {
                                int d = (int) (lista.get(i).getIva() * 100);
                        
      out.write("\r\n");
      out.write("                        <option value=\"");
      out.print( i);
      out.write("\">\r\n");
      out.write("                            ");
      out.print( String.format("%1$s\tIVA: %2$d%3$s",
                                    lista.get(i).getDescripcion(), d, "%"));
      out.write("\r\n");
      out.write("                        </option>\r\n");
      out.write("                        ");
 }
                            } else {
                                response.sendRedirect(String.format("mensajes.jsp?msj=%s", "No ha iniciado sesión"));
                            }
                        
      out.write("\r\n");
      out.write("                    </select>\r\n");
      out.write("                    <label for=\"txt_detail\">Detalle del producto: </label>                    \r\n");
      out.write("                    <input type=\"text\" id=\"txt_detail\" name=\"detail\">\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <label for=\"txt_price\">Precio: </label>\r\n");
      out.write("                    <input type=\"number\" id=\"txt_price\" min=\"1\" name=\"price\">\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <input type=\"submit\" name=\"bnt_addProduct\" value=\"Agregar Producto\">\r\n");
      out.write("                    <a href=\"view_principal.jsp\">Volver a la página principal</a>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
