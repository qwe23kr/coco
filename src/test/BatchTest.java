package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.erp.test.common.Conn;

public class BatchTest {
	public static void main(String[] args) {
		if("1"=="2") {
			
		}
		Connection con = Conn.open();
		long sTime = System.currentTimeMillis();
		String sql = "insert into batch_test values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			for(int i=1;i<=1000;i++) {
				ps.setInt(1, i);
				ps.setString(2, "이름" + i);
				ps.addBatch();
				if(i%1000==0) {
					System.out.println(i/1000);
					ps.executeBatch();
					con.commit();
					ps.clearBatch();
				}
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		long eTime = System.currentTimeMillis();
		System.out.println("실행 시간 : " + (eTime-sTime));
	}
	
}

/*
 * select sido,cnt from 
	(select sido,count(1) as cnt 
	from address
	group by sido)
where cnt = (select max(cnt) from 
	(select sido,count(1) as cnt 
	from address
	group by sido));
 * 
 */







