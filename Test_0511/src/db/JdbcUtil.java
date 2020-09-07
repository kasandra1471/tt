package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con 
		= DriverManager.getConnection("jdbc:oracle:thin:"
		+ "@//localhost:1521/xe", "hr2", "1234");
		return con;
	}

	// 데이터 베이스는 외부 자원으로 사용후, 자원 반납을 해야 함.
	// close 메소드는 사용한 연결을 닫아서 자원을 돌려주는 역할.
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// import sql.Statement
	// 쿼리문을 담아서 실행해 주는 객체.
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 실행된 쿼리문의 결과를 담는 ResultSet
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 쿼리문 실행 완료.
	public static void commit(Connection con) {
		try {
			con.commit();// sql 에서 봤던 commit
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// commit 의 반대, 전달된 쿼리문의 실행을 취소.
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
