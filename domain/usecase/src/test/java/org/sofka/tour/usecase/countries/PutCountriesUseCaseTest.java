package org.sofka.tour.usecase.countries;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.tour.model.countries.Country;
import org.sofka.tour.model.countries.gateways.CountriesRepository;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PutCountriesUseCaseTest {

    @InjectMocks
    PutCountriesUseCase putCountriesUseCase;

    @Mock
    CountriesRepository countriesRepository;

    @Test
    void updateCountry(){
        var country = new Country("afedjsk","argen","argentina");

        var countryUpdate = country.toBuilder().code("arg").build();

        when(countriesRepository.save(Mockito.any(Country.class))).thenReturn(Mono.just(countryUpdate));

        StepVerifier.create(putCountriesUseCase.updateCountry(countryUpdate.getId(), countryUpdate))
                .expectNextMatches(country1 -> country1.getCode().equals("arg"))
                .expectNextMatches(country1 -> country1.getId().equals("afedjsk"))
                .expectComplete()
                .verify();
    }
}