package bilgeadam.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import bilgeadam.dao.BookDAOImpl;
import bilgeadam.model.RentedBooks;

import java.util.*;
@ManagedBean
@ViewScoped
public class RentedKitapBean {
    private List<RentedBooks> listOfRentedBooks;
    
	@ManagedProperty(value="#{bdi}")
    private BookDAOImpl impl;
    public RentedKitapBean() {
		super();
	}
	public List<RentedBooks> getListOfRentedBooks() {
		return listOfRentedBooks;
	}
	public void setListOfRentedBooks(List<RentedBooks> listOfRentedBooks) {
		this.listOfRentedBooks = listOfRentedBooks;
	}
	@PostConstruct
	public void init()
	{
		listOfRentedBooks = impl.kiralanmisKitaplariGetir();
	}
	public void setImpl(BookDAOImpl impl) {
		this.impl = impl;
	}
     
}
