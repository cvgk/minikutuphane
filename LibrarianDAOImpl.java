package bilgeadam.dao;

import java.util.List;

import org.hibernate.Session;

import bilgeadam.hibernateutil.HibernateUtil;
import bilgeadam.model.Librarian;



public class LibrarianDAOImpl {
	public List<Librarian> tumCalisanlariGetir(){
    	Session session = HibernateUtil.getSession();
    	@SuppressWarnings("unchecked")
		List<Librarian> librarians = session.createQuery("from Librarian").getResultList();
    	return librarians;
    }
}
