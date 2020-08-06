package com.member.lib.dao;

import java.util.List;
import java.util.Map;

public interface lentDAO {

	int insertlent(Map<String, Object> lent);

	int updatelent(Map<String, Object> lent);

	int deletelent(int lNum);

	List<Map<String, Object>> selectlentList(Map<String, Object> lent);

	Map<String, Object> selectlent(int lNum);
}
