package org.sofka.tour.usecase.countries;

import lombok.RequiredArgsConstructor;
import org.sofka.tour.model.countries.Country;
import org.sofka.tour.model.countries.gateways.CountriesRepository;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class GetCountriesUseCase {

    private final CountriesRepository countriesRepository;

    public Flux<Country> listCountries(){
        return countriesRepository.findAll();
    }
}
