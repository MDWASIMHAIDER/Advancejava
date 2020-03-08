<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,com.nt.dto.BookDTO"%>
<% 
	//make res of this jsp as downloadable excel file response is implicit obj of jsp
	response.setContentType("application/vnd.ms-excel");
	response.addHeader("Content-Disposition","attachment;fileName=Titles.xls");
	//read req attribute value
	List<BookDTO>listDTO=null;
	listDTO=(List<BookDTO>)request.getAttribute("bookList");
	//display database table having records
	if(listDTO.size()!=0){%>
		<h1 style="text-align:center">Books Report For <%=request.getParameter("category") %></h1>
		<table border="1">
			<tr>
			<%
			for(BookDTO dto:listDTO){%>
			<tr>
				<td><%=dto.getBookId() %></td>
				<td><%=dto.getBookName()%></td>
				<td><%=dto.getAuthor()%></td>
				<td><%=dto.getStatus() %></td>
				<td><%=dto.getStatus()%></td>
			</tr>
			<%} %>				
	</table>
	<%}%>
	else<% {%>

	<h1 style="color:green; text-align:center">NO Books Found</h1>
	<%} %>