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
class PostCountryUseCaseTest {

    @InjectMocks
    PostCountriesUseCase postCountriesUseCase;

    @Mock
    CountriesRepository countriesRepository;

    @Test
    public void saveCountryTest(){

        Country country = new Country("sadsds11231", "col", "Colombia");

        when(countriesRepository.save(Mockito.any(Country.class))).thenReturn(Mono.just(country));

        StepVerifier.create(postCountriesUseCase.saveCountry(country))
                .expectNext(country)
                .expectComplete()
                .verify();
    }

}
