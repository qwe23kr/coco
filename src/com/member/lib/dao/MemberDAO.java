package com.member.lib.dao;

import java.util.List;
import java.util.Map;

public interface MemberDAO {

	int insertmember(Map<String, Object> member);

	int updatemember(Map<String, Object> member);

	int deletemember(int mNum);

	List<Map<String, Object>> selectmemberList(Map<String, Object> member);

	Map<String, Object> selectmember(int mNum);
}
