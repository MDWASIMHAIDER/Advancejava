<%@page import="com.nt.beans.StudentBeans" %>
<jsp:useBean id="st" class="com.nt.beans.StudentBeans" scope="session"/>
<jsp:setproperty name="st" property="sno" value="101"/>
<jsp:setproperty name="st" property="sname" vlaue="wasim"/>
<jsp:setproperty name="st" property="sadd" value="bhgalpur"/>
<jsp:setproperty name="st" property="savg" vlaue="80"/>
