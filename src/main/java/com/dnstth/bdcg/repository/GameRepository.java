package com.dnstth.bdcg.repository;

import com.dnstth.bdcg.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * Game repository.
 *
 * @author Denes Toth
 */
@Component
public interface GameRepository extends MongoRepository<Game, String> {
}
