package tn.esb.lmad.library_api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.esb.lmad.library_api.Services.BookService;

@RestController
public class BookController {
    @Autowired
    private BookService bookServ;
}
