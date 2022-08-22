package org.sofka.tour.mongo.countries.repository;

import org.sofka.tour.mongo.countries.document.CountryDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepository extends ReactiveMongoRepository<CountryDocument, String>, ReactiveQueryByExampleExecutor<CountryDocument> {
}
