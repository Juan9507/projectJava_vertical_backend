package org.sofka.tour.usecase.cyclists;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.tour.model.cyclists.Cyclists;
import org.sofka.tour.model.cyclists.gateways.CyclistsRepository;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeleteCyclistsUseCaseTest {

    @InjectMocks
    DeleteCyclistsUseCase deleteCyclistsUseCase;

    @Mock
    CyclistsRepository cyclistsRepository;

    @Test
    void deleteCyclist(){

        var cyclist = new Cyclists("12345","lina morra",123,"col");
        var cyclist2 = new Cyclists("1234","lina morra",123,"col");

        when(cyclistsRepository.deleteById(Mockito.any(String.class))).thenReturn(Mono.empty());

        StepVerifier.create(deleteCyclistsUseCase.deleteCyclist("1234"))
                .expectNext()
                .expectComplete()
                .verify();
    }
}