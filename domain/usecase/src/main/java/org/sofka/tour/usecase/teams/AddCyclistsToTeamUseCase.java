package org.sofka.tour.usecase.teams;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.cyclists.Cyclists;
import org.sofka.tour.model.teams.Teams;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class AddCyclistsToTeamUseCase {

    private final PostTeamsUseCase postTeamsUseCase;

    private final GetByIdTeamUseCase getByIdTeamUseCase;

    public Mono<Teams> addCyclistToTeam(Cyclists cyclists, String teamId){
        return getByIdTeamUseCase.findTeamWithId(teamId)
                .filter(teams -> teams.getCyclists().size() < 8)
                .map(teams -> {
                    List<Cyclists> cyclistsList = new ArrayList<>();
                    teams.getCyclists().forEach(cyclists1 -> cyclistsList.add(cyclists1));
                    cyclistsList.add(cyclists);
                    teams.setId(teamId);
                    teams.setCyclists(cyclistsList);
                    return teams;
                }).flatMap(postTeamsUseCase::saveTeam);

    }

}
