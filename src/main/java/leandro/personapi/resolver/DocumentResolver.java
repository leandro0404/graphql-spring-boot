package leandro.personapi.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import leandro.personapi.input.DocumentInput;
import leandro.personapi.model.Document;
import leandro.personapi.model.Person;
import leandro.personapi.repository.DocumentRepository;
import leandro.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DocumentResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private PersonRepository personRepository;

    public Document saveDocument(DocumentInput input) {
        var owner = personRepository.findById(input.getOwnerId()).get();
        var document = new Document(input.getNumber(), input.getType(), owner);
        return documentRepository.save(document);
    }

}
