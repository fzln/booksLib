package books.services.impl;

import books.entities.Book;
import books.repository.BooksRepository;
import books.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by f on 10.08.16.
 */
@Service("bookService")
@Transactional
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksRepository booksRepository;

    @Override
    public Book add(Book book) {
        return booksRepository.saveAndFlush(book);
    }

    @Override
    public void update(Book book) {
        booksRepository.saveAndFlush(book);
    }

    @Override
    public void delete(Book book) {
        booksRepository.delete(book);
    }

    @Override
    public void deleteAll() {
        booksRepository.deleteAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Book findById(Long bookId) {
        return booksRepository.findOne(bookId);
    }

    @Override
    @Transactional(readOnly = true)
    public Book findByName(String name) {
        return booksRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> listAll() {
        return booksRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return booksRepository.count();
    }
}
