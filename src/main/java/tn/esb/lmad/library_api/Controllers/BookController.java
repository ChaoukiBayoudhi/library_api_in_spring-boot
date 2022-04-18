package tn.esb.lmad.library_api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esb.lmad.library_api.Domains.Book;
import tn.esb.lmad.library_api.Services.BookService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
//The url of this controller is
//http://localhost:9592/books
public class BookController {
    @Autowired
    private BookService bookServ;

    @GetMapping("/all")
    //or
   // @RequestMapping(value="/all",method=RequestMethod.GET)
    //the is
    //http://localhost:9592/books/all
    public ResponseEntity<List<Book>> allBooks()
    {
       return bookServ.getAllBooks();
    }
    @PostMapping("/add")
    //via the RequestBody annotation we tell the server to look for
    // the book value on the body of the request
    public ResponseEntity<Book> newBook(@Valid @RequestBody Book b)
    {
        return bookServ.addBook(b);
    }
}
