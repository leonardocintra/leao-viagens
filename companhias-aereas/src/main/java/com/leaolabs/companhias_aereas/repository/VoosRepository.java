package com.leaolabs.companhias_aereas.repository;

import com.leaolabs.companhias_aereas.domain.Voo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VoosRepository extends MongoRepository<Voo, ObjectId> {
}
