package leandro.personapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Data
@NoArgsConstructor
@Entity
@Table( name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;

    @Column( name = "Name")
    private  String name;
    @Column( name = "Age")
    private int age;

    @Enumerated(EnumType.STRING)
    @Column( name = "Gender")
    private Gender gender;

    @OneToMany(mappedBy = "owner")
    private Collection<Document> documents;

    public Person(String name ,  int age,  Gender gender )
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
