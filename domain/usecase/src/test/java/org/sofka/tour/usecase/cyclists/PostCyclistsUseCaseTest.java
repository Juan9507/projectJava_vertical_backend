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
class PostCyclistsUseCaseTest {

    @InjectMocks
    PostCyclistsUseCase postCyclistsUseCase;

    @Mock
    CyclistsRepository cyclistsRepository;

    @Test
    void saveCyclist(){

        var cyclist = new Cyclists("12345","lina morra",123,"col");

        when(cyclistsRepository.save(Mockito.any(Cyclists.class))).thenReturn(Mono.just(cyclist));

        StepVerifier.create(postCyclistsUseCase.saveCyclists(cyclist))
                .expectNext(cyclist)
                .expectComplete()
                .verify();
    }
}