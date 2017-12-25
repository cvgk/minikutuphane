package bilgeadam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"membername"})})
public class Librarian {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="memberid")
     private int id;
	 @Column(name="membername")
	 private String username;
	 @Column(name="password")
     private String password;
	 @Column(name="yetkiseviyesi")
     private int yetkiSeviyesi;
     public Librarian() {
		super();
	}
	public Librarian(String username, String password,int yetkiSeviyesi) {
		super();
		this.username = username;
		this.password = password;
		this.yetkiSeviyesi = yetkiSeviyesi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getYetkiSeviyesi() {
		return yetkiSeviyesi;
	}
	public void setYetkiSeviyesi(int yetkiSeviyesi) {
		this.yetkiSeviyesi = yetkiSeviyesi;
	}
	
}
