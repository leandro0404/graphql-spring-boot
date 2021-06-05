package leandro.personapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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

    public Person(String name ,  int age,  Gender gender )
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
