package com.javaex.author;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AuthorSelect2 {

	public static void main(String[] args) {
		List<AuthorVo> authorList = new ArrayList<AuthorVo>();

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/book_db";
			conn = DriverManager.getConnection(url, "book", "book");

			// 3. SQL문 준비
			String query = "";
			query += " select author_id, ";
			query += "        author_name, ";
			query += "        author_desc "; // ,안오게 잘 띄어주기
			query += " from author; ";

			// 바인딩
			pstmt = conn.prepareStatement(query);
			// 물음표 없음으로 생략

			// 실행
			rs = pstmt.executeQuery();

			// 검색결과에서 데이터 꺼내기
			while (rs.next()) {

				int no = rs.getInt("author_id");
				String name = rs.getString("author_name");
				String desc = rs.getString("author_desc");

				// Vo묶기
				AuthorVo VO = new AuthorVo(no, name, desc);

				// 리스트에 묶기
				authorList.add(VO);
			}

			// 4.결과처리
			System.out.println(authorList.toString());
			// 리스트 이용해서 출력

			for (int i = 0; i < authorList.size(); i++) {
				int no = authorList.get(i).getAuthorid();
				String name = authorList.get(i).getAuthorname();
				String desc = authorList.get(i).getAuthordesc();

				System.out.println(no + "\t" + name + "\t" + desc);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
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
