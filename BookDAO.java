package bilgeadam.dao;

import java.util.List;

import bilgeadam.model.Book;
import bilgeadam.model.RentedBooks;

public interface BookDAO {
    public List<Book> tumKitaplariGetir();
    public List<RentedBooks> kiralanmisKitaplariGetir();
}
