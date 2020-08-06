package com.member.lib.service.impl;

import java.sql.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.common.Connector;
import com.member.lib.dao.BookDAO;
import com.member.lib.dao.impl.BookDAOImpl;
import com.member.lib.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDAO bookDAO = new BookDAOImpl();

	@Override
	public Map<String, Object> insertBook(Map<String, Object> Book) {
		Map<String, Object> rMap = new HashMap<>();
		int result = bookDAO.insertBook(Book);
		rMap.put("msg", (result == 1) ? "도서입력성공~" : "도서입력시루패");
		rMap.put("cnt", result);
		return rMap;

	}

	@Override
	public Map<String, Object> updateBook(Map<String, Object> Book) {
		Map<String, Object> rMap = new HashMap<>();
		int result = bookDAO.updateBook(Book);
		rMap.put("msg", (result == 1) ? "도서업성공~" : "도서업시루패");
		rMap.put("msg", result);
		return rMap;
	}

	@Override
	public Map<String, Object> deleteBook(int mNum) {
		Map<String, Object> rMap = new HashMap<>();
		int result = bookDAO.deleteBook(mNum);
		rMap.put("msg", (result == 1) ? "도서제거성공~" : "도서제거시루패");
		rMap.put("msg", result);
		return rMap;
	}

	@Override
	public List<Map<String, Object>> selectBookList(Map<String, Object> Book) {
		return bookDAO.selectBookList(Book);
		
	}

	@Override
	public Map<String, Object> selectBook(int mNum) {
		return bookDAO.selectBook(mNum);
	
	}

	public static void main(String[] args) {
		BookService bookService = new BookServiceImpl();
		Map<String, Object> map = new HashMap<>();

		map.put("b_title", "컴활능력");
		map.put("b_author", "견본");
		map.put("b_desc", "셤쨩");
		System.out.println(bookService.insertBook(map));
	}
}
