package com.erp.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.test.service.SelectAddressService;
import com.erp.test.service.impl.SelectAddressServiceImpl;

public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SelectAddressService saService = new SelectAddressServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		System.out.println(request.getParameter("sido"));
		System.out.println(request.getParameter("gugun"));
		PrintWriter pw = response.getWriter();
		List<String> sidoList = saService.selectSidoList(null);
		String str = "[";
		for(String sido:sidoList) {
			str += "\"" + sido + "\",";
		}
		str = str.substring(0,str.length()-1);
		str += "]"; 
		pw.println(str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}





