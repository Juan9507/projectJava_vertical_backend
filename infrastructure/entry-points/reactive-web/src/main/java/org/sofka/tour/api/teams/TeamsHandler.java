package org.sofka.tour.api.teams;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.cyclists.Cyclists;
import org.sofka.tour.model.teams.Teams;
import org.sofka.tour.usecase.teams.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class TeamsHandler {
    private final PostTeamsUseCase postTeamsUseCase;
    private final GetTeamsUseCase getTeamsUseCase;

    private final GetByIdTeamUseCase getByIdTeamUseCase;

    private final AddCyclistsToTeamUseCase addCyclistsToTeamUseCase;

    private final GetConsultCyclistsWithCodeTeamUseCase getConsultCyclistsWithCodeTeamUseCase;

    public Mono<ServerResponse> postSaveTeam(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Teams.class)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(postTeamsUseCase.saveTeam(result), Teams.class));

    }
    public Mono<ServerResponse> getListTeams(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getTeamsUseCase.listTeams(),Teams.class);
    }

    public Mono<ServerResponse> getFindTeam(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getByIdTeamUseCase.findTeamWithId(id), Teams.class);
    }

    public Mono<ServerResponse> postAddCyclistWithTeam(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Cyclists.class)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(addCyclistsToTeamUseCase.addCyclistToTeam(result, id), Teams.class));
    }

    public Mono<ServerResponse> getConsultCyclistsWithCodeTeam(ServerRequest serverRequest){
        var code = serverRequest.pathVariable("code");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getConsultCyclistsWithCodeTeamUseCase.consultCyclistsWithCodeTeam(code), Cyclists.class);
    }
}
