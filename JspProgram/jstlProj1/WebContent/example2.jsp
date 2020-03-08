<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:catch var="e">
	<jsp:scriptlet>
	int a=Integer.parseInt("10a");
	</jsp:scriptlet>>
</c:catch>
<c:out value="e"/><br><br>
how are you??
<c:import url="hello.html"/><br>
<a href="<c:url value="http://localhost:2525/jstlProj1/hello.html"/>">click</a>
