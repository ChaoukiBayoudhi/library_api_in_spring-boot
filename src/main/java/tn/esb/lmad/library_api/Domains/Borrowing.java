package tn.esb.lmad.library_api.Domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import tn.esb.lmad.library_api.Enumerations.BorrowingState;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Borrowing {
    @EmbeddedId //cet id est composé par les colonnes definies dans la classe BorrowingId annotée par @Embeddable
    @EqualsAndHashCode.Include
    private BorrowingId id;
    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd")
    @EqualsAndHashCode.Include
    private LocalDate loanDate;
    @NonNull
    private int duration;
    @Column(name="borrowing_state",columnDefinition = "REJECTED")
    @Enumerated(EnumType.STRING)
    private BorrowingState state;
    @OneToMany(mappedBy="borrowedBooks",cascade = CascadeType.ALL)
    @MapsId("bookCode")
    private Book book;
    @OneToMany(mappedBy="borrowings",cascade=CascadeType.ALL)
    @MapsId("idMember")
    private Member member;

}
