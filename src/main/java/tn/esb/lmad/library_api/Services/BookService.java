package tn.esb.lmad.library_api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esb.lmad.library_api.Repositories.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepos;
}
