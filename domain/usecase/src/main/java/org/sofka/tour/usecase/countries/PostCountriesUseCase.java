package org.sofka.tour.usecase.countries;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.countries.Country;
import org.sofka.tour.model.countries.gateways.CountriesRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PostCountriesUseCase {
    private final CountriesRepository countriesRepository;

    public Mono<Country> saveCountry(Country country){
        return countriesRepository.save(country);
    }
}
