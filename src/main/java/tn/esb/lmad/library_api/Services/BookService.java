package tn.esb.lmad.library_api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esb.lmad.library_api.Domains.Book;
import tn.esb.lmad.library_api.Repositories.BookRepository;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepos;
     //implementer une méthode qui retourne tous les books
    public ResponseEntity<List<Book>> getAllBooks()
    {
        List<Book> result=bookRepos.findAll();
        if(result.isEmpty())
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
