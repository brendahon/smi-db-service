package com.manulife.ap.smidbservice.infra.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.manulife.ap.smidbservice.model.Message;

/**
 * @author Brenda H Yu
 *
 */
@Repository
public interface MessageRepository extends MongoRepository<Message, String> {

}
