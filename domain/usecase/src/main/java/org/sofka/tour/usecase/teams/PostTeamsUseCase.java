package org.sofka.tour.usecase.teams;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.teams.Teams;
import org.sofka.tour.model.teams.gateways.TeamsRepository;
import reactor.core.publisher.Mono;

import java.util.regex.Pattern;

@RequiredArgsConstructor
public class PostTeamsUseCase {
    private final TeamsRepository teamsRepository;
    public Mono<Teams> saveTeam(Teams teams){
        Pattern pat = Pattern.compile("^[\\w]{3}$");
        var validated = pat.matcher(teams.getCode());
        return validated.matches() ? teamsRepository.save(teams) : Mono.empty();
    }
}
