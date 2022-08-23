package org.sofka.tour.mongo.team.repository;

import org.sofka.tour.mongo.team.document.TeamsDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface MongoDBRepositoryTeam extends ReactiveMongoRepository<TeamsDocument, String>, ReactiveQueryByExampleExecutor<TeamsDocument> {

}
