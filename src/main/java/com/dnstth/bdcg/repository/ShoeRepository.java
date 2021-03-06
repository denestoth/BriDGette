package com.dnstth.bdcg.repository;

import com.dnstth.bdcg.model.Shoe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * Shoe repository.
 *
 * @author Denes Toth
 */
@Component
public interface ShoeRepository extends MongoRepository<Shoe, String> {
}
