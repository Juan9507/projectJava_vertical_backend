package org.sofka.tour.usecase.teams;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.teams.Teams;
import org.sofka.tour.model.teams.gateways.TeamsRepository;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class GetConsultTeamAssociatedCountryUseCase {

    private final TeamsRepository teamsRepository;

    public Flux<Teams> consultTeamAssociatedCountry(String id){
        return teamsRepository.findAll()
                .filter(teams -> teams.getCountryId().equals(id))
                .map(teams -> teams);
    }

}
