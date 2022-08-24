package org.sofka.tour.usecase.cyclists;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.cyclists.Cyclists;
import org.sofka.tour.model.cyclists.gateways.CyclistsRepository;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ConsultCyclistsWithCountryUseCase {
    private final CyclistsRepository cyclistsRepository;
    public Flux<Cyclists> consultCyclistsWithCountry(String id){
        return cyclistsRepository.findAll()
                .filter(cyclists -> cyclists.getCountryId().equals(id))
                .map(cyclists -> cyclists);
    }
}
