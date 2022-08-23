package org.sofka.tour.mongo.team.repository;

import org.reactivecommons.utils.ObjectMapper;
import org.sofka.tour.model.teams.Teams;
import org.sofka.tour.model.teams.gateways.TeamsRepository;
import org.sofka.tour.mongo.helper.AdapterOperations;
import org.sofka.tour.mongo.team.document.TeamsDocument;
import org.springframework.stereotype.Repository;


@Repository
public class MongoDBRepositoryAdapterTeam extends AdapterOperations<Teams, TeamsDocument, String, MongoDBRepositoryTeam>
        implements TeamsRepository {

    public MongoDBRepositoryAdapterTeam(MongoDBRepositoryTeam repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Teams.class));
    }
}
