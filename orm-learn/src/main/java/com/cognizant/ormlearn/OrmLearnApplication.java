package com.cognizant.ormlearn;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class); 
	private static CountryService countryService;
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args); 
		countryService = context.getBean(CountryService.class); 
		testGetAllCountries(); 
	}
	
	private static void testGetAllCountries() { 
		LOGGER.info("Start"); 
		List<Country> countries = countryService.getAllCountries(); 
		LOGGER.debug("countries={}", countries); 
		LOGGER.info("End");
	} 
	
	private static void getAllCountriesTest() { 
		try {
			LOGGER.info("Start"); 
			Country country = countryService.findCountryByCode("IN");
			LOGGER.debug("Country:{}", country); 
			LOGGER.info("End");
		} catch (CountryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		} 
	
	private static void testAddCountry() {
		LOGGER.info("Start"); 
		Country country = new Country("SG", "Singapore");
		countryService.addCountry(country);
		LOGGER.debug("Country:{}", country); 
		LOGGER.info("End");
		
	}
	
	private static void testUpdateCountry() {
		LOGGER.info("Start");
		Country country = new Country("MY", "Singapore");
		countryService.updateCountry(country);
		LOGGER.debug("Country:{}", country); 
		LOGGER.info("End");
	}
	
	private static void testDeleteCountry() {
		LOGGER.info("Start");
		countryService.deleteCountry("AS");
		LOGGER.info("End");
	}
}