package uk.co.dashery.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import uk.co.dashery.data.Token;

public interface TokenRepository extends MongoRepository<Token, String> {

}
