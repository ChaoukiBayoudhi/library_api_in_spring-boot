package tn.esb.lmad.library_api.Domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Return {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @EmbeddedId
    @EqualsAndHashCode.Include
    private BorrowingId borrowingId;
    @JsonFormat(pattern="yyyy-MM-dd")
    @NonNull
    @EqualsAndHashCode.Include
    private LocalDate returnDate;
    private String description;
    @Column(columnDefinition = "0")
    private int penalty;
}
