package org.sofka.tour.usecase.cyclists;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.cyclists.Cyclists;
import org.sofka.tour.model.cyclists.gateways.CyclistsRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PostCyclistsUseCase {
    private final CyclistsRepository cyclistsRepository;
    public Mono<Cyclists> saveCyclists(Cyclists cyclists){
        return cyclistsRepository.save(cyclists);
    }
}
