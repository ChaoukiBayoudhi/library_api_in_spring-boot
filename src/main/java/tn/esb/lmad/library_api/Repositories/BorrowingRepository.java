package tn.esb.lmad.library_api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tn.esb.lmad.library_api.Domains.Borrowing;
import tn.esb.lmad.library_api.Domains.BorrowingId;

@RepositoryRestResource
public interface BorrowingRepository extends JpaRepository<Borrowing, BorrowingId> {
}
