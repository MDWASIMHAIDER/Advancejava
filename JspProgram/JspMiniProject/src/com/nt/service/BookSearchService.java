package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.BookBO;
import com.nt.dao.BookSearchDAO;
import com.nt.dto.BookDTO;

public class BookSearchService {
	
	public List<BookDTO> search(String category)throws Exception{
		System.out.println("search");
		BookSearchDAO dao=null;
		List<BookBO> listBO=null;
		List<BookDTO> listDTO=null;
		BookDTO dto=null;
		dao=new BookSearchDAO();
		listBO=dao.findBooks(category);
		System.out.println("after finf method");
		listDTO=new ArrayList<BookDTO>();
		for(BookBO bo:listBO) {
			dto=new BookDTO();
			dto.setBookId(bo.getBookId());
			dto.setBookName(bo.getBookName());
			dto.setAuthor(bo.getAuthor());
			dto.setCategory(bo.getCategory());
			dto.setStatus(bo.getStatus());
			listDTO.add(dto);
		}
		System.out.println("after result method");
		return listDTO;
	}
}
