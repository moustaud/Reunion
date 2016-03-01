<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleEmployeeServiceProxyid" scope="session" class="DefaultNamespace.EmployeeServiceProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleEmployeeServiceProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleEmployeeServiceProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleEmployeeServiceProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        DefaultNamespace.EmployeeService getEmployeeService10mtemp = sampleEmployeeServiceProxyid.getEmployeeService();
if(getEmployeeService10mtemp == null){
%>
<%=getEmployeeService10mtemp %>
<%
}else{
        if(getEmployeeService10mtemp!= null){
        String tempreturnp11 = getEmployeeService10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String url_1id=  request.getParameter("url16");
            java.lang.String url_1idTemp = null;
        if(!url_1id.equals("")){
         url_1idTemp  = url_1id;
        }
        String db_login_2id=  request.getParameter("db_login18");
            java.lang.String db_login_2idTemp = null;
        if(!db_login_2id.equals("")){
         db_login_2idTemp  = db_login_2id;
        }
        String db_mdp_3id=  request.getParameter("db_mdp20");
            java.lang.String db_mdp_3idTemp = null;
        if(!db_mdp_3id.equals("")){
         db_mdp_3idTemp  = db_mdp_3id;
        }
        String equivalent_userName_4id=  request.getParameter("equivalent_userName22");
            java.lang.String equivalent_userName_4idTemp = null;
        if(!equivalent_userName_4id.equals("")){
         equivalent_userName_4idTemp  = equivalent_userName_4id;
        }
        String equivalent_mdp_5id=  request.getParameter("equivalent_mdp24");
            java.lang.String equivalent_mdp_5idTemp = null;
        if(!equivalent_mdp_5id.equals("")){
         equivalent_mdp_5idTemp  = equivalent_mdp_5id;
        }
        String userName_6id=  request.getParameter("userName26");
            java.lang.String userName_6idTemp = null;
        if(!userName_6id.equals("")){
         userName_6idTemp  = userName_6id;
        }
        String mdp_7id=  request.getParameter("mdp28");
            java.lang.String mdp_7idTemp = null;
        if(!mdp_7id.equals("")){
         mdp_7idTemp  = mdp_7id;
        }
        boolean verifyEmployee13mtemp = sampleEmployeeServiceProxyid.verifyEmployee(url_1idTemp,db_login_2idTemp,db_mdp_3idTemp,equivalent_userName_4idTemp,equivalent_mdp_5idTemp,userName_6idTemp,mdp_7idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(verifyEmployee13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>