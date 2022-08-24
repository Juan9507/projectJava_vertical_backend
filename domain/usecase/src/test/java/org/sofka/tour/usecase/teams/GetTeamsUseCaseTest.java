package org.sofka.tour.usecase.teams;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.tour.model.teams.Teams;
import org.sofka.tour.model.teams.gateways.TeamsRepository;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetTeamsUseCaseTest {

    @InjectMocks
    GetTeamsUseCase getTeamsUseCase;

    @Mock
    TeamsRepository teamsRepository;

    @Test
    void listTeams(){
        var team1 = new Teams("fdff","Movistar","2es","A01",new ArrayList<>());
        var team2 = new Teams("fdff","Movistar","3es","A02",new ArrayList<>());

        when(teamsRepository.findAll()).thenReturn(Flux.fromIterable(List.of(team1,team2)));

        StepVerifier.create(getTeamsUseCase.listTeams())
                .expectNext(team1)
                .expectNext(team2)
                .expectComplete()
                .verify();
    }
}