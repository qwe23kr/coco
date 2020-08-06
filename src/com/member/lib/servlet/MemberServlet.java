package com.member.lib.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.lib.service.MemberService;
import com.member.lib.service.impl.MemberServiceImpl;

public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImpl();
	private void doProcess(HttpServletResponse response, String str) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(str);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String uri = request.getRequestURI();
		String str = "";
		if ("/member/list".equals(uri)) {
			List<Map<String, Object>> memberList = memberService.selectmemberList(null);
		request.setAttribute("memberList", memberList);
		RequestDispatcher rd= request.getRequestDispatcher("/views/member/member-list");
		rd.forward(request,response); 
		return;
			
		} else if ("/member/view".equals(uri)) {
			String m_num = request.getParameter("m_num");
			if (m_num == null || "".equals(m_num.trim())) {
				throw new ServletException("나가");
			}
			int mNum = Integer.parseInt(m_num);
			MemberService memberService = new MemberServiceImpl();
			Map<String, Object> member = memberService.selectmember(mNum);
			request.setAttribute("member", member);
			RequestDispatcher rd= request.getRequestDispatcher("/views/member/member-view");
			rd.forward(request,response); 
			return;
		} else {
			str = "잘못들감여";
		}

		doProcess(response, str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		if ("/member/insert".equals(uri)) {
			String mName = request.getParameter("m_name");
			String mId = request.getParameter("m_id");
			String mPwd = request.getParameter("m_pwd");
			Map<String, Object> member = new HashMap<>();
			member.put("m_name", mName);
			member.put("m_id", mId);
			member.put("m_pwd", mPwd);
			Map<String,Object> rMap= memberService.insertmember(member);

			doProcess(response, rMap.toString());
		}else if("/member/update".equals(uri)) {
			String mName = request.getParameter("m_name");
			String mId = request.getParameter("m_id");
			String mPwd = request.getParameter("m_pwd");
		    int mNum=Integer.parseInt(request.getParameter("m_num"));
			Map<String, Object> member = new HashMap<>();
			member.put("m_name", mName);
			member.put("m_id", mId);
			member.put("m_pwd", mPwd);
			member.put("m_num",mNum);
			doProcess(response, memberService.updatemember(member).toString());
		}else if("/member/delete".equals(uri)) {
			int mNum= Integer.parseInt(request.getParameter("m_num"));
			doProcess(response, memberService.deletemember(mNum).toString());
		}

	}

}
