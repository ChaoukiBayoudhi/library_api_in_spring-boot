package tn.esb.lmad.library_api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.esb.lmad.library_api.Services.ReturnService;

@RestController
public class ReturnController {
    @Autowired
    private ReturnService returnServ;
}
