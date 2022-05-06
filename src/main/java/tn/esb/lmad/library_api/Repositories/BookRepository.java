package tn.esb.lmad.library_api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import tn.esb.lmad.library_api.Domains.Book;

import java.time.LocalDate;
import java.util.List;

@RepositoryRestResource
//ou bien
//@Repository
public interface BookRepository extends JpaRepository<Book,String> {
    //JPQL : Java Persistence Query Language
    @Query(value = "SELECT * FROM Book b1 WHERE b1.release_date < Date(?1)", nativeQuery = true)
    List<Book> booksBeforeDate(String relDate);
}
