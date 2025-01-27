package com.mvc.views;

import java.util.List;
import java.util.Scanner;

import com.mvc.models.Book;
import com.mvc.models.Patient;
import com.mvc.serviceImpl.BookServiceImpl;

public class BookMain {
	static BookServiceImpl bookService = new BookServiceImpl();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Enter your choice :");
			System.out.println("/********************************************************");
			System.out.println("1.Add Book");
			System.out.println("2.Get all Books");
			System.out.println("3.Get Book by Id");
			System.out.println("4.Delete Book by id");
			System.out.println("5.Update Book");
			System.out.println("6.Exit");
			System.out.println("********************************************************/");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				addBook(sc);
				break;
			case 2:
				getAllBooks();
				break;
			case 3:
				getBookById(sc);
				break;
			case 4:
				deleteBookById(sc);
				break;
			case 5:
				updateBook(sc);
				break;
			default:
				if (choice != 6) {
					System.out.println("Invalid choice!");
				}

			}
		} while (choice != 6);

		System.out.println("Thank you for using our system.Have a good day!");

	}

	public static void addBook(Scanner sc) {
		Book b = new Book();
	     sc.nextLine();
		System.out.println("Enter book title");
		b.setTitle(sc.nextLine());
		System.out.println("Enter ISBN of book");
		b.setISBN(sc.nextLine());
		System.out.println("Enter author of book");
		b.setAuthor(sc.nextLine());
		System.out.println("Enter price of book");
		b.setPrice(sc.nextDouble());
		bookService.addBook(b);
//	   System.out.println("Title="+b.getTitle());

	}

	public static void getAllBooks() {
		List<Book> books = bookService.findAllBooks();
		if (!books.isEmpty()) {
			System.out.println("_________________________________________________________________");
			System.out.printf("| %4s  | %6s  | %13s | %12s |  %12s|", "Id", "Title", "ISBN", "Author", "Price");
			System.out.println();
			System.out.println("_________________________________________________________________");
			for (Book b : books) {
				System.out.printf("| %4d  | %6s  | %13s | %12s | %12f |", b.getId(), b.getTitle(), b.getISBN(),
						b.getAuthor(), b.getPrice());
				System.out.println();
				System.out.println("________________________________________________________________");
			}
		} else {
			System.out.println("Database is empty");
		}

	}

//
	public static void deleteBookById(Scanner sc) {
		System.out.println("Enter Book id");
		int id = sc.nextInt();
		bookService.deleteBookById(id);
	}

	public static void getBookById(Scanner sc) {
		System.out.println("Enter book id");
		int id = sc.nextInt();
		Book b = bookService.getBookById(id);
		if (b == null) {
			System.out.println("Either database is empty or such id doesn't exist in database");
		} else {

			System.out.println(b);
		}

	}

	public static void updateBook(Scanner sc) {
		Book b = new Book();

		System.out.println("Enter book id which is to be updated");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter  book's new title");
		b.setTitle(sc.nextLine());
		System.out.println("Enter  book's new ISBN");
		b.setISBN(sc.nextLine());
		System.out.println("Enter book's new Author");
		b.setAuthor(sc.nextLine());
		System.out.println("Enter book's new price");
		b.setPrice(sc.nextDouble());
		bookService.updateBook(id, b);
	}

}
