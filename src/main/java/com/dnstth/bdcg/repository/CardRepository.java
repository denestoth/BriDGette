package com.dnstth.bdcg.repository;

import com.dnstth.bdcg.model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface CardRepository extends MongoRepository<Card, String> {
}
