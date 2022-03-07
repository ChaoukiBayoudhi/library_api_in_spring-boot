package tn.esb.lmad.library_api.Domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable //Cette annotation informe l'ORM que cette classe sera utilise dans un autre classe
//Cette classe doit necessairement implementer l'interface Serialisable, definir un constructeur non paramétré, un constructeur paramétré
//getters, setters, redefinition de ToString et hashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingId implements Serializable {
    @Column(name="isbn_book_code")
    private String bookCode;
    @Column(name="member_id")
    private Long idMember;
}
