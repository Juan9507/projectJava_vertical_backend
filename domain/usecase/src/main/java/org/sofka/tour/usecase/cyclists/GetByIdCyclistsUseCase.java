package org.sofka.tour.usecase.cyclists;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.cyclists.Cyclists;
import org.sofka.tour.model.cyclists.gateways.CyclistsRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetByIdCyclistsUseCase {
    private final CyclistsRepository cyclistsRepository;
    public Mono<Cyclists> listCyclistWithId(String id){
        return  cyclistsRepository.findById(id);
    }
}
