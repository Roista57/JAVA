package Mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MariadbExample {
	public MariadbExample() {
		dataInput();
		dataOutput();
	}
	private void dataInput(){
		String URL = "jdbc:mariadb://localhost:3306/database_name";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "ID", "PASSWORD");
			if (conn != null) {
				// 데이터 테이블에 추가
				String sqlCommand2 = "INSERT IGNORE INTO daily_price (code, date, close) VALUES (?, ?, ?)";
				pstmt = conn.prepareStatement(sqlCommand2);
				pstmt.setString(1, "String_code_data");
				pstmt.setString(2, "String_date_data");
				pstmt.setString(3, "String_close_data");
				pstmt.executeUpdate();
			}
			pstmt.close();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
		}
	}
	
	private void dataOutput(){
		ArrayList<String> code = new ArrayList<String>();
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> close = new ArrayList<String>();
		String URL = "jdbc:mariadb://localhost:3306/database_name";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "ID", "PASSWORD");
			if (conn != null) {
				System.out.println("DB 접속 성공");
				String sql = "SELECT * FROM table_name";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					code.add(rs.getString("code"));
					date.add(rs.getString("code"));
					close.add(rs.getString("code"));
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
		}
	}
	
	public static void main(String[] args) {
		new MariadbExample();
	}
}
