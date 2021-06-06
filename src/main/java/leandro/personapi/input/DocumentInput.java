package leandro.personapi.input;

import graphql.schema.GraphQLInputType;
import leandro.personapi.model.DocumentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentInput  implements GraphQLInputType {
    @Override
    public String getName() {
        return number;
    }
    private String number;
    private DocumentType type;
    private Long ownerId;
}
