package org.sofka.tour.usecase.countries;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.countries.Country;
import org.sofka.tour.model.countries.gateways.CountriesRepository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PutCountriesUseCase {

    private final CountriesRepository countriesRepository;

    public Mono<Country> updateCountry(String id, Country country){
        country.setId(id);
        return countriesRepository.save(country);
    }
}
