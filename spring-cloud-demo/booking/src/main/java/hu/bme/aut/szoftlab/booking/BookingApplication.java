package hu.bme.aut.szoftlab.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import hu.qlm.currency.api.CurrencyApi;
import hu.qlm.flights.api.FlightsApi;

@EnableFeignClients(basePackageClasses = {CurrencyApi.class, FlightsApi.class})
@SpringBootApplication
public class BookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}

}
