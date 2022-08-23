package org.sofka.tour.usecase.cyclists;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.cyclists.Cyclists;
import org.sofka.tour.model.cyclists.gateways.CyclistsRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ConsultCyclistsWithCodeUseCase {

    private final CyclistsRepository cyclistsRepository;

    public Mono<Cyclists> consultCyclistsWithCode(Integer numberCyclist){
        return cyclistsRepository.findAll()
                .filter(cyclists -> cyclists.getNumber() == numberCyclist).next();
    }
}
