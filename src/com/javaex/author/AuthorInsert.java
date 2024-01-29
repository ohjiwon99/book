package com.javaex.author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorInsert {

	public static void main(String[] args) {

		// 번호(알아서) 오지원 학생

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		// ResultSet rs = null 아직 필요 없음

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/book_db";
			conn = DriverManager.getConnection(url, "book", "book");

			// 3. SQL문 준비 / 바인딩 / 실행
			// sql문 준비
			String query = "";
			query += " insert into author ";
			query += " values(null, ?, ?) "; // "value(null,'오지원','학생')" 데이터가 오는 자리는 ?(물음표)

			// 바인딩 (물음표에 값을 넣어(매칭시켜)주기)
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "정우성");
			pstmt.setString(2, "영화배우");

			// 실행
			int count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 등록되었습니다.");

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

		}
	}

}
