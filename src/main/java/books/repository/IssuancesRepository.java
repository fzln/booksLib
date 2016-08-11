package books.repository;

import books.entities.Issuance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by f on 11.08.16.
 */
public interface IssuancesRepository extends JpaRepository<Issuance, Long> {
    List<Issuance> findByReturnDateIsNull();
    List<Issuance> findByOrderByUser();
}
