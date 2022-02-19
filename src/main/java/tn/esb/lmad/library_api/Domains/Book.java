package tn.esb.lmad.library_api.Domains;


import lombok.*;
import tn.esb.lmad.library_api.Enumerations.BookType;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter//permet de generer  tous les setters pour tous les attributs
@NoArgsConstructor //permet de generer un constructeur non paramétré
@AllArgsConstructor //permet de generer un constructeur avec tous les paramètres
@RequiredArgsConstructor //génere un constructeur avec comme paramètres les champs obligatoires
//@ToString //redefini toString en retournant les valeurs de tous les attributs
//@ToString(exclude ={"releaseDate","coverImage"})
@ToString(exclude ="coverImage")
//@EqualsAndHashCode //permet de redefinir EqualsAndHashCode en impliquant tous les attributs dans la comparaison
//@EqualsAndHashCode(exclude ={"releaseDate","coverImage","summary"})//la comparaison sera faite via les attributs non cités dans la clause exclude
@EqualsAndHashCode(onlyExplicitlyIncluded = true)//juste les colonnes annotées avec @EqualsAndHashCode.Include seront utilisées
@Entity //Book va être transformer en une table relationnelle par l'ORM
public class Book {
    @Id
    @EqualsAndHashCode.Include
    private String isbnCode;
    @EqualsAndHashCode.Include
    @NonNull //title est obligatoire
    private String title;
    private LocalDate releaseDate;
    @NonNull
    private int stock;
    @Lob
    private byte[] coverImage;
    private String summary;
    @EqualsAndHashCode.Include
    @NonNull
    @Enumerated(EnumType.STRING)
    private BookType type;

}