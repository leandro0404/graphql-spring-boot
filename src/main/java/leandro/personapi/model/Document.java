package leandro.personapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table( name = "document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column( name = "Number")
    private String number;

    @Enumerated(EnumType.STRING)
    @Column( name = "Type")
    private DocumentType type;

    @ManyToOne
    @JoinColumn(name = "Person_Id" , nullable = false)
    private Person owner;

    public Document(String number, DocumentType type, Person owner) {
        this.number = number;
        this.type = type;
        this.owner = owner;
    }
}
