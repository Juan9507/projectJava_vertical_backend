package org.sofka.tour.api.countries;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.countries.Country;
import org.sofka.tour.usecase.countries.GetCountriesUseCase;
import org.sofka.tour.usecase.countries.PostCountriesUseCase;
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


    public Mono<ServerResponse> PostSaveCountry(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Country.class)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON).body(postCountriesUseCase.saveCountry(result), Country.class));
    }

    public Mono<ServerResponse> GetListCountries(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getCountriesUseCase.listCountries(), Country.class);
    }
}
