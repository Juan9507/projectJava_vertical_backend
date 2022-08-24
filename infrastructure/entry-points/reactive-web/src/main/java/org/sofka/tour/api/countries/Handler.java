package org.sofka.tour.api.countries;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.countries.Country;
import org.sofka.tour.usecase.countries.DeleteCountryUseCase;
import org.sofka.tour.usecase.countries.GetCountriesUseCase;
import org.sofka.tour.usecase.countries.PostCountriesUseCase;
import org.sofka.tour.usecase.countries.PutCountriesUseCase;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final PostCountriesUseCase postCountriesUseCase;
    private final GetCountriesUseCase getCountriesUseCase;
    private final PutCountriesUseCase putCountriesUseCase;
    private final DeleteCountryUseCase deleteCountryUseCase;

    /*METODOS DE INSERCION*/
    public Mono<ServerResponse> PostSaveCountry(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Country.class)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON).body(postCountriesUseCase.saveCountry(result), Country.class));
    }

    public Mono<ServerResponse> PutUpdateCountry(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Country.class)
                .flatMap(country -> putCountriesUseCase.updateCountry(id, country))
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));
    }

    public Mono<ServerResponse> DeleteCountry(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deleteCountryUseCase.deleteCountry(id), Country.class);
    }

    /*METODOS DE CONSULTAS*/
    public Mono<ServerResponse> GetListCountries(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getCountriesUseCase.listCountries(), Country.class);
    }




}
