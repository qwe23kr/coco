package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.erp.test.common.Conn;

public class InsertSidoCount {
	static String insertSql = "insert into sido_count(sido,cnt) values(?,?)";
	public static void main(String[] args) {
		Connection con = Conn.open();
		String sql = "select sido, count(1) cnt from address group by sido";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			PreparedStatement ps2 = con.prepareStatement(insertSql);
			while(rs.next()) {
				ps2.setString(1, rs.getString("sido"));
				ps2.setInt(2, rs.getInt("cnt"));
				ps2.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
