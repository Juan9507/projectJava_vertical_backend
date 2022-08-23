package org.sofka.tour.usecase.cyclists;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.cyclists.Cyclists;
import org.sofka.tour.model.cyclists.gateways.CyclistsRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PutCyclistsUseCase {
    private final CyclistsRepository cyclistsRepository;
    public Mono<Cyclists> updateCyclist(String id, Cyclists cyclists){
        cyclists.setId(id);
        return cyclistsRepository.save(cyclists);
    }
}
