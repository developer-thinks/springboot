package in.samsquare.springboot.controller;

import in.samsquare.springboot.dto.CountryDTO;
import in.samsquare.springboot.model.Country;
import in.samsquare.springboot.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/country/")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/getall")
    public List<CountryDTO> getAllCountries(){
        return countryService.getAllCountries();
    }

    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable Long code){
        return countryService.getCountryByCode(code);
    }

    @PostMapping("/register")
    public Integer saveCountry(@RequestBody Country country){
        return countryService.saveCountry(country);
    }

    @PutMapping("/update/{code}")
    public Integer updateCountry(@RequestBody Country country, @PathVariable Long code){
        return countryService.updateCountry(country, code);
    }

    @DeleteMapping("/delete/{code}")
    public Integer deleteCountry(@PathVariable Long code){
        return  countryService.deleteCountry(code);
    }
}
