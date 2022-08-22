package org.sofka.tour.usecase.cyclists;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.cyclists.Cyclists;
import org.sofka.tour.model.cyclists.gateways.CyclistsRepository;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class GetCyclistsUseCase {
    private final CyclistsRepository cyclistsRepository;
    public Flux<Cyclists> ListCyclists(){
        return cyclistsRepository.findAll();
    }
}
