package bilgeadam.dao;

import java.util.Date;

import org.hibernate.Session;

import bilgeadam.hibernateutil.HibernateUtil;
import bilgeadam.model.Book;
import bilgeadam.model.Member;
import bilgeadam.model.RentedBooks;

public class RentedBooksDAOImpl {
      public void saveRentedBook(Member member,Book book,Date fd,Date ld)
      {
    	  Session session = HibernateUtil.getSession();
    	  session.beginTransaction();
    	  RentedBooks rb = new RentedBooks(member,book,fd,ld);
    	  session.save(rb);
    	  book.setAdet(book.getAdet()-1);
    	  session.update(book);
    	  session.getTransaction().commit();
    	  session.close();
      }
}
