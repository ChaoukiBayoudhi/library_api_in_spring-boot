package tn.esb.lmad.library_api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esb.lmad.library_api.Repositories.AddressRepository;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepos;
}
