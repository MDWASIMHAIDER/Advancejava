<%@page import="org.omg.CORBA.Request"%>
<% 
int v1=Integer.parseInt(request.getParameter("t1"));
int v2=Integer.parseInt(request.getParameter("t2"));
int sum=v1+v2;
%>
<br>sum is::<%=sum%><br>
<%-- <%!
	public void  jsp_Init(){
		ServletConfig cg=getServletConfig();
		String name=ServletRequest.getInitParameter("user");
	}
 %> --%>
hello