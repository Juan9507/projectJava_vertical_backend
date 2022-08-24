package org.sofka.tour.usecase.cyclists;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.tour.model.cyclists.Cyclists;
import org.sofka.tour.model.cyclists.gateways.CyclistsRepository;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetCyclistsUseCaseTest {

    @InjectMocks
    GetCyclistsUseCase getCyclistsUseCase;

    @Mock
    CyclistsRepository cyclistsRepository;

    @Test
    void FindCyclists(){

        var cyclist = new Cyclists("12345","lina morra",123,"col");
        var cyclist2 = new Cyclists("1234","lina morra",123,"col");

        when(cyclistsRepository.findAll()).thenReturn(Flux.fromIterable(List.of(cyclist,cyclist2)));

        StepVerifier.create(getCyclistsUseCase.ListCyclists())
                .expectNext(cyclist)
                .expectNext(cyclist2)
                .expectComplete()
                .verify();
    }
}