package pl.urbanik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.urbanik.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
