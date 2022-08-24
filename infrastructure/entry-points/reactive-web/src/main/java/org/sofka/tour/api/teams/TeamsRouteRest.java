package org.sofka.tour.api.teams;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class TeamsRouteRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunctionTeams(TeamsHandler teamsHandler){
        return route(POST("api/save/team"), teamsHandler::postSaveTeam)
                .and(route(GET("api/list/teams"), teamsHandler::getListTeams))
                .and(route(GET("api/list/teams/{id}"), teamsHandler::getFindTeam))
                .and(route(POST("api/add/team/cyclist/{id}"), teamsHandler::postAddCyclistWithTeam))
                .and(route(GET("api/consult/cyclists/code/teams/{code}"), teamsHandler::getConsultCyclistsWithCodeTeam))
                .and(route(GET("api/consult/team/id/country/{id}"), teamsHandler::getConsultTeamAssociatedCountry));
    }
}
