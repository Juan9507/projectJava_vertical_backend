package org.sofka.tour.api.cyclists;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.cyclists.Cyclists;
import org.sofka.tour.usecase.cyclists.GetCyclistsUseCase;
import org.sofka.tour.usecase.cyclists.PostCyclistsUseCase;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CyclistsHandler {
    private final PostCyclistsUseCase postCyclistsUseCase;
    private final GetCyclistsUseCase getCyclistsUseCase;

    public Mono<ServerResponse> PostSaveCyclists(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Cyclists.class)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(postCyclistsUseCase.saveCyclists(result), Cyclists.class ));
    }
    public Mono<ServerResponse> GetListCyclists(ServerRequest serverRequest){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getCyclistsUseCase.ListCyclists(), Cyclists.class);
    }
}
