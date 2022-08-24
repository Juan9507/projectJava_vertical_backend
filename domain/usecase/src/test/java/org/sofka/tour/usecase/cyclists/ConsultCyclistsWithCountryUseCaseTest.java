package org.sofka.tour.usecase.cyclists;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.tour.model.cyclists.Cyclists;
import org.sofka.tour.model.cyclists.gateways.CyclistsRepository;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsultCyclistsWithCountryUseCaseTest {
    @InjectMocks
    ConsultCyclistsWithCountryUseCase consultCyclistsWithCountryUseCase;
    @Mock
    CyclistsRepository cyclistsRepository;
    @Test
    void consultCyclistsWithCountry(){
        var cyclist = new Cyclists("12345","lina morra",123,"col");
        var cyclist2 = new Cyclists("12344","lina morra",124,"ptr");
        when(cyclistsRepository.findAll()).thenReturn(Flux.fromIterable(List.of(cyclist,cyclist2)));
        StepVerifier.create(consultCyclistsWithCountryUseCase.consultCyclistsWithCountry("ptr"))
                .expectNextMatches(cyclists -> cyclists.getCountryId().equals("ptr"))
                .expectComplete()
                .verify();
    }

}