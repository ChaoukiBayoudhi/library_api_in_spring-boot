package tn.esb.lmad.library_api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esb.lmad.library_api.Domains.Book;
import tn.esb.lmad.library_api.Repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepos;

     //implementer une méthode qui retourne tous les books
    public ResponseEntity<List<Book>> getAllBooks()
    {
        List<Book> result=bookRepos.findAll();
        if(result.isEmpty())
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    public ResponseEntity<Book> addBook(Book b1)
    {
        Book bRes=bookRepos.save(b1);
        return new ResponseEntity<>(bRes,HttpStatus.CREATED);
    }

    public ResponseEntity<?> getBook(String isbnCode) //? operator =>the return type is varying
    {
        //Optional is a collection that might contain one or zero value
        //to test if Optional variable contains or not a value
        //we can use isPresent() or isEmpty()
        //to get the value contained on the Optional variable => .get()
        Optional<Book> res=bookRepos.findById(isbnCode);
        if(res.isEmpty())
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            //or
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("a book with isbn code = "+ isbnCode+"is not found");//return type is String
//        //return new ResponseEntity<>(res.get(),HttpStatus.OK);
//        //or
//        return ResponseEntity.ok(res.get());
        return ResponseEntity.status(HttpStatus.OK).body(res.get());//return type is Book

    }

//    public ResponseEntity<?> getBooksByAuthor(String firstName, String lastName) {
//    }
}
