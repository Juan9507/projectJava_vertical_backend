package org.sofka.tour.model.cyclists.gateways;

import org.sofka.tour.model.cyclists.Cyclists;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CyclistsRepository {
    Mono<Cyclists> save(Cyclists cyclists);
    Flux<Cyclists> findAll();
    Mono<Cyclists> findById(String id);
    Mono<Void>  deleteById(String id);

}
