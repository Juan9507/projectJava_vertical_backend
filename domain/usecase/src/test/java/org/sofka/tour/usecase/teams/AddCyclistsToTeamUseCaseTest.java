package org.sofka.tour.usecase.teams;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.tour.model.cyclists.Cyclists;
import org.sofka.tour.model.teams.Teams;
import org.sofka.tour.model.teams.gateways.TeamsRepository;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddCyclistsToTeamUseCaseTest {

    @Mock
    TeamsRepository teamsRepository;

    @Mock
    PostTeamsUseCase postTeamsUseCase;

    @Mock
    GetByIdTeamUseCase getByIdTeamUseCase;

    @InjectMocks
    AddCyclistsToTeamUseCase addCyclistsToTeamUseCase;

    @Test
    void addCyclistToTeam(){

        var cyclist = new Cyclists("12345","lina morra",123,"col");
        var team = new Teams("fdff","Movistar","2es","A01",new ArrayList<>());

        when(teamsRepository.save(Mockito.any(Teams.class))).thenReturn(Mono.just(team));

        StepVerifier.create(addCyclistsToTeamUseCase.addCyclistToTeam(cyclist, team.getId()))
                .expectNextMatches(teams -> teams.getId().equals("fdff"))
                .expectComplete()
                .verify();

    }
}