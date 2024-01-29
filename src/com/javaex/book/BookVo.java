package com.javaex.book;

public class BookVo {
	
	//필드
	private int bookId;
	private String bookTitle;
	private String bookPubs;
	private String bookpub_Date;
	private int bookauthorId;
	
	private int authorId;
	private String authorName;
	private String authorDesc;
	
	//생성자
	public BookVo() {}
	
	public BookVo(int bookId, String bookTitle, String bookPubs, String bookpub_Date, int bookauthorId, int authorId,
			String authorName, String authorDesc) {
		
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookPubs = bookPubs;
		this.bookpub_Date = bookpub_Date;
		this.bookauthorId = bookauthorId;
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorDesc = authorDesc;
	}
	//메소드gs
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookPubs() {
		return bookPubs;
	}

	public void setBookPubs(String bookPubs) {
		this.bookPubs = bookPubs;
	}

	public String getBookpub_Date() {
		return bookpub_Date;
	}

	public void setBookpub_Date(String bookpub_Date) {
		this.bookpub_Date = bookpub_Date;
	}

	public int getBookauthorId() {
		return bookauthorId;
	}

	public void setBookauthorId(int bookauthorId) {
		this.bookauthorId = bookauthorId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorDesc() {
		return authorDesc;
	}

	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}

	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookPubs=" + bookPubs + ", bookpub_Date="
				+ bookpub_Date + ", bookauthorId=" + bookauthorId + ", authorId=" + authorId + ", authorName="
				+ authorName + ", authorDesc=" + authorDesc + "]";
	}
	
	public void showInfo() {
		System.out.println(bookId + ".\t" + bookTitle + "\t" + bookPubs + "\t" + bookpub_Date + "\t" + bookauthorId
				+ "\t" + authorId + "\t" + authorName + "\t" + authorDesc);
	}
	
	
	

}
