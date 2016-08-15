package books.services;

import books.entities.Book;

import java.util.List;

/**
 * Created by f on 10.08.16.
 */
public interface BooksService {
    public Book add(Book book);

    public void update(Book book);

    public void delete(Book book);
    //public void delete(long id);

    public void deleteAll();

    public Book findById(Long bookId);

    public Book findByName(String name);

    public List<Book> listAll();

    public long count();
}
