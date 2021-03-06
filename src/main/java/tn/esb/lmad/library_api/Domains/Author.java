package tn.esb.lmad.library_api.Domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data //permet de remplacer @Getter, @Setter, @RequiredArgsConstructor, @ToString et @EqualsAndHashCode
@NoArgsConstructor
@ToString(exclude ="photoPath")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Author {
    @Id
    //@GeneratedValue //la clé primaire est génrée automatiquement
    @GeneratedValue(strategy = GenerationType.IDENTITY) //la valeur de la clé primaire du 1er author sera 1, le suivant 2,...
    private Long id;
    @NonNull
    @EqualsAndHashCode.Include
    private String firstName;
    @NonNull
    @EqualsAndHashCode.Include
    private String lastName;
    @JsonFormat(pattern ="dd/MM/yyyy")
    private LocalDate birthDate;
    @NonNull
    private String Nationality;
    private String description;
    private String photoPath;
    @ManyToMany //pour dire que cet attribut est ajouté suite à une relation [n-n] entre Athor et Book
    //creation de la table association
    @JoinTable(name="writting_table",   // le nom de la table association dans la BD
          joinColumns = @JoinColumn(name = "author_id",referencedColumnName = "id"),
            inverseJoinColumns=@JoinColumn(name = "isbn_code",referencedColumnName="isbnCode")
    )
    private Set<Book> authorBooks = new HashSet<>(); //On a ajouté l'attribut comme Set car on ne peut pas accepeter qu'un Book soit ecrit plusieurs fois par le même auteur
}
