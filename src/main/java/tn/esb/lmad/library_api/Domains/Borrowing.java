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
    @Column(name = "borrowing_id")
    private BorrowingId id;
    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd")
    @EqualsAndHashCode.Include
    private LocalDate loanDate;
    @NonNull
    private int duration;
    @Column(name="borrowing_state", length = 50, columnDefinition = "varchar(50) default 'REJECTED'")
    @Enumerated(EnumType.STRING)
    private BorrowingState state;
    @ManyToOne
    @MapsId("bookCode")
    private Book book;
    @ManyToOne
    @MapsId("idMember")
    private Member member;
    @OneToOne
    private Return returnBooks;

}
