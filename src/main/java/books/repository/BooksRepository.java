package books.repository;

import books.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by f on 10.08.16.
 */
public interface BooksRepository extends JpaRepository<Book, Long> {
    Book findByName(String name);
}
