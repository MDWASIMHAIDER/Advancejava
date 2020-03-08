<b>Form B.jsp</b><br>
Attribute(page) value::<%= pageContext.getAttribute("attr1")%><br>
Attribute(request) value::<%= pageContext.getAttribute("attr2")%><br>
Attribute(session) value::<%= pageContext.getAttribute("attr3")%><br>
Attribute(application) value::<%= pageContext.getAttribute("attr4")%>
<jsp:forward page="C.jsp" />