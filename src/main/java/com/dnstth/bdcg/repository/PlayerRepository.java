package com.dnstth.bdcg.repository;

import com.dnstth.bdcg.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * Player repository.
 *
 * @author Denes Toth
 */
@Component
public interface PlayerRepository extends MongoRepository<Player, String> {
}
