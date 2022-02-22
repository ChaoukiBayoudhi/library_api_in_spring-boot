package tn.esb.lmad.library_api.Domains;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "memeber_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private int number;
    @NonNull
    @Column(length =50, name="street_name")
    private String street;
    @NonNull
    private String city;
    @NonNull
    private int postalCode;
    @OneToOne(mappedBy="address",cascade =CascadeType.ALL)
    private Member member;
}
