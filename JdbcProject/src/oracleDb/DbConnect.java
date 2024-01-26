package oracleDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {

	// url
	static final String ORACLE_DB = "jdbc:oracle:thin:@localhost:1521:XE";

	// connect
	public Connection getOracle() { // return 타입 -> Connection
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(ORACLE_DB, "teacher", "a1234");

		} catch (SQLException e) {
			System.out.println("로컬 오라클연결실패!!!");

		}

		return conn;
	}

	// close 메서드 4개(오버로딩으로 만들기)
	public void dbClose(ResultSet rs, Statement stmt, Connection conn) { // resultset은 조회할때 사용

		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void dbClose(Statement stmt, Connection conn) { // insert update delete 할때 사용

		try {

			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// PreparedStatement
	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) { // resultset은 조회할때 사용

		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void dbClose(PreparedStatement pstmt, Connection conn) { // insert update delete 할때 사용

		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
