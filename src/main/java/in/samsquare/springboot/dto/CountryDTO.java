package in.samsquare.springboot.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO {
    private String countryName;
    private String capital;
    private Long population;



    public CountryDTO() {
    }

    public CountryDTO(String countryName, String capital, Long population) {
        this.countryName = countryName;
        this.capital = capital;
        this.population = population;
    }



    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCapital() {
        return this.capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Long getPopulation() {
        return this.population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }


}
