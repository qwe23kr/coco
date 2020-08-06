package com.member.lib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.MemberDAO;
import com.member.lib.dao.lentDAO;
import com.member.lib.dao.impl.LentDAOImpl;
import com.member.lib.dao.impl.memberDAOImpl;
import com.member.lib.service.LentService;

public class LentServiceImpl implements LentService {
	private lentDAO lentDAO = new LentDAOImpl();
	
	public Map<String, Object> insertLent(Map<String, Object> lent) {
		Map<String, Object> rMap = new HashMap<>();
		int result = lentDAO.insertlent(lent);
		rMap.put("msg", (result == 1) ? "빌리기입력성공~" : "빌리기입력시루패");
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> updateLent(Map<String, Object> lent) {
		Map<String, Object> rMap = new HashMap<>();
		int result = lentDAO.updatelent(lent);
		rMap.put("msg", (result == 1) ? "빌리기 업성공~" : "빌리기업시루패");
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> deleteLent(int lNum) {
		Map<String, Object> rMap = new HashMap<>();
		int result = lentDAO.deletelent(lNum);
		rMap.put("msg", (result == 1) ? "빌리기 업성공~" : "빌리기업시루패");
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public List<Map<String, Object>> selectLentList(Map<String, Object> lent) {
		return lentDAO.selectlentList(lent);
	}

	@Override
	public Map<String, Object> selectLent(int lNum) {
		return lentDAO.selectlent(lNum);
	}
public static void main(String[] args) {
	LentService ldao = new LentServiceImpl();
	Map<String, Object> map = new HashMap<>();


	// bdao.insertmember(map);
	List<Map<String, Object>> lentList = ldao.selectLentList(map);
	System.out.println(lentList);
}
}
