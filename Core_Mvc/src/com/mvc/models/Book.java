package com.mvc.models;

public class Book {
private int id;
private String title;
private String ISBN;
private String author;
private double price;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getISBN() {
	return ISBN;
}
public void setISBN(String iSBN) {
	ISBN = iSBN;
}
public String getAuthor() {
	return author;
}
@Override
public String toString() {
	return "Book [id=" + id + ", title=" + title + ", ISBN=" + ISBN + ", author=" + author + ", price=" + price + "]";
}
public void setAuthor(String author) {
	this.author = author;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}


}
