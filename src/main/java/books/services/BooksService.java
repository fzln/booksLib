package books.services;

import books.entities.Book;

import java.util.List;

/**
 * Created by f on 10.08.16.
 */
public interface BooksService {
    public Book add(Book person);

    public void update(Book person);

    public void delete(Book person);
    //public void delete(long id);

    public void deleteAll();

    public Book findById(Long bookId);

    public Book findByName(String name);

    public List<Book> listAll();

    public long count();
}
