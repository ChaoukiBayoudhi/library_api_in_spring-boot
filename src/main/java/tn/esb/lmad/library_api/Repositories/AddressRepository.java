package tn.esb.lmad.library_api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.esb.lmad.library_api.Domains.Address;
@RepositoryRestResource
public interface AddressRepository extends JpaRepository<Address,Long> {
}
