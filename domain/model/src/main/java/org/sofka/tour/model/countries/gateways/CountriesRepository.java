package org.sofka.tour.model.countries.gateways;

import org.sofka.tour.model.countries.Country;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface CountriesRepository {
    Mono<Country> save(Country country);
    Flux<Country> findAll();
    Mono<Country> findById(String id);

    Mono<Void> deleteById(String id);
}
