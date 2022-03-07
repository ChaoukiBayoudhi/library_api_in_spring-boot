package tn.esb.lmad.library_api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import tn.esb.lmad.library_api.Domains.Book;
@RepositoryRestResource
//ou bien
//@Repository
public interface BookRepository extends JpaRepository<Book,String> {
}
