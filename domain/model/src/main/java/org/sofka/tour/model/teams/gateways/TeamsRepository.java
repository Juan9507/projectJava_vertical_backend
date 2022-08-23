package org.sofka.tour.model.teams.gateways;

import org.sofka.tour.model.teams.Teams;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TeamsRepository {
    Mono<Teams> save(Teams teams);
    Flux<Teams> findAll();

    Mono<Teams> findById(String id);
}
