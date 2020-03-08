<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:choose>
		<c:when test="${booksList ne null}">
		<table><tr><th>BookId</th><th>BookName</th><th>Author</th><th>Status</th><th>category</th></tr>
			<c:forEach var="dto" items="${booksList}">
				<tr>
					<td>${dto.bookId}</td>
					<td>${dto.bookName}</td>
					<td>${dto.author}</td>
					<td>${dto.status}</td>
					<td>${dto.category}</td>
				</tr>
			</c:forEach>
		</table>
		</c:when>
		<c:otherwise>
		<h1>no book found</h1>
		</c:otherwise>
	</c:choose>
	<% 
	List<?>listDTO=null;
    listDTO=request.getAttribute("booksList");
    if(listDTO.size()!=0){ %>
    <h1 style='text-align:center'>books report for<%=request.getParameter("category") %></h1>
    	<table border="1">
    		<%
    			for(BookDTO dto:listDTO){%>
    			<tr>
    				<td><%=dto.getBookId() %></td>
    				<td><%=dto.getBookName() %></td>
    				<td><%=dto.getBookAuthor() %></td>
    				<td><%=dto.getBookStatus() %></td>
    				<td><%=dto.getBookCategory() %></td>
    			</tr>
    		<% }%>
    	</table>
    
    <% }
    else{
	%>    
    <%}%>