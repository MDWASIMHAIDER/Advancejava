<%@page import="com.nt.beans.StudentBeans" %>
<jsp:useBean id="st" class="com.nt.beans.StudentBeans" scope="request"/>
<jsp:getproperty name="st" property="sno"/>
<jsp:getproperty name="st" property="sname"/>
<jsp:getproperty name="st" property="sadd"/>
<jsp:getproperty name="st" property="savg"/>
