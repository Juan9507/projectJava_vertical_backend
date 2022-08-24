package org.sofka.tour.usecase.teams;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.teams.Teams;
import org.sofka.tour.model.teams.gateways.TeamsRepository;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RequiredArgsConstructor
public class GetByIdTeamUseCase {

    private final TeamsRepository teamsRepository;

    public Mono<Teams> findTeamWithId(String id){
        return Objects.nonNull(id) ? teamsRepository.findById(id) : Mono.empty();
    }
}
