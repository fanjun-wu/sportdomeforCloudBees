package org.apache.jsp.WEB_002dINF.views.frontend;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class reservation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css\" />\n");
      out.write("<script src=\"http://code.jquery.com/jquery-1.9.1.js\"></script>\n");
      out.write("<script src=\"http://code.jquery.com/ui/1.10.2/jquery-ui.js\"></script>\n");
      out.write("<link href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" rel=\"stylesheet\">\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("<script>\n");
      out.write("\t$(document).ready(function() {\n");
      out.write("\t\t\n");
      out.write("\t\t//****************************************************************************************\n");
      out.write("\t\t//\n");
      out.write("\t\t//Var Decalre and Initialize \n");
      out.write("\t\t//\n");
      out.write("\t\t//****************************************************************************************\n");
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("   \t  var capabilities=[];\t\n");
      out.write("   \t  var intervals=[];\n");
      out.write("   \t  var halls=[]; \n");
      out.write("   \t  var courts=[];\n");
      out.write("   \t  \n");
      out.write("   \t  var capabilitySelected;\n");
      out.write("   \t  var dateSelected;\n");
      out.write("   \t  var timeIntervalSelected;\n");
      out.write("   \t  var hallSelected;\n");
      out.write("   \t  var courtSelected;\n");
      out.write("   \t  var name;\n");
      out.write("   \t  var email;\n");
      out.write("   \t  var tele;\n");
      out.write("   \t  var userInfo;\n");
      out.write("   \t  \n");
      out.write("   \t  \n");
      out.write("  \t  var capabilityURL=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/getCapabilities\";  \t  \n");
      out.write("  \t  var intervalURL=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/getTimeIntervals\";  \t    \t  \n");
      out.write("  \t  var hallURL=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/getHalls\";\n");
      out.write("  \t  var courtURL=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/getCourts\";\n");
      out.write("  \t  var dateSelectedURL=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/getDate\";\n");
      out.write("  \t  var userInfoURL=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/getUserInfo\";\n");
      out.write("  \t  var successURL=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/reserveSuccess\"; \n");
      out.write("  \t  //var successURL=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/home\";\n");
      out.write("  \t  \n");
      out.write("  \t  \n");
      out.write("  \t\tinputDisabledInitialization();\n");
      out.write("  \n");
      out.write("  \t  \n");
      out.write("\t\t//****************************************************************************************\n");
      out.write("\t\t//\n");
      out.write("\t\t//Capability\n");
      out.write("\t\t//\n");
      out.write("\t\t//****************************************************************************************\n");
      out.write("\n");
      out.write("  \t  \n");
      out.write("\t\t$.getJSON(capabilityURL, {\n");
      out.write("\t\t\t\t\t\t\t\ttags : \"capability\",\n");
      out.write("\t\t\t\t\t\t\t\ttagmode : \"any\",\n");
      out.write("\t\t\t\t\t\t\t\tformat : \"json\"\n");
      out.write("\t\t\t\t\t\t\t}).done(\n");
      out.write("\t\t\t\t\t\t\t\t\tfunction(data) {\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\tconsole.log(\"size: \"+data.length);\n");
      out.write("\t\t\t\t\t\t\t\t\t\tconsole.log(\"Capabilities JSON: \"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ JSON.stringify(data));\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t       //clean the data recieved before, don't use capabilities=[] \n");
      out.write("\t\t\t\t\t\t\t\t\t       capabilities.length=0;\n");
      out.write("\t\t\t\t\t\t\t\t\t       //alert(\"0 capabilities size: \"+capabilities.length);\n");
      out.write("\t\t\t\t\t\t\t\t\t\tvar i;\n");
      out.write("\t\t\t\t\t\t\t\t\t\tfor (i = 0; i < data.length; i++)\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tcapabilities.push(data[i].resource);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//alert(\"1 capabilities size: \"+capabilities.length);\n");
      out.write("\t\t\t\t\t\t\t\t\t});\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t$('#capability-search').autocomplete({\n");
      out.write("\t\t\t\t\t\t\t\tsource : capabilities,\n");
      out.write("\t\t\t\t\t\t\t\tminLength : 0,\n");
      out.write("\t\t\t\t\t\t\t\tscroll : true,\n");
      out.write("\t\t\t\t\t\t\t\tselect:function(event, ui)\n");
      out.write("\t\t\t\t\t\t\t\t{\n");
      out.write("\t\t\t\t\t\t\t\t\t//alert(\"2 capabilities size: \"+capabilities.length);\n");
      out.write("\t\t\t\t\t\t\t\t\tcapabilitySelected=ui.item.value;\t\n");
      out.write("\t\t\t\t\t\t\t\t\tconsole.log(\"capability Selected:\"+capabilitySelected);\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t//clean the input value below\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\".datepicker\").val('');\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\"#timeinterval-remains\").val('');\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\"#hall-remains\").val('');\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\"#court-remains\").val('');\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t    \n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t$.ajax({\n");
      out.write("\t\t\t\t\t\t\t\t\t    type: 'POST',\n");
      out.write("\t\t\t\t\t\t\t\t\t    url: capabilityURL,\n");
      out.write("\t\t\t\t\t\t\t\t\t    async: false,\n");
      out.write("\t\t\t\t\t\t\t\t\t    data: capabilitySelected,\n");
      out.write("\t\t\t\t\t\t\t\t\t    \n");
      out.write("\t\t\t\t\t\t\t\t\t    contentType: \"application/json; charset=utf-8\", \n");
      out.write("\t\t\t\t\t\t\t\t\t    \n");
      out.write("\t\t\t\t\t\t\t\t\t    success: function(data) {\n");
      out.write("\t\t\t\t\t\t\t\t\t       console.log('response data = ' + JSON.stringify(data));\n");
      out.write("\t\t\t\t\t\t\t\t\t       \n");
      out.write("\t\t\t\t\t\t\t\t\t       \n");
      out.write("\t\t\t\t\t\t\t\t\t     //only unblock dater picker\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(\".datepicker\").prop('disabled',false);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(\"#timeinterval-remains\").prop('disabled',true);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(\"#hall-remains\").prop('disabled',true);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(\"#court-remains\").prop('disabled',true);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t      \n");
      out.write("\t\t\t\t\t\t\t\t\t    },\n");
      out.write("\t\t\t\t\t\t\t\t\t    error: function(xhr, textStatus, error){\n");
      out.write("\t\t\t\t\t\t\t\t\t        console.log(\"status: \"+textStatus);\n");
      out.write("\t\t\t\t\t\t\t\t\t        console.log(\"error: \"+error);\n");
      out.write("\t\t\t\t\t\t\t\t\t    }\n");
      out.write("\t\t\t\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t\t}).focus(function() {\n");
      out.write("\t\t\t\t\t\t\t\t$(this).autocomplete(\"search\", \"\");\n");
      out.write("\t\t\t\t\t\t\t});\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t//****************************************************************************************\n");
      out.write("\t\t\t\t\t\t\t//\n");
      out.write("\t\t\t\t\t\t\t//Date Picker\n");
      out.write("\t\t\t\t\t\t\t//\n");
      out.write("\t\t\t\t\t\t\t//****************************************************************************************\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t// $(\".datepicker\").datepicker({ dateFormat: 'yy-mm-dd' });\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t$(\".datepicker\").datepicker(\n");
      out.write("\t\t\t\t\t\t\t\t\t{\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//dateFormat: 'dd/mm/yy',\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdateFormat: 'yy-mm-dd',\n");
      out.write("\t\t\t\t\t\t\t\t\t\tonSelect:function(dateText)\n");
      out.write("\t\t\t\t\t\t\t\t\t\t{\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t/* console.log(\"date selected: \"+dateText); */\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tdateSelected=dateText;\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tconsole.log(\"date selected: \"+dateSelected);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t//clean the input value below\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(\"#timeinterval-remains\").val('');\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(\"#hall-remains\").val('');\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(\"#court-remains\").val('');\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$.ajax({\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t    type: 'POST',\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t    url: dateSelectedURL,\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t    async: false,\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t    data: dateSelected,\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t    \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t    contentType: \"application/json; charset=utf-8\", \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t    \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t    success: function(data) {\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t    \t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t    \t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t//unblock timeinterval\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"#timeinterval-remains\").prop('disabled',false);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"#hall-remains\").prop('disabled',true);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t$(\"#court-remains\").prop('disabled',true);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t    \t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t       console.log(\"response data = \" + data);\t\t\t\t\t\t\t\t\t\t\t       \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t//****************************************************************************************\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t//\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t//Time Intervals\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t//\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t//****************************************************************************************\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t       \t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t$.getJSON(intervalURL, {\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\ttags : \"interval\",\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\ttagmode : \"any\",\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tformat : \"json\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t}).done(\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfunction(data) {\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tconsole.log(\"Intervals JSON: \"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ JSON.stringify(data));\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tintervals.length=0;\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tvar i;\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfor (i = 0; i < data.length; i++)\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tvar first,second,third;\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfirst=data[i].toString()+\"h\";\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsecond=\"---\";\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tif(data[i]==24)\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tthird=\"0h\";\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\telse\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tthird=(data[i]+1).toString()+\"h\";\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tintervals.push(first+second+third);\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tconsole.log(\"i=\"+i+\" \"+intervals[i]);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tconsole.log(\"data size recieved: \"+intervals.length);\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t    },\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t    error: function(xhr, textStatus, error){\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t        console.log(\"status: \"+textStatus);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t        console.log(\"error: \"+error);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t    }\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t);\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t$('#timeinterval-remains').autocomplete({\n");
      out.write("\t\t\t\t\t\t\t\tsource : intervals,\n");
      out.write("\t\t\t\t\t\t\t\tminLength : 0,\n");
      out.write("\t\t\t\t\t\t\t\tscroll : true,\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\tselect:function(event, ui)\n");
      out.write("\t\t\t\t\t\t\t\t{\n");
      out.write("\t\t\t\t\t\t\t\t\ttimeIntervalSelected=(ui.item.value).split(\"h\")[0];\t\n");
      out.write("\t\t\t\t\t\t\t\t\tconsole.log(\"start time selected:\"+timeIntervalSelected);\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t//clean the input value below\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\"#hall-remains\").val('');\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\"#court-remains\").val('');\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t$.ajax({\n");
      out.write("\t\t\t\t\t\t\t\t\t    type: 'POST',\n");
      out.write("\t\t\t\t\t\t\t\t\t    url: intervalURL,\n");
      out.write("\t\t\t\t\t\t\t\t\t    async: false,\n");
      out.write("\t\t\t\t\t\t\t\t\t    data: timeIntervalSelected,\n");
      out.write("\t\t\t\t\t\t\t\t\t    \n");
      out.write("\t\t\t\t\t\t\t\t\t    contentType: \"application/json; charset=utf-8\", \n");
      out.write("\t\t\t\t\t\t\t\t\t    \n");
      out.write("\t\t\t\t\t\t\t\t\t    success: function(data) {\n");
      out.write("\t\t\t\t\t\t\t\t\t       console.log('response data = ' + JSON.stringify(data));\n");
      out.write("\t\t\t\t\t\t\t\t\t       \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t//unblock hall\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(\"#hall-remains\").prop('disabled',false);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(\"#court-remains\").prop('disabled',true);\n");
      out.write("\t\t\t\t\t\t\t\t\t       \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t//****************************************************************************************\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t//\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t//Halls\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t//after post the start time, retrieve the data of halls available\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t//\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t//****************************************************************************************\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$.getJSON(hallURL, {\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttags : \"hall\",\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttagmode : \"any\",\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tformat : \"json\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}).done(\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfunction(data) {\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tconsole.log(\"Halls JSON: \"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ JSON.stringify(data));\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thalls.length=0;\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tvar i;\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfor (i = 0; i < data.length; i++)\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thalls.push(data[i].name);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t    },\n");
      out.write("\t\t\t\t\t\t\t\t\t    error: function(xhr, textStatus, error){\n");
      out.write("\t\t\t\t\t\t\t\t\t        console.log(\"status: \"+textStatus);\n");
      out.write("\t\t\t\t\t\t\t\t\t        console.log(\"error: \"+error);\n");
      out.write("\t\t\t\t\t\t\t\t\t    }\n");
      out.write("\t\t\t\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t}).focus(function() {\n");
      out.write("\t\t\t\t\t\t\t\t$(this).autocomplete(\"search\", \"\");\n");
      out.write("\t\t\t\t\t\t\t});\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t\t\t\t//****************************************************************************************\n");
      out.write("\t\t\t\t\t\t\t//\n");
      out.write("\t\t\t\t\t\t\t//Halls\n");
      out.write("\t\t\t\t\t\t\t//\n");
      out.write("\t\t\t\t\t\t\t//****************************************************************************************\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t$('#hall-remains').autocomplete({\n");
      out.write("\t\t\t\t\t\t\t\tsource : halls,\n");
      out.write("\t\t\t\t\t\t\t\tminLength : 0,\n");
      out.write("\t\t\t\t\t\t\t\tscroll : true,\n");
      out.write("\t\t\t\t\t\t\t\tselect:function(event, ui)\n");
      out.write("\t\t\t\t\t\t\t\t{\n");
      out.write("\t\t\t\t\t\t\t\t\thallSelected=ui.item.value;\t\n");
      out.write("\t\t\t\t\t\t\t\t\tconsole.log(\"hall selected:\"+hallSelected);\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t//clean the input value below\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\"#court-remains\").val('');\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t$.ajax({\n");
      out.write("\t\t\t\t\t\t\t\t\t    type: 'POST',\n");
      out.write("\t\t\t\t\t\t\t\t\t    url: hallURL,\n");
      out.write("\t\t\t\t\t\t\t\t\t    async: false,\n");
      out.write("\t\t\t\t\t\t\t\t\t    data: hallSelected,\n");
      out.write("\t\t\t\t\t\t\t\t\t    \n");
      out.write("\t\t\t\t\t\t\t\t\t    contentType: \"application/json; charset=utf-8\", \n");
      out.write("\t\t\t\t\t\t\t\t\t    \n");
      out.write("\t\t\t\t\t\t\t\t\t    success: function(data) {\n");
      out.write("\t\t\t\t\t\t\t\t\t       console.log('response data = ' + JSON.stringify(data));\t\t\t\t\t\t\t\t\t       \n");
      out.write("\t\t\t\t\t\t\t\t\t       \n");
      out.write("\t\t\t\t\t\t\t\t\t       //unblock court\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$(\"#court-remains\").prop('disabled',false);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t//****************************************************************************************\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t//\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t// get Courts available in that hall\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t//\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t//****************************************************************************************\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t       \n");
      out.write("\t\t\t\t\t\t\t\t\t       \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t$.getJSON(courtURL, {\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttags : \"court\",\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttagmode : \"any\",\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tformat : \"json\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}).done(\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfunction(data) {\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tconsole.log(\"Courts JSON: \"\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ JSON.stringify(data));\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcourts.length=0;\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tvar i;\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tfor (i = 0; i < data.length; i++)\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcourts.push(data[i].name);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t});\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t       \n");
      out.write("\t\t\t\t\t\t\t\t\t       \n");
      out.write("\t\t\t\t\t\t\t      \n");
      out.write("\t\t\t\t\t\t\t\t\t    },\n");
      out.write("\t\t\t\t\t\t\t\t\t    error: function(xhr, textStatus, error){\n");
      out.write("\t\t\t\t\t\t\t\t\t        console.log(\"status: \"+textStatus);\n");
      out.write("\t\t\t\t\t\t\t\t\t        console.log(\"error: \"+error);\n");
      out.write("\t\t\t\t\t\t\t\t\t    }\n");
      out.write("\t\t\t\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t\t}).focus(function() {\n");
      out.write("\t\t\t\t\t\t\t\t$(this).autocomplete(\"search\", \"\");\n");
      out.write("\t\t\t\t\t\t\t});\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t//****************************************************************************************\n");
      out.write("\t\t\t\t\t\t\t//\n");
      out.write("\t\t\t\t\t\t\t// Courts\n");
      out.write("\t\t\t\t\t\t\t//\n");
      out.write("\t\t\t\t\t\t\t//****************************************************************************************\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t$('#court-remains').autocomplete({\n");
      out.write("\t\t\t\t\t\t\t\tsource : courts,\n");
      out.write("\t\t\t\t\t\t\t\tminLength : 0,\n");
      out.write("\t\t\t\t\t\t\t\tscroll : true,\n");
      out.write("\t\t\t\t\t\t\t\tselect:function(event, ui)\n");
      out.write("\t\t\t\t\t\t\t\t{\n");
      out.write("\t\t\t\t\t\t\t\t\tcourtSelected=ui.item.value;\t\n");
      out.write("\t\t\t\t\t\t\t\t\tconsole.log(\"capability Selected:\"+courtSelected);\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t$.ajax({\n");
      out.write("\t\t\t\t\t\t\t\t\t    type: 'POST',\n");
      out.write("\t\t\t\t\t\t\t\t\t    url: courtURL,\n");
      out.write("\t\t\t\t\t\t\t\t\t    async: false,\n");
      out.write("\t\t\t\t\t\t\t\t\t    data: courtSelected,\n");
      out.write("\t\t\t\t\t\t\t\t\t    \n");
      out.write("\t\t\t\t\t\t\t\t\t    contentType: \"application/json; charset=utf-8\", \n");
      out.write("\t\t\t\t\t\t\t\t\t    \n");
      out.write("\t\t\t\t\t\t\t\t\t    success: function(data) {\n");
      out.write("\t\t\t\t\t\t\t\t\t       console.log('response data = ' + JSON.stringify(data));\n");
      out.write("\t\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t    },\n");
      out.write("\t\t\t\t\t\t\t\t\t    error: function(xhr, textStatus, error){\n");
      out.write("\t\t\t\t\t\t\t\t\t        console.log(\"status: \"+textStatus);\n");
      out.write("\t\t\t\t\t\t\t\t\t        console.log(\"error: \"+error);\n");
      out.write("\t\t\t\t\t\t\t\t\t    }\n");
      out.write("\t\t\t\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t\t}).focus(function() {\n");
      out.write("\t\t\t\t\t\t\t\t$(this).autocomplete(\"search\", \"\");\n");
      out.write("\t\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t$(\"#reserve-submit\").click(function()\n");
      out.write("\t\t\t\t\t\t\t\t\t{\n");
      out.write("\t\t\t\t\t\t\t\t\t\tname=$(\"#user-name\").val();\n");
      out.write("\t\t\t\t\t\t\t\t\t\temail=$(\"#user-email\").val();\n");
      out.write("\t\t\t\t\t\t\t\t\t\ttele=$(\"#user-tele\").val();\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\tconsole.log(\"name: \"+name);\n");
      out.write("\t\t\t\t\t\t\t\t\t\tconsole.log(\"email: \"+email);\n");
      out.write("\t\t\t\t\t\t\t\t\t\tconsole.log(\"tele: \"+tele);\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t$.ajax({ \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttype: \"POST\",\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\turl: userInfoURL, \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tasync: false,\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t//data: \"{'name':name, 'email':email,'tele':tele}\", \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tdata: name+','+email+','+tele, \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tcontentType: \"application/json; charset=utf-8\", \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t//dataType: \"json\",  \n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tsuccess: function(data) {\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t       console.log('response data = ' + JSON.stringify(data));\t\t\t\t\t\t\t\t\t\t      \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t        window.location=successURL; \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t       \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t    },\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    error: function(xhr, textStatus, error){\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t        console.log(\"status: \"+textStatus);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t        console.log(\"error: \"+error);\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t    }\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n");
      out.write("\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t});\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t});\n");
      out.write("\t\n");
      out.write("\t  function inputDisabledInitialization()\n");
      out.write("  \t  {\n");
      out.write("  \t\t$(\"#capability-search\").prop('disabled',false);\n");
      out.write("  \t  \t$(\".datepicker\").prop('disabled',true);\n");
      out.write("  \t\t$(\"#timeinterval-remains\").prop('disabled',true);\n");
      out.write("  \t\t$(\"#hall-remains\").prop('disabled',true);\n");
      out.write("  \t\t$(\"#court-remains\").prop('disabled',true);  \t\t\n");
      out.write("  \t  }\n");
      out.write("  \t\n");
      out.write("\t\n");
      out.write("\t</script>\n");
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      if (_jspx_meth_tiles_005finsertDefinition_005f0(_jspx_page_context))
        return;
      out.write('\n');
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

  private boolean _jspx_meth_c_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /WEB-INF/views/frontend/reservation.jsp(10,12) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/resources/css/reservation.css");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsertDefinition_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertDefinition
    org.apache.tiles.jsp.taglib.InsertDefinitionTag _jspx_th_tiles_005finsertDefinition_005f0 = new org.apache.tiles.jsp.taglib.InsertDefinitionTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_tiles_005finsertDefinition_005f0);
    _jspx_th_tiles_005finsertDefinition_005f0.setJspContext(_jspx_page_context);
    // /WEB-INF/views/frontend/reservation.jsp(466,0) name = name type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertDefinition_005f0.setName("defaultTemplate");
    _jspx_th_tiles_005finsertDefinition_005f0.setJspBody(new Helper( 0, _jspx_page_context, _jspx_th_tiles_005finsertDefinition_005f0, null));
    _jspx_th_tiles_005finsertDefinition_005f0.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_tiles_005finsertDefinition_005f0);
    return false;
  }

  private boolean _jspx_meth_tiles_005fputAttribute_005f0(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:putAttribute
    org.apache.tiles.jsp.taglib.PutAttributeTag _jspx_th_tiles_005fputAttribute_005f0 = new org.apache.tiles.jsp.taglib.PutAttributeTag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_tiles_005fputAttribute_005f0);
    _jspx_th_tiles_005fputAttribute_005f0.setJspContext(_jspx_page_context);
    _jspx_th_tiles_005fputAttribute_005f0.setParent(_jspx_parent);
    // /WEB-INF/views/frontend/reservation.jsp(467,1) name = name type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fputAttribute_005f0.setName("body");
    _jspx_th_tiles_005fputAttribute_005f0.setJspBody(new Helper( 1, _jspx_page_context, _jspx_th_tiles_005fputAttribute_005f0, null));
    _jspx_th_tiles_005fputAttribute_005f0.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_tiles_005fputAttribute_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(javax.servlet.jsp.tagext.JspTag _jspx_parent, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag) _jspx_parent));
    // /WEB-INF/views/frontend/reservation.jsp(480,13) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/resources/image/sports.jpg");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      throw new SkipPageException();
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private class Helper
      extends org.apache.jasper.runtime.JspFragmentHelper
  {
    private javax.servlet.jsp.tagext.JspTag _jspx_parent;
    private int[] _jspx_push_body_count;

    public Helper( int discriminator, JspContext jspContext, javax.servlet.jsp.tagext.JspTag _jspx_parent, int[] _jspx_push_body_count ) {
      super( discriminator, jspContext, _jspx_parent );
      this._jspx_parent = _jspx_parent;
      this._jspx_push_body_count = _jspx_push_body_count;
    }
    public boolean invoke0( JspWriter out ) 
      throws Throwable
    {
      out.write('\n');
      out.write('	');
      if (_jspx_meth_tiles_005fputAttribute_005f0(_jspx_parent, _jspx_page_context))
        return true;
      out.write('\n');
      return false;
    }
    public boolean invoke1( JspWriter out ) 
      throws Throwable
    {
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t<div class=\"body\">\n");
      out.write("\n");
      out.write("\t\t\t<div id=\"reservation-body\">\n");
      out.write("\n");
      out.write("\t\t\t\t<div class=\"main-zone\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t<div class=\"left-zone\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<div id=\"sports-post\">\n");
      out.write("\t\t\t\t\t\t\t<img alt=\"sports\" class=\"sports-post\"\n");
      out.write("\t\t\t\t\t\t\t\tsrc=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_parent, _jspx_page_context))
        return true;
      out.write("\">\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t<div class=\"right-zone\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t\t<p class=\"reservation-header\">Reservation Form</p>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<div id=\"reservation-form\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-field\">\n");
      out.write("\t\t\t\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"capability-search\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\tplaceholder=\"Sports Name\" value=\"\">\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-field\">\n");
      out.write("\t\t\t\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"datepicker\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\tplaceholder=\"Reserve Date\" />\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-field\">\n");
      out.write("\t\t\t\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"timeinterval-remains\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\tplaceholder=\"Time Available\" value=\"\">\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-field\">\n");
      out.write("\t\t\t\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"hall-remains\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\tplaceholder=\"Halls Available\" value=\"\">\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-field\">\n");
      out.write("\t\t\t\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"court-remains\"\n");
      out.write("\t\t\t\t\t\t\t\t\t\tplaceholder=\"Courts Available\" value=\"\">\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-field\">\n");
      out.write("\t\t\t\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"user-name\" placeholder=\"Name\" value=\"\">\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-field\">\n");
      out.write("\t\t\t\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"user-email\" placeholder=\"Email\" value=\"\">\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-field\">\n");
      out.write("\t\t\t\t\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"user-tele\" placeholder=\"Tele\" value=\"\">\n");
      out.write("\t\t\t\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t\t\t\t<span>\n");
      out.write("\t\t\t\t\t\t\t\t\t<button id=\"reserve-submit\" type=\"submit\" class=\"myButton\">Submit</button>\n");
      out.write("\t\t\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\t");
      return false;
    }
    public void invoke( java.io.Writer writer )
      throws JspException
    {
      JspWriter out = null;
      if( writer != null ) {
        out = this.jspContext.pushBody(writer);
      } else {
        out = this.jspContext.getOut();
      }
      try {
        this.jspContext.getELContext().putContext(JspContext.class,this.jspContext);
        switch( this.discriminator ) {
          case 0:
            invoke0( out );
            break;
          case 1:
            invoke1( out );
            break;
        }
      }
      catch( Throwable e ) {
        if (e instanceof SkipPageException)
            throw (SkipPageException) e;
        throw new JspException( e );
      }
      finally {
        if( writer != null ) {
          this.jspContext.popBody();
        }
      }
    }
  }
}
