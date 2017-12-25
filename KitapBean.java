package bilgeadam.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import java.util.*;

import bilgeadam.dao.BookDAOImpl;
import bilgeadam.model.Book;
@ManagedBean
@ViewScoped
public class KitapBean {
     public KitapBean() {
		super();
	}

	private List<Book> books=new ArrayList<Book>();
     @ManagedProperty(value="#{bdi}")
     private BookDAOImpl impl;
     public BookDAOImpl getImpl() {
		return impl;
	}
	public void setImpl(BookDAOImpl impl) {
		this.impl = impl;
	}
	@PostConstruct
     public void init() {
    	 books = impl.tumKitaplariGetir();
     }
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
