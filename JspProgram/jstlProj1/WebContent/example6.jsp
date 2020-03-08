<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach var="i" begin="1" end="10" step="1">
	2*${i}=${2*i}<br>
</c:forEach>

<jsp:scriptlet>
	String[] name={"wasim","bhagwati","avnish"};
	request.setAttribute("name", "name");
</jsp:scriptlet>
<c:forEach var="name" items="${names}">
	${name}<br>
</c:forEach>
<![CDATA[
List<String>names1=new ArrayList<String>();
names1.add("raja");names1.add("rani");
request.setAttribute("names1",names1);
]]>
 </jsp:scriptlet>
<c:forEach vafr="name1" items="${names1 }"/>
${name1}<br>
</c:forEach>