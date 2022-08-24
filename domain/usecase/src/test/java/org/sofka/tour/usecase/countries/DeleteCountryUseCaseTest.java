package org.sofka.tour.usecase.countries;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
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
class DeleteCountryUseCaseTest {
    @InjectMocks
    DeleteCountryUseCase deleteCountryUseCase;
    @Mock
    CountriesRepository countriesRepository;
    @Test
    void deleteCountryTest(){
        var country1 = new Country("afedjsk","arg","argentina");
        var country2 = new Country("3fbm","braz","brazil");
        when(countriesRepository.deleteById(Mockito.any(String.class))).thenReturn(Mono.empty());
        StepVerifier.create(deleteCountryUseCase.deleteCountry("3fbm"))
                .expectNext()
                .expectComplete()
                .verify();
    }
}