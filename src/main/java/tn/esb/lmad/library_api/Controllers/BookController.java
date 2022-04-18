package tn.esb.lmad.library_api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esb.lmad.library_api.Domains.Book;
import tn.esb.lmad.library_api.Services.BookService;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookServ;

    @GetMapping("/all")
    public ResponseEntity<List<Book>> allBooks()
    {
       return bookServ.getAllBooks();
    }
    @PostMapping("/")
    public ResponseEntity<Book> newBook(Book b)
    {
        return bookServ.addBook(b);
    }
}
