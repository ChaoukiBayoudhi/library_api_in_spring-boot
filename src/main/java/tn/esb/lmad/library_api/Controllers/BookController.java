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
    @GetMapping("/{isbnCode}") //{name} => to say that this part of the path is variable
    //http://localhost:9592/books/123-esb-33
    //http://localhost:9592/books/123-esb-44
    //3 ways to send data to the server
    //1-using @RequestBody : to inform the server that the value of the variable is passed on the body of the request
    //2-using @RequestParam : to pass variables values on the path after ?
    //3-using @PathVariable : the variable's value is passed on the path after /
    public ResponseEntity<?> getBookById(@PathVariable String isbnCode)
    {
        return bookServ.getBook(isbnCode);
    }
    //http://localhost:9592/books/author?firstName=jobran&lastName=khalil
  //  @GetMapping("/author")
//    public ResponseEntity<?> getAuthorBooks(@RequestParam String firstName,String lastName)
//    {
//       return bookServ.getBooksByAuthor(firstName,lastName);
//    }
}
