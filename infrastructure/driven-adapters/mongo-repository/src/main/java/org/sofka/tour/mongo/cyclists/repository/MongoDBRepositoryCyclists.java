package org.sofka.tour.mongo.cyclists.repository;

import org.sofka.tour.mongo.cyclists.document.CyclistsDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepositoryCyclists extends ReactiveMongoRepository<CyclistsDocument, String>, ReactiveQueryByExampleExecutor<CyclistsDocument> {

}
