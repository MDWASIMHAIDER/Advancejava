package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.BookBO;

public class BookSearchDAO {
	private static final String GET_BOOK_BY_QUERY="SELECT BOOKID,BOOKNAME,AUTHOR,STATUS,CATEGORY FROM BOOK_DETAILS WHERE CATEGORY=?";
	/*private Connection getConnections()throws Exception {
		Connection con=null;
		InitialContext ic=null;
		DataSource ds=null;
		ic=new InitialContext();
		System.out.println("get connetion");
		ds=(DataSource)ic.lookup("java:/comp/env/Dsjndi");
		System.out.println("getting data sourse");
		con=ds.getConnection();
		if(con!=null) {
			System.out.println("con created");
		}
		else {
			System.out.println("not created");
		}
		return con;
	}//get connection
*/	public List<BookBO> findBooks(String category)throws Exception{
		System.out.println("find book "+category);
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<BookBO> listBO=null;
		BookBO bo=null;
		listBO=new ArrayList<BookBO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		if(con!=null) {
			System.out.println("con created");
		}else {
			System.out.println("con not created");
		}
		ps=con.prepareStatement(GET_BOOK_BY_QUERY);
		ps.setString(1,category);
		rs=ps.executeQuery();
		System.out.println("after execute");
		
		while(rs.next()) {
			bo=new BookBO();
			bo.setBooId(rs.getInt(1));
			bo.setBookName(rs.getString(2));
			bo.setAuthor(rs.getString(3));
			bo.setStatus(rs.getString(4));
			bo.setCategory(rs.getString(5));
			listBO.add(bo);
		}
		return listBO;
		
	}
}
