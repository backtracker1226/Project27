package org.zerock.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbcp.BasicDataSource;

public abstract class AbstrackDAO {

	// 데이터 소스
	private BasicDataSource dataSource;

	// 이 부분 설명 필요하다.
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 생성자
	public AbstrackDAO() throws Exception {

		dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@192.168.0.15:1521:XE");
		dataSource.setUsername("system");
		dataSource.setPassword("880213");
		// 이 부분에 사실 10을 주면 안된다.
		// 톰캣은 기본 150 동접 원래는 WAS랑 디비의 커넥션 풀 갯수는 같게 해주어야 한다.
		dataSource.setInitialSize(10);
		dataSource.setMinIdle(5);
	}

	public void test() {
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select sysdate from dual");
				ResultSet rs = pstmt.executeQuery();) {
			if (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (Exception e) {

		}

	}
}

/*	public static void main(String[] args) throws Exception {

		  AbstrackDAO dao = new AbstrackDAO();
		  
		  long start = System.currentTimeMillis();
		  
		  for(int i=0; i<100; i++){ dao.test(); }
		  
		  long end= System.currentTimeMillis();
		  
		  System.out.println("TOTAL: " + (end - start));
		 

		String sql = "select sysdate from dual";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		long start = System.currentTimeMillis();

		for (int i = 0; i < 10; i++) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.15:1521:XE", "system", "880213");

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

		}

		long end = System.currentTimeMillis();

		System.out.println("TOTAL: " + (end - start));

	}

}*/
