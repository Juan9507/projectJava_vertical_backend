package org.sofka.tour.mongo.countries.repository;

import org.sofka.tour.model.countries.Country;
import org.sofka.tour.model.countries.gateways.CountriesRepository;
import org.sofka.tour.mongo.countries.document.CountryDocument;
import org.sofka.tour.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<Country, CountryDocument, String, MongoDBRepository>
implements CountriesRepository
{

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Country.class));
    }

}
