package com.irisi.immo.model.repository;

import com.irisi.immo.model.bean.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

//@Repository
//public interface UserDao extends MongoRepository<User, Long> {
//
//    User findByEmail(String email);
//}
@Repository
public interface UserDao extends Neo4jRepository<User, Long> {

    User findByEmail(String email);
}