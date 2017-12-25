package bilgeadam.dao;
import java.util.*;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.hibernate.Session;

import bilgeadam.hibernateutil.HibernateUtil;
import bilgeadam.model.Book;
import bilgeadam.model.RentedBooks;
@ManagedBean(name = "bdi")
@ApplicationScoped

public class BookDAOImpl implements BookDAO{
	@Override
    public List<Book> tumKitaplariGetir()
    {
    	Session session = HibernateUtil.getSession();
    	session.beginTransaction();
    	@SuppressWarnings("unchecked")
		List<Book> listOfBooks = session.createQuery("from Book").getResultList();
    	return listOfBooks;
    }
	@Override
    public List<RentedBooks> kiralanmisKitaplariGetir()
    {
    	Session session = HibernateUtil.getSession();
    	session.beginTransaction();
    	@SuppressWarnings("unchecked")
		List<RentedBooks> listOfRentedBooks = session.createQuery("from RentedBooks").getResultList();
    	return listOfRentedBooks;
    }
	public Book kitabiBul(String kitapname)
	{
		Session session = HibernateUtil.getSession();
		@SuppressWarnings("unchecked")
		List<Book> list = session.createQuery("from Book").getResultList();
		for(int i=0;i<list.size();i++)
		{
			Book book = list.get(i);
			if(kitapname.equalsIgnoreCase(book.getTitle()))
			{
				return book;
			}
		}
		return null;
	}
}
