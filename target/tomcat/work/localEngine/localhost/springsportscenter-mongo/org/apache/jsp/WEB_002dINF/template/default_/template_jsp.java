package org.apache.jsp.WEB_002dINF.template.default_;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class template_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, false, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Spring Sports Center</title>\n");
      out.write("\n");
      out.write("<style type=\"text/css\">\n");
      out.write("body {\n");
      out.write("\tmargin: 0px;\n");
      out.write("\tpadding: 0px;\n");
      out.write("\theight: 100%;\n");
      out.write("\toverflow: hidden;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".page {\n");
      out.write("\tmin-height: 100%;\n");
      out.write("\tposition: relative;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".header {\n");
      out.write("\twidth: 100%;\n");
      out.write("\ttext-align: center;\n");
      out.write("\tbackground-color:#6699CC; \n");
      out.write("\t/* background-image:url(\"WEB-INF/template/image/header-footer-5.jpg\"); */ \n");
      out.write("\t/* background-image:url('/resources/image/sports.jpg'); */\n");
      out.write("\t/* background-image:url(\"../image/header-footer-5.jpg\");  */\n");
      out.write("\t\n");
      out.write("\t \t\n");
      out.write("\tborder-radius:5px;\n");
      out.write("\t\n");
      out.write("}\n");
      out.write("\n");
      out.write(".content {\n");
      out.write("\tpadding: 10px;\n");
      out.write("\tpadding-bottom: 20px; /* Height of the footer element */\n");
      out.write("\tbackground-color:white;\n");
      out.write("\t\n");
      out.write("\toverflow: hidden;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".menu {\n");
      out.write("\tpadding: 50px 10px 0px 10px;\n");
      out.write("\twidth: 200px;\n");
      out.write("\t\n");
      out.write("\theight:73%;\n");
      out.write("\tfloat: left;\n");
      out.write("\t\n");
      out.write("\tbackground-color:#6699CC;\n");
      out.write("\t\n");
      out.write("\tborder:1px solid;\t \t\n");
      out.write("\tborder-radius:15px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".body {\n");
      out.write("\tposition:fixed;\n");
      out.write("\t/* background-color:yellow; */\n");
      out.write("\twidth:70%;\n");
      out.write("\theight:70%;\n");
      out.write("\tleft:20%;\n");
      out.write("\ttop:13%;\n");
      out.write("\n");
      out.write("}\n");
      out.write("\n");
      out.write(".footer {\n");
      out.write("\t\n");
      out.write("\t/* position: absolute; */\n");
      out.write("\tleft: 0;\n");
      out.write("\ttext-align: center;\n");
      out.write("\twidth: 100%;\n");
      out.write("\theight: 10%;\n");
      out.write("\t\n");
      out.write("\t/* background-image:url('../image/hall-floor.jpg'); */\n");
      out.write("\t \t\n");
      out.write("\tborder-radius:5px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write(".main-menu\n");
      out.write("{\n");
      out.write("margin-top:5%;\n");
      out.write("width: 100%;\n");
      out.write("height: 30%;\n");
      out.write("border:1px solid;\t \t\n");
      out.write("border-radius:5px;\n");
      out.write("\n");
      out.write("}\n");
      out.write("\n");
      out.write(".notice\n");
      out.write("{\n");
      out.write("margin-top:10px;\n");
      out.write("width: 100%;\n");
      out.write("height: 30%;\n");
      out.write("border:1px solid;\t \t\n");
      out.write("border-radius:5px;\n");
      out.write("\n");
      out.write("}\n");
      out.write(".news\n");
      out.write("{\n");
      out.write("margin-top:10px;\n");
      out.write("width: 100%;\n");
      out.write("height: 30%;\n");
      out.write("border:1px solid;\t \t\n");
      out.write("border-radius:5px;\n");
      out.write("\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\t<div class=\"page\">\n");
      out.write("\t\t");
      if (_jspx_meth_tiles_005finsertAttribute_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t<div class=\"content\">\n");
      out.write("\t\t\t");
      if (_jspx_meth_tiles_005finsertAttribute_005f1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t");
      if (_jspx_meth_tiles_005finsertAttribute_005f2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t\t");
      if (_jspx_meth_tiles_005finsertAttribute_005f3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t</div>\n");
      out.write("</body>\n");
      out.write("</html> ");
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

  private boolean _jspx_meth_tiles_005finsertAttribute_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_005finsertAttribute_005f0 = new org.apache.tiles.jsp.taglib.InsertAttributeTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_tiles_005finsertAttribute_005f0);
    _jspx_th_tiles_005finsertAttribute_005f0.setJspContext(_jspx_page_context);
    // /WEB-INF/template/default/template.jsp(122,2) name = name type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f0.setName("header");
    _jspx_th_tiles_005finsertAttribute_005f0.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_tiles_005finsertAttribute_005f0);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsertAttribute_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_005finsertAttribute_005f1 = new org.apache.tiles.jsp.taglib.InsertAttributeTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_tiles_005finsertAttribute_005f1);
    _jspx_th_tiles_005finsertAttribute_005f1.setJspContext(_jspx_page_context);
    // /WEB-INF/template/default/template.jsp(124,3) name = name type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f1.setName("menu");
    _jspx_th_tiles_005finsertAttribute_005f1.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_tiles_005finsertAttribute_005f1);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsertAttribute_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_005finsertAttribute_005f2 = new org.apache.tiles.jsp.taglib.InsertAttributeTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_tiles_005finsertAttribute_005f2);
    _jspx_th_tiles_005finsertAttribute_005f2.setJspContext(_jspx_page_context);
    // /WEB-INF/template/default/template.jsp(125,3) name = name type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f2.setName("body");
    _jspx_th_tiles_005finsertAttribute_005f2.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_tiles_005finsertAttribute_005f2);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsertAttribute_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertAttribute
    org.apache.tiles.jsp.taglib.InsertAttributeTag _jspx_th_tiles_005finsertAttribute_005f3 = new org.apache.tiles.jsp.taglib.InsertAttributeTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_tiles_005finsertAttribute_005f3);
    _jspx_th_tiles_005finsertAttribute_005f3.setJspContext(_jspx_page_context);
    // /WEB-INF/template/default/template.jsp(127,2) name = name type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertAttribute_005f3.setName("footer");
    _jspx_th_tiles_005finsertAttribute_005f3.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_tiles_005finsertAttribute_005f3);
    return false;
  }
}
