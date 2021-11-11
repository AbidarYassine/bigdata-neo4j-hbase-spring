package com.irisi.immo.model.repository;

import com.irisi.immo.model.bean.Annonce;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

//@Repository
//public interface AnnonceDao extends MongoRepository<Annonce, String> {
//}

@Repository
public interface AnnonceDao extends Neo4jRepository<Annonce, Long> {
}

