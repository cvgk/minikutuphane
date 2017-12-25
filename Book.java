package bilgeadam.model;
import javax.persistence.*;
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"isbn"})})
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	@Column(name="title")
    private String title;
	@Column(name="authorname")
    private String author;
	@Column(name="isbn")
    private String isbn;
	@Column(name="pagenumber")
    private int pageNumber;
	@Column(name="kategori")
	private String kategori;
	@Column(name="adet")
	private int adet;
	
	public Book() {
		super();
	}
	public Book(String title, String author, String isbn, int pageNumber,String kategori,int adet) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.pageNumber = pageNumber;
		this.kategori = kategori;
		this.adet = adet;
	}
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getKategori() {
		return kategori;
	}
	public void setKategori(String kategori) {
		this.kategori = kategori;
	}
	public int getAdet() {
		return adet;
	}
	public void setAdet(int adet) {
		this.adet = adet;
	}
}
