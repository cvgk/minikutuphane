package bilgeadam.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class RentedBooks {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	@OneToOne
    private Member member;
	@OneToOne
    private Book book;
	private Date dateOfRent;
	private Date returnBookDate;
	public RentedBooks() {
		super();
	}
	
	public RentedBooks(Member member, Book book, Date dateOfRent,
			Date returnBookDate) {
		super();
		this.member = member;
		this.book = book;
		this.dateOfRent = dateOfRent;
		this.returnBookDate = returnBookDate;
	}

	public Date getReturnBookDate() {
		return returnBookDate;
	}
	public void setReturnBookDate(Date returnBookDate) {
		this.returnBookDate = returnBookDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Date getDateOfRent() {
		return dateOfRent;
	}
	public void setDateOfRent(Date dateOfRent) {
		this.dateOfRent = dateOfRent;
	}
    
}
