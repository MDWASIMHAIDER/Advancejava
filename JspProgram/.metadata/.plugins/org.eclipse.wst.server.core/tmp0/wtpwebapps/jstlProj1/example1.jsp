<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="var1" value="hello" scope="request"/>
First: <c:out value="${var1 }"/><br>

<c:remove var="var1" scope="request"/>
<c:set var="var2" value="hiiii"/>
Second: <c:out value="${var1}" /><br>
third:${var2 }<br>
fourth::${requestScope.var1 }<br>

<!-- http://localhost:2525/jstlProj1/example1.jsp?uname="wasim" -->
<c:set var="var3" value="welcome"/>
<c:if test="${!empty param.uname }"/>
	<c:out value="${var3}"/>
	<c:out value="${param.uname }"/><br>
	
	
<c:set var="p" scope="request" value="-27"/>
<c:choose>
	<c:when test="${p>0}">
		p is positiive
	</c:when>
	
	<%-- <c:when test="${param.p>0}">
		p is positive
	</c:when> --%>
	<c:when test="${p<0}">
		p is negative
	</c:when>
	<c:otherwise>p is zero</c:otherwise>
</c:choose><br>
<c:out value="${p}"/>



<%request.setAttribute("attr1","atval1");
	session.setAttribute("satt2", "satval2");
	application.setAttribute("apattr3","apval3");
 %><br>
 attr1(req) data::${requestScope.attr1}<br>
 satt2(ses) data::${sessionScope.satt2}<br>
 apattr2(app) data::${applicationScope.apattr3}<br>
 
 
 user-agent request header value::${header['user-agent']}
 accept request header values::${headerValues.accept[0]}<br>
 
 
 
 Cookie name holding sesionid::${cookie.JSESSIONID.name}<br>
 Cookie value::${cookie.JSESSIONID.value}<br>
 
 
 
 ${initParam.user}