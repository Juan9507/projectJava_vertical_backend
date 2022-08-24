package org.sofka.tour.usecase.teams;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.cyclists.Cyclists;
import org.sofka.tour.model.teams.gateways.TeamsRepository;
import reactor.core.publisher.Flux;

import java.util.List;

@RequiredArgsConstructor
public class GetConsultCyclistsWithCodeTeamUseCase {

    private final TeamsRepository teamsRepository;

    public Flux<List<Cyclists>> consultCyclistsWithCodeTeam(String code){
        return teamsRepository.findAll()
                .filter(teams -> teams.getCode().equals(code))
                .map(teams -> teams.getCyclists());
    }
}
