package tn.esb.lmad.library_api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esb.lmad.library_api.Repositories.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepos;
}
