package com.javaex.author;

public class AuthorVo {

	// 필드
	private int authorid;
	private String authorname;
	private String authordesc;

	// 생성자
	public AuthorVo() {

	}

	public AuthorVo(int authorid, String authorname, String authordesc) {
		this.authorid = authorid;
		this.authorname = authorname;
		this.authordesc = authordesc;
	}

	// 메소드 g/s
	public int getAuthorid() {
		return authorid;
	}

	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getAuthordesc() {
		return authordesc;
	}

	public void setAuthordesc(String authordesc) {
		this.authordesc = authordesc;
	}

	// 일반메소드
	@Override
	public String toString() {
		return "AuthorVo [authorid=" + authorid + ", authorname=" + authorname + ", authordesc=" + authordesc + "]";
	}

}
