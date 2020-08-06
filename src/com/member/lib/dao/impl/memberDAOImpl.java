package com.member.lib.dao.impl;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.Map;

import com.member.lib.common.Connector;
import com.member.lib.dao.MemberDAO;

public class memberDAOImpl implements MemberDAO {

	public int insertmember(Map<String, Object> member) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "insert into member(m_num,m_name,m_id,m_pwd,m_credat)";
			sql += "values(seq_member_m_num.nextval,?,?,?,sysdate" + ")";
			ps = con.prepareStatement(sql);
			ps.setString(1, member.get("m_name").toString());
			ps.setString(2, member.get("m_id").toString());
			ps.setString(3, member.get("m_pwd").toString());
			result = ps.executeUpdate();
			con.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 *
	 */
	/**
	 *
	 */
	@Override
	public int updatemember(Map<String, Object> member) {

		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "update member ";
			sql += "set m_name=?,";
			sql += "m_id=?,";
			sql += "m_pwd=? ";
			sql += "where m_num=?";

			ps = con.prepareStatement(sql);
			ps.setString(1, member.get("m_name").toString());
			ps.setString(2, member.get("m_id").toString());
			ps.setString(3, member.get("m_pwd").toString());
			ps.setInt(4, (int) member.get("m_num"));
			result = ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;

	}

	@Override
	public int deletemember(int mNUM) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "delete from member where m_num=?";

			ps = con.prepareStatement(sql);
			ps.setInt(1, mNUM);
			result = ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> selectmemberList(Map<String, Object> member) {
		List<Map<String, Object>> memberList = new ArrayList<Map<String, Object>>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			con = Connector.open();
			String sql = "select m_num,m_name,m_id,m_credat,m_pwd from member";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("m_num", rs.getInt("m_num"));
				map.put("m_name", rs.getString("m_name"));
				map.put("m_id", rs.getString("m_id"));
				map.put("m_credat", rs.getString("m_credat"));
				map.put("m_pwd", rs.getString("m_pwd"));
				memberList.add(map);
			}
			return memberList;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 *
	 */
	@Override
	public Map<String, Object> selectmember(int mNum) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			con = Connector.open();
			String sql = "select m_num,m_name,m_id,m_credat,m_pwd from member where m_num=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, mNum);
			rs = ps.executeQuery();
			if (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("m_num", rs.getInt("m_num"));
				map.put("m_name", rs.getString("m_name"));
				map.put("m_id", rs.getString("m_id"));
				map.put("m_credat", rs.getString("m_credat"));
				map.put("m_pwd", rs.getString("m_pwd"));
				return map;

			}

		} catch (

		Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void main(String[] args) {
		MemberDAO mdao = new memberDAOImpl();
		Map<String, Object> map = new HashMap<>();
		map.put("m_name", "인혁");
		map.put("m_id", "qwe23kr");
		map.put("m_pwd", "851511");
		// bdao.insertmember(map);
		List<Map<String, Object>> memberList = mdao.selectmemberList(map);
		System.out.println(memberList);
//		map.put("m_num", 3);
//		int result = mdao.updatemember(map);
//		System.out.println("수정갯수:" + result);

	}
}
