package org.sofka.tour.usecase.countries;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sofka.tour.model.countries.Country;
import org.sofka.tour.model.countries.gateways.CountriesRepository;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetCountriesUseCaseTest {

    @InjectMocks
    GetCountriesUseCase getCountriesUseCase;

    @Mock
    CountriesRepository countriesRepository;

    @Test
    void listCountry(){
        var country1 = new Country("afedjsk","arg","argentina");
        var country2 = new Country("3fbm","braz","brazil");

        when(countriesRepository.findAll()).thenReturn(Flux.fromIterable(List.of(country1,country2)));

        StepVerifier.create(getCountriesUseCase.listCountries())
                .expectNext(country1)
                .expectNext(country2)
                .expectComplete()
                .verify();
    }
}