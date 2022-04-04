package tn.esb.lmad.library_api.Controllers;

import org.springframework.web.bind.annotation.RestController;
import tn.esb.lmad.library_api.Domains.Borrowing;
import tn.esb.lmad.library_api.Services.BorrowingService;

@RestController
public class BorrowingController {
    private BorrowingService provisioningServ;
}
