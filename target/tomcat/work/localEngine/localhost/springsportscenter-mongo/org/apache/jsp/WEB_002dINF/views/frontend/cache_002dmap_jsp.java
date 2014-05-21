package org.apache.jsp.WEB_002dINF.views.frontend;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cache_002dmap_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"http://code.jquery.com/jquery-1.9.1.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<link href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\" ");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write(" \"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f4(_jspx_page_context))
        return;
      out.write("\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f5(_jspx_page_context))
        return;
      out.write("\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"");
      if (_jspx_meth_c_005furl_005f6(_jspx_page_context))
        return;
      out.write("\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<script class=\"code\" type=\"text/javascript\">\n");
      out.write("\n");
      out.write("$(document).ready(function() {\n");
      out.write("\t\t\n");
      out.write("\t  var cacheMapURL=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/getCacheMap\";\n");
      out.write("\t  var pageQuery=0;\n");
      out.write("\t  var dbQuery=0;\n");
      out.write("\n");
      out.write("\t  \t$.ajax({\n");
      out.write("\t\t\t\t\t\t\t\t\t    type: 'GET',\n");
      out.write("\t\t\t\t\t\t\t\t\t    url: cacheMapURL,\n");
      out.write("\t\t\t\t\t\t\t\t\t    async: false,\n");
      out.write("\t\t\t\t\t\t\t\t\t    \n");
      out.write("\t\t\t\t\t\t\t\t\t    contentType: \"application/json; charset=utf-8\", \n");
      out.write("\t\t\t\t\t\t\t\t\t    \n");
      out.write("\t\t\t\t\t\t\t\t\t    success: function(data) {\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t\n");
      out.write("\t\t\t\t\t\t\t\t\t    \tconsole.log(\"cache map JSON: \"\n");
      out.write("\t\t\t\t\t\t\t  \t\t\t\t\t\t+ JSON.stringify(data));\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t\n");
      out.write("\t\t\t\t\t\t\t\t\t    \tvar i;\n");
      out.write("\t\t\t\t\t\t\t\t\t    \tvar endTime=0;\n");
      out.write("\t\t\t\t\t\t\t\t\t    \tvar startTime=0;\n");
      out.write("\t\t\t\t\t\t\t\t\t    \tvar interval=60*60*24;//past day\n");
      out.write("\t\t\t\t\t\t\t\t\t    \tfor (i = data.length-1; i >=0; i--)\n");
      out.write("\t\t\t\t\t\t\t  \t\t\t\t{\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t\tvar temp=new Date(data[i].pageRequestTime).getDay()*60*60*24+new Date(data[i].pageRequestTime).getHours()*60*60+\n");
      out.write("\t\t\t\t\t\t\t    \t\t\t\tnew Date(data[i].pageRequestTime).getMinutes()*60+new Date(data[i].pageRequestTime).getSeconds();\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t\tif(i==data.length-1)\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t\t\tendTime=temp;\t\t\t\t\t\t\t\t\t    \t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t\tif(endTime-temp>=interval)\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t\t{\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t\t\tstartTime=temp;\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t\t\tbreak;\t\t\t\t\t\t\t\t\t    \t\t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t\t}\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t\t\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t\tif(parseInt(data[i].pageQuery)==1)\n");
      out.write("\t\t\t\t\t\t\t  \t\t\t\t\t\tpageQuery++;\n");
      out.write("\t\t\t\t\t\t\t  \t\t\t\t\tif(parseInt(data[i].dbQuery)==1)\n");
      out.write("\t\t\t\t\t\t\t  \t\t\t\t\t\tdbQuery++;\t\t\t\t\t\t\t  \t\t\t\n");
      out.write("\t\t\t\t\t\t\t  \t\t\t\t}\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t\n");
      out.write("\t\t\t\t\t\t\t  \t\t\t\tvar line3=[[\"db query counter\", dbQuery],[\"page query counter: \",pageQuery]];\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t\n");
      out.write("\t\t\t\t\t\t\t\t\t    \tvar plot1 = $.jqplot('chart2', [line3], {\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t    title: 'Cache Map(in the past 24h)',\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t    series:[{renderer:$.jqplot.BarRenderer}],\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t    axesDefaults: {\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t        tickRenderer: $.jqplot.CanvasAxisTickRenderer ,\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t        tickOptions: {\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t          angle: 0,\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t          fontSize: '10pt'\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t        }\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t    },\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t    axes: {\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t      xaxis: {\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t        renderer: $.jqplot.CategoryAxisRenderer\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t      }\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t    }\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t  });\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t\n");
      out.write("\t\t\t\t\t\t\t\t\t    \t\n");
      out.write("\t\t\t\t\t\t\t\t\t    }});\n");
      out.write("\t  \t\n");
      out.write("\n");
      out.write("\t  \t\n");
      out.write("\t\t//end************************************************************************\n");
      out.write("\t});\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      if (_jspx_meth_tiles_005finsertDefinition_005f0(_jspx_page_context))
        return;
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
    // /WEB-INF/views/frontend/cache-map.jsp(7,12) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("/resources/css/jqplot.css");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /WEB-INF/views/frontend/cache-map.jsp(9,37) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("/resources/js/jqplot/jquery.jqplot.min.js");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f2.setParent(null);
    // /WEB-INF/views/frontend/cache-map.jsp(10,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f2.setValue("/resources/js/jqplot/jqplot.dateAxisRenderer.min.js");
    int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
    if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f3.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f3.setParent(null);
    // /WEB-INF/views/frontend/cache-map.jsp(11,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f3.setValue("/resources/js/jqplot/jqplot.barRenderer.min.js");
    int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
    if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f4(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f4 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f4.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f4.setParent(null);
    // /WEB-INF/views/frontend/cache-map.jsp(12,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f4.setValue("/resources/js/jqplot/jqplot.categoryAxisRenderer.min.js");
    int _jspx_eval_c_005furl_005f4 = _jspx_th_c_005furl_005f4.doStartTag();
    if (_jspx_th_c_005furl_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f4);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f5(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f5 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f5.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f5.setParent(null);
    // /WEB-INF/views/frontend/cache-map.jsp(13,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f5.setValue("/resources/js/jqplot/jqplot.canvasTextRenderer.min.js");
    int _jspx_eval_c_005furl_005f5 = _jspx_th_c_005furl_005f5.doStartTag();
    if (_jspx_th_c_005furl_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f5);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f6(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f6 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f6.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f6.setParent(null);
    // /WEB-INF/views/frontend/cache-map.jsp(14,36) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f6.setValue("/resources/js/jqplot/jqplot.canvasAxisTickRenderer.min.js");
    int _jspx_eval_c_005furl_005f6 = _jspx_th_c_005furl_005f6.doStartTag();
    if (_jspx_th_c_005furl_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f6);
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
    // /WEB-INF/views/frontend/cache-map.jsp(90,0) name = name type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
    // /WEB-INF/views/frontend/cache-map.jsp(91,1) name = name type = java.lang.String reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fputAttribute_005f0.setName("body");
    _jspx_th_tiles_005fputAttribute_005f0.setJspBody(new Helper( 1, _jspx_page_context, _jspx_th_tiles_005fputAttribute_005f0, null));
    _jspx_th_tiles_005fputAttribute_005f0.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_tiles_005fputAttribute_005f0);
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
      out.write("\t\t\t<div id=\"cacheMap\"></div>\n");
      out.write("\n");
      out.write("\t\t\t<div >\n");
      out.write("\t\t\t\t<h1>Simple Cache Monitoring for MongoDB</h1>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t<div id=\"chart2\"></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t</div>\n");
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
