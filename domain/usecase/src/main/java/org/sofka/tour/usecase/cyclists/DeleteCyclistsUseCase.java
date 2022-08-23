package org.sofka.tour.usecase.cyclists;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.cyclists.gateways.CyclistsRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteCyclistsUseCase {
    private  final CyclistsRepository cyclistsRepository;
    public Mono<Void> deleteCyclist(String id){
        return cyclistsRepository.deleteById(id);
    }
}
