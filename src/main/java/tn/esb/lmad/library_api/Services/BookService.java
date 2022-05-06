package tn.esb.lmad.library_api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esb.lmad.library_api.Domains.Author;
import tn.esb.lmad.library_api.Domains.Book;
import tn.esb.lmad.library_api.Repositories.BookRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

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

    public ResponseEntity<?> getBooksByAuthor(String authorFirstName, String authorLastName) {
        List<Book> lstBooks =bookRepos.findAll();
        List<Book> lstRes=new ArrayList<>();
        Author a1=new Author();
        a1.setFirstName(authorFirstName);
        a1.setLastName(authorLastName);
        for(Book b1: lstBooks) {
            if(b1.getAuthors().contains(a1))
                lstRes.add(b1);
        }
        if(lstRes.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No books found for this author.");
        return ResponseEntity.status(HttpStatus.OK).body(lstRes);
    }

    //get most borrowed books
    public ResponseEntity<?> getMostBorrowedBooks()
    {
        //find the max count of borrowing
        //if any book borrowed number = max --> return it
        OptionalInt max_broowed=bookRepos.findAll().stream()//convert from list to stream
                .mapToInt(b1->b1.getBorrowedBooks().size())//le nombre de fois ou le book a été emprunté
                .max();
        int max=0;
        if(max_broowed.isPresent())
            max=max_broowed.getAsInt();
        int finalMax = max;
        List<Book> lstRes=bookRepos.findAll().stream()
                .filter(b1->b1.getBorrowedBooks().size()== finalMax)
                .toList();
        if(lstRes.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No borrowing at this moment.");
        return ResponseEntity.status(HttpStatus.OK).body(lstRes);
    }

    //update a book
    public ResponseEntity<?> modifyBook(Book newBook,String isbnCode)
    {
        Optional<Book> res=bookRepos.findById(isbnCode);
        if(res.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No book with isbCod = "+isbnCode);
        Book b1=bookRepos.save(newBook);
        return ResponseEntity.status(HttpStatus.OK).body(b1);
    }
    //remove
    public ResponseEntity<?> removeBook(String isbnCode)
    {
        Optional<Book> res=bookRepos.findById(isbnCode);
        if(res.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No book with isbCod = "+isbnCode);
        bookRepos.deleteById(isbnCode);
        return ResponseEntity.status(HttpStatus.OK).body("The book with isbnCode = "+isbnCode + " has been successfully deleted.");
    }

    public ResponseEntity<?> getBooksBeforeDate(String relDate)
    {
        List<Book> lstRes=bookRepos.booksBeforeDate(relDate);
        if(lstRes.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No books released before "+relDate);
        return ResponseEntity.status(HttpStatus.OK).body(lstRes);

    }
}
