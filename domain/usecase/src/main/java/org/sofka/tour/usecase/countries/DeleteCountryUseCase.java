package org.sofka.tour.usecase.countries;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.countries.gateways.CountriesRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteCountryUseCase {
    private final CountriesRepository countriesRepository;

    public Mono<Void> deleteCountry(String id) {
        return countriesRepository.deleteById(id);
    }
}
