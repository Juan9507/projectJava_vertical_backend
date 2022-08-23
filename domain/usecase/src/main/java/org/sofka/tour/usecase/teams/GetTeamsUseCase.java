package org.sofka.tour.usecase.teams;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.teams.Teams;
import org.sofka.tour.model.teams.gateways.TeamsRepository;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class GetTeamsUseCase {
    private final TeamsRepository teamsRepository;
    public Flux<Teams> listTeams(){
        return teamsRepository.findAll();
    }
}
