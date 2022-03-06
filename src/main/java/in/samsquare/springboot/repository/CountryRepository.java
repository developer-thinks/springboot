package in.samsquare.springboot.repository;

import in.samsquare.springboot.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {


    @Query(value = "SELECT * FROM countries", nativeQuery = true)
    List<Country> getAllCountries();


    @Query(value = "SELECT * FROM countries WHERE code=?", nativeQuery = true)
    Country getCountryByCode(Long code);


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO countries values(:code, :countryName, :capital, :population)", nativeQuery = true)
    Integer saveCountry(@Param("code") Long code, @Param("countryName") String countryName, @Param("capital") String capital, @Param("population") Long population );


    @Transactional
    @Modifying
    @Query(value = "UPDATE countries SET country_name=?, capital=?, population=? WHERE code=?", nativeQuery = true)
    Integer updateCountry(String country_name, String capital, Long population, Long code);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM countries WHERE code=?", nativeQuery = true)
    Integer deleteCountry(Long code);

}
