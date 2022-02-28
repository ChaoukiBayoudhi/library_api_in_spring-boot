package tn.esb.lmad.library_api.Domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import tn.esb.lmad.library_api.Enumerations.BorrowingState;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Borrowing {
    @EmbeddedId //cet id est composé par les colonnes definies dans la classe BorrowingId annotée par @Embeddable
    private BorrowingId id;
    @NonNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate loanDate;
    @NonNull
    private int duration;
    @Column(name="borrowing_state",columnDefinition = "REJECTED")
    @Enumerated(EnumType.STRING)
    private BorrowingState state;

}
