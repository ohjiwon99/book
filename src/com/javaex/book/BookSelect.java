package com.javaex.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSelect {

	public static void main(String[] args) {
		//  책 전체리스트
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
					query += " select book_id, ";
					query += "        title, ";
					query += "        pubs, ";
					query += "        pub_date, ";
					query += "        author_id ";
					query += " from book ";

					// 바인딩
					pstmt = conn.prepareStatement(query);
					// 없어서 안함

					// 실행
					rs = pstmt.executeQuery();

					// 4.결과처리
					while (rs.next()) {

						/*
						 * int id = rs.getInt("author_id"); -- 전체돌기 String name=
						 * rs.getString("author_name"); String desc= rs.getString("author_desc");
						 */

						int id = rs.getInt(1); // 순서로 넣어줘도 된다.
						String name = rs.getString(2);
						String desc = rs.getString(3);

						System.out.println(id + "," + name + "," + desc);
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
