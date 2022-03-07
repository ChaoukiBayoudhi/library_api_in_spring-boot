package tn.esb.lmad.library_api.Domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import tn.esb.lmad.library_api.Enumerations.InscriptionType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@ToString(exclude="photo")
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
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthDate;
    @NonNull
    private String email;
    private String phoneNumber;
    @Lob
    private byte[] photo;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endInscriptionDate;
    @Enumerated(EnumType.STRING)
    private InscriptionType type;
    @OneToOne
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    //la ligne ci-dessus est equivalente en SQL à constraint fk_member_address freign key address_id references Address(id)
    private Address address;
    @OneToMany(mappedBy="member",cascade=CascadeType.ALL)
    private Set<Borrowing> borrowings = new HashSet<>();

}
