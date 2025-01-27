package com.mvc.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.models.Book;
import com.mvc.models.Patient;
import com.mvc.repositry.DataBaseConnection;
import com.mvc.service.BookService;

public class BookServiceImpl implements BookService {
  public static Connection conn=DataBaseConnection.getConnection();
	@Override
	public void addBook(Book b) {
		if( conn != null) {
			String sql="Insert into book(title,ISBN,author,price) values(?,?,?,?)";
			try {
			PreparedStatement stm=conn.prepareStatement(sql);
			stm.setString(1, b.getTitle());
			stm.setString(2, b.getISBN());
			stm.setString(3, b.getAuthor());
			stm.setDouble(4, b.getPrice());
			int affectedRows=stm.executeUpdate();
			if(affectedRows>0) {
				System.out.println("Inserted");
			}
			else {
				System.out.println("Error inserting");
			}
			}
			catch(SQLException e) {
				System.out.println(e);
			}
		}
		
	}

	@Override
	public List<Book> findAllBooks() {
		List<Book> Books = new ArrayList<>();
		if (conn != null) {

			String query = "Select * from book";
			try {
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(query);

				while (rs.next()) {
					Book b=new Book();
					b.setId(rs.getInt("id"));
					b.setTitle(rs.getString("title"));
					b.setISBN(rs.getString("ISBN"));
					b.setAuthor(rs.getString("author"));
					b.setPrice(rs.getDouble("price"));
					Books.add(b);

				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		} else {
			System.out.println("Connection error");
		}
		return Books;
	}

	@Override
	public Book getBookById(int id) {
		Book book=null;
		if (conn != null) {

			String query = "Select * from book where id =" + id;
			try {
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(query);

				while (rs.next()) {
					book=new Book();
					book.setId(rs.getInt("id"));
					book.setTitle(rs.getString("title"));
					book.setISBN(rs.getString("ISBN"));
					book.setAuthor(rs.getString("author"));
					book.setPrice(rs.getDouble("price"));
			         

				}
			} catch (SQLException e) {

			}
		}

		else {
			System.out.println("Connection error");
		}
		return book;
	}

	@Override
	public void updateBook(int id, Book b) {
		if (conn != null) {

			Book book = this.getBookById(id);
			if (book != null) {
				String query = "Update book set title=?,ISBN=?,author=?,price=? where id=?";
						
				try {
					PreparedStatement stm = conn.prepareStatement(query);
					stm.setString(1,b.getTitle());
					stm.setString(2, b.getISBN());
					stm.setString(3, b.getAuthor());
					stm.setDouble(4, b.getPrice());
					stm.setInt(5, id);
					int affectedRows = stm.executeUpdate();
					if (affectedRows > 0) {
						System.out.println("Successfully updated book");
					} else {
						System.out.println("Error updating book");
					}
				} catch (SQLException e) {

				}

			} else {
				System.out.println("Either database is empty or such id doesn't exist in database");
			}
		} else {
			System.out.println("Connectin error");
		}
	
		
	}

	@Override
	public void deleteBookById(int id) {
		if (conn != null) {

			String query = "Delete from book where id = ?";
			try {
				PreparedStatement stm=conn.prepareStatement(query);
				stm.setInt(1, id);
				int affectedRows = stm.executeUpdate();
				if (affectedRows > 0) {
					System.out.println("Book is Successfully deleted");
				} else {
					System.out.println("Error deleting Book");
				}
			} catch (SQLException e) {

			}

		} else {
			System.out.println("Connection error");
		}
		
	}

}
