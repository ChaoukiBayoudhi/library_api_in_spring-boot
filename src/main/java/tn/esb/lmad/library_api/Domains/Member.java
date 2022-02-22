package tn.esb.lmad.library_api.Domains;

import lombok.NonNull;
import tn.esb.lmad.library_api.Enumerations.InscriptionType;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private LocalDate birthDate;
    @NonNull
    private String email;
    private String phoneNumber;
    @Lob
    private byte[] photo;
    private LocalDate endInscriptionDate;
    @OneToOne
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    //la ligne ci-dessus est equivalente en SQL à constraint fk_member_address freign key address_id references Address(id)
    private Address address;

}
