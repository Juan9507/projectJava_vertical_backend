package org.sofka.tour.api.cyclists;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CyclistsRouteRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunctionCyclists(CyclistsHandler cyclistsHandler){
        return route(POST("api/save/cyclists"), cyclistsHandler::PostSaveCyclists)
                .and(route(GET("api/cyclists"), cyclistsHandler::GetListCyclists))
                .andRoute(PUT("api/update/cyclists/{id}"), cyclistsHandler::PutCyclist)
                .andRoute(GET("api/list/cyclists/{id}"), cyclistsHandler::findByIdCyclist)
                .andRoute(DELETE("api/delete/cyclists/{id}"), cyclistsHandler::deleteCyclist)
                .andRoute(GET("api/consult/number/cyclists/{numberCyclist}"), cyclistsHandler::consultCyclistsWithCode);

    }
}
