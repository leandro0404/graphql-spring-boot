package leandro.personapi.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import leandro.personapi.input.PersonInput;
import leandro.personapi.model.Person;
import leandro.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class PersonResolver implements GraphQLQueryResolver, GraphQLMutationResolver, GraphQLSubscriptionResolver {

    @Autowired
    private PersonRepository repository;



    public Collection<Person> findAllPeople(){
        return repository.findAll();
    }

    public Person findPersonById(Long id){
        var person =  repository.findById(id).get();
        return person;
    }

    public Person savePerson(PersonInput input){
        return repository.save(new Person(input.getName(), input.getAge(), input.getGender()));
    }

    public Person updateAge (Long id, int age)
    {
        var person = repository.findById(id).get();
        person.setAge(age);
        return repository.save(person);
    }
}