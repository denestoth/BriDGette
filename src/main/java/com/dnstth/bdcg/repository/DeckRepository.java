package com.dnstth.bdcg.repository;

import com.dnstth.bdcg.model.Deck;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * Deck repository.
 *
 * @author Denes Toth
 */
@Component
public interface DeckRepository extends MongoRepository<Deck, String> {
}
