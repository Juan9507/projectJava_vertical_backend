package org.sofka.tour.api.countries;

import org.sofka.tour.api.countries.Handler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route(GET("/api/countries"), handler::GetListCountries)
                .andRoute(POST("/api/save/country"), handler::PostSaveCountry)
                .andRoute(PUT("/api/update/country/{id}"), handler::PutUpdateCountry)
                .andRoute(DELETE("/api/delete/country/{id}"), handler::DeleteCountry);
    }
}
