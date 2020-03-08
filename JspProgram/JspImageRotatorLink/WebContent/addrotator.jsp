<%-- <%@page import="com.nt.*"  %>> --%>
<h1 style="text-align:center">Image Rotator</h1>
<jsp:useBean id="rotator" class="com.nt.rotator.Rotator" scope="application"/>
<%
 	rotator.nextAdvertisement();
 	response.setHeader("refresh","4");
 %>
 <a href="<jsp:getProperty name="rotator" property="links"/>">
 <img src="<jsp:getProperty name="rotator" property="image"/>" width="700" height="200" style="margin-left: 150px"/>