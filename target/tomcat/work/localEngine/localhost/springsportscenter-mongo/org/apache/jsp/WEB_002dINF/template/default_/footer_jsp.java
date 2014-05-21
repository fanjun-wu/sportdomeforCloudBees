package org.apache.jsp.WEB_002dINF.template.default_;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<style>\t\n");
      out.write("\n");
      out.write(".header-footer-class\n");
      out.write("{\n");
      out.write("\twidth:100%;\n");
      out.write("\theight:50px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".footer-ban\n");
      out.write("{\n");
      out.write("\theight:400px;\n");
      out.write("    width:100%;\n");
      out.write("    position:relative;\n");
      out.write("\n");
      out.write("}\n");
      out.write("#ban1\n");
      out.write("{\n");
      out.write("\tposition:absolute;\n");
      out.write("    left:0;\n");
      out.write("    top:0;\n");
      out.write("\n");
      out.write("}\n");
      out.write("\n");
      out.write("#info\n");
      out.write("{\n");
      out.write("\tz-index:100;\n");
      out.write("    position:absolute;    \n");
      out.write("    color:black;\n");
      out.write("    left:38%;\n");
      out.write("    top:2%;\n");
      out.write("    font-size:12px;\n");
      out.write("    font-weight:bold;\n");
      out.write("}\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"footer\">\n");
      out.write("\t\t\n");
      out.write("\t");
      out.write("\n");
      out.write("\t\t\n");
      out.write("</div>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
