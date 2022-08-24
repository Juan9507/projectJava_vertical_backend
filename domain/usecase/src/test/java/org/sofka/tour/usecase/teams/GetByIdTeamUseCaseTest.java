package org.sofka.tour.usecase.teams;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.tour.model.teams.Teams;
import org.sofka.tour.model.teams.gateways.TeamsRepository;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetByIdTeamUseCaseTest {
    @InjectMocks
    GetByIdTeamUseCase getByIdTeamUseCase;
    @Mock
    TeamsRepository teamsRepository;
    @Test
    void findByIdTeamTest(){
        var team = new Teams("fdff","Movistar","2es","A01",new ArrayList<>());
        when(teamsRepository.findById(Mockito.any(String.class))).thenReturn(Mono.just(team));
        StepVerifier.create(getByIdTeamUseCase.findTeamWithId("fdff"))
                .expectNext(team)
                .expectComplete()
                .verify();
    }

}