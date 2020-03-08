<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
List of Student<br><br>
<c:set var=str value="wasim,bhagwati,neeraz,avnish,anmol" scope="page"/>
<c:forTokens var="sname" items="${str}" delims=" "/>
	<c:out value="${sname}"/><br>
</c:forTokens> --%>