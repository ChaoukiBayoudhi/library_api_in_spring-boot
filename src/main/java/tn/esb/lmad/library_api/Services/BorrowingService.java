package tn.esb.lmad.library_api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esb.lmad.library_api.Domains.Borrowing;
import tn.esb.lmad.library_api.Repositories.BorrowingRepository;

@Service
public class BorrowingService {
    @Autowired
    private BorrowingRepository borrowingBepos;
}
