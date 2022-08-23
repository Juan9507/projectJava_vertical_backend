package org.sofka.tour.usecase.teams;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.teams.Teams;
import org.sofka.tour.model.teams.gateways.TeamsRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PostTeamsUseCase {
    private final TeamsRepository teamsRepository;
    public Mono<Teams> saveTeam(Teams teams){
        return teamsRepository.save(teams);
    }
}
