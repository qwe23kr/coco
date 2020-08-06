package com.member.lib.service;

import java.util.List;
import java.util.Map;

public interface MemberService {
	Map<String, Object> insertmember(Map<String, Object> member);

	Map<String, Object> updatemember(Map<String, Object> member);

	Map<String, Object> deletemember(int mNum);

	List<Map<String, Object>> selectmemberList(Map<String, Object> member);

	Map<String, Object> selectmember(int mNum);
}
