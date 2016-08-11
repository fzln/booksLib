package books.repository;

import books.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by f on 10.08.16.
 */
public interface UsersRepository extends JpaRepository<User, Long> {

     User findByName(String name);
}
