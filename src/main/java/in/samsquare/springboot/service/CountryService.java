package in.samsquare.springboot.service;

import in.samsquare.springboot.dto.CountryDTO;
import in.samsquare.springboot.model.Country;

import java.util.List;

public interface CountryService {

    List<CountryDTO> getAllCountries();
    Country getCountryByCode(Long code);
    Integer saveCountry(Country country);
    Integer updateCountry(Country country, Long code);
    Integer deleteCountry(Long code);

}
