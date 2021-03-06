package tn.esb.lmad.library_api.Domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="return_book")
public class Return {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @OneToOne(mappedBy="returnBooks",cascade = CascadeType.ALL)
   //clé étrangère composite vers la clé primaire composite de "Borrowing"
   //@MapsId("borrowing_id")
   @JoinColumns(
           {
                   @JoinColumn(name = "book_isbncode", referencedColumnName = "isbn_book_code"),
                   @JoinColumn(name = "member_id", referencedColumnName = "member_id")
           }
   )
   private Borrowing borrowing;


    @JsonFormat(pattern="yyyy-MM-dd")
    @NonNull
    @EqualsAndHashCode.Include
    private LocalDate returnDate;
    private String description;
    @Column(columnDefinition="INT DEFAULT '1'")
    //or
    //@ColumnDefault(value = "0")
    private int penalty;
}
