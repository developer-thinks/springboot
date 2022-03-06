package in.samsquare.springboot.service;

import in.samsquare.springboot.dto.CountryDTO;
import in.samsquare.springboot.exceptions.NotFoundException;
import in.samsquare.springboot.model.Country;
import in.samsquare.springboot.repository.CountryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CountryDTO> getAllCountries() {
        List<Country> resultSet = countryRepository.getAllCountries();
        return resultSet.stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    private CountryDTO entityToDTO(Country country){
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setCountryName(country.getCountryName());
        countryDTO.setCapital(country.getCapital());
        countryDTO.setPopulation(country.getPopulation());
        return countryDTO;
    }

    @Override
    public Country getCountryByCode(Long code) {
        try {
            Country country;
            country = countryRepository.getCountryByCode(code);
            return country;
        } catch (Exception e){
            throw new NotFoundException("record Not found");
        }
    }

    @Override
    public Integer saveCountry(Country country) {
        return countryRepository.saveCountry(country.getCode(), country.getCountryName(), country.getCapital(), country.getPopulation());
    }

    @Override
    public Integer updateCountry(Country country, Long code) {
        return countryRepository.updateCountry(country.getCountryName(), country.getCapital(), country.getPopulation(), code);
    }

    @Override
    public Integer deleteCountry(Long code) {
        return countryRepository.deleteCountry(code);
    }
}
