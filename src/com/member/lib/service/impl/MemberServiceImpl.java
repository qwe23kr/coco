package com.member.lib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.MemberDAO;
import com.member.lib.dao.impl.memberDAOImpl;
import com.member.lib.service.MemberService;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO = new memberDAOImpl();

	@Override
	public Map<String, Object> insertmember(Map<String, Object> member) {
		int result = memberDAO.insertmember(member);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "멤등록완료");
		if (result != 1) {
			rMap.put("msg", "멤등록실패");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> updatemember(Map<String, Object> member) {
		int result = memberDAO.updatemember(member);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "업완료");
		if (result != 1) {
			rMap.put("msg", "업실패");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> deletemember(int mNum) {
		int result = memberDAO.deletemember(mNum);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "멤삭완료");
		if (result != 1) {
			rMap.put("msg", "멤삭실패");
		}
		rMap.put("cnt", result);
		return rMap;

	}

	@Override
	public List<Map<String, Object>> selectmemberList(Map<String, Object> member) {

		return memberDAO.selectmemberList(member);
	}

	@Override
	public Map<String, Object> selectmember(int mNum) {

		return memberDAO.selectmember(mNum);
	}

	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
//		Map<String, Object> rMap = memberService.deletemember(1);
//		System.out.println(rMap);
		Map<String, Object> member = new HashMap<>();
		member.put("m_name", "꾸꾸");
		member.put("m_id", "wu");
		member.put("m_num", 3);
		member.put("m_pwd", "1234");
//		Map<String, Object> rMap = memberService.insertmember(member);
//		System.out.println(rMap);
		List<Map<String, Object>> memberList = memberService.selectmemberList(member);
		for (Map<String, Object> mem : memberList) {
			System.out.println(mem);
		}
		System.out.println(memberService.updatemember(member));

		for (Map<String, Object> mem : memberList) {
			System.out.println(mem);
		}
	}
}
