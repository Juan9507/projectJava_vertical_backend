package org.sofka.tour.api.cyclists;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sofka.tour.model.cyclists.Cyclists;
import org.sofka.tour.usecase.cyclists.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class CyclistsHandler {
    private final PostCyclistsUseCase postCyclistsUseCase;
    private final GetCyclistsUseCase getCyclistsUseCase;
    private final PutCyclistsUseCase putCyclistsUseCase;
    private final GetByIdCyclistsUseCase getByIdCyclistsUseCase;
    private final DeleteCyclistsUseCase deleteCyclistsUseCase;
    private final ConsultCyclistsWithCodeUseCase consultCyclistsWithCodeUseCase;
    private final ConsultCyclistsWithCountryUseCase consultCyclistsWithCountryUseCase;

    /*METODOS DE INSERCION*/
    public Mono<ServerResponse> PostSaveCyclists(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Cyclists.class)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(postCyclistsUseCase.saveCyclists(result), Cyclists.class)
                        .doOnError(ex -> log.error("el codigo ya existe", ex)));


    }

    public Mono<ServerResponse> PutCyclist(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Cyclists.class)
                .flatMap(cyclists -> putCyclistsUseCase.updateCyclist(id, cyclists))
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));
    }

    public Mono<ServerResponse> deleteCyclist(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deleteCyclistsUseCase.deleteCyclist(id), Cyclists.class);
    }

    /*METODOS DE CONSULTAS*/
    public Mono<ServerResponse> GetListCyclists(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getCyclistsUseCase.ListCyclists(), Cyclists.class);
    }

    public Mono<ServerResponse> findByIdCyclist(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getByIdCyclistsUseCase.listCyclistWithId(id), Cyclists.class);
    }

    public Mono<ServerResponse> consultCyclistsWithCode(ServerRequest serverRequest) {
        var numberCyclist = serverRequest.pathVariable("numberCyclist");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(consultCyclistsWithCodeUseCase.consultCyclistsWithCode(Integer.valueOf(numberCyclist)), Cyclists.class);

    }

    public Mono<ServerResponse> consultCyclistsWithCountry(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(consultCyclistsWithCountryUseCase.consultCyclistsWithCountry(id), Cyclists.class);
    }
}
