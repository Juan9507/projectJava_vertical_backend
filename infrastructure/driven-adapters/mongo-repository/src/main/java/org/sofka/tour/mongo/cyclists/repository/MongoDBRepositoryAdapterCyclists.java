package org.sofka.tour.mongo.cyclists.repository;

import org.reactivecommons.utils.ObjectMapper;
import org.sofka.tour.model.cyclists.Cyclists;
import org.sofka.tour.model.cyclists.gateways.CyclistsRepository;
import org.sofka.tour.mongo.cyclists.document.CyclistsDocument;
import org.sofka.tour.mongo.helper.AdapterOperations;
import org.springframework.stereotype.Repository;


@Repository
public class MongoDBRepositoryAdapterCyclists extends AdapterOperations<Cyclists, CyclistsDocument, String, MongoDBRepositoryCyclists>
        implements CyclistsRepository
{
    public MongoDBRepositoryAdapterCyclists(MongoDBRepositoryCyclists repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Cyclists.class));
    }
}
