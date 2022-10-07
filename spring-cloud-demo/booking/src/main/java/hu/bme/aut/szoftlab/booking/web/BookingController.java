package hu.bme.aut.szoftlab.booking.web;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.bme.aut.szoftlab.booking.dto.PurchaseData;
import hu.bme.aut.szoftlab.booking.dto.TicketData;
import hu.qlm.currency.api.CurrencyApi;
import hu.qlm.flights.api.FlightsApi;
import hu.qlm.flights.dto.Airline;

@RestController
@RequestMapping("/api")
public class BookingController {

    private static final String STANDARD_CURRENCY = "USD";
    
    @Autowired
    FlightsApi flightsApi;
    
    @Autowired
    CurrencyApi currencyApi;

	@PostMapping("/ticket")
    public PurchaseData buyTicket(@RequestBody TicketData ticketData) {
    	PurchaseData purchaseData = new PurchaseData();
    	
    	List<Airline> foundFlights = flightsApi.searchFlight(ticketData.getFrom(), ticketData.getTo());
    	
    	if(foundFlights.isEmpty()) {
    		purchaseData.setSuccess(false);
    		return purchaseData;
    	}
    	
    	purchaseData.setSuccess(true);
    	
		foundFlights
    	.stream()
    	.forEach(flight -> {
    		String currency = flight.getCurrency();
    		
    		if(!currency.equals(STANDARD_CURRENCY)) {
    			double rate = currencyApi.getRate(currency, STANDARD_CURRENCY);
    			purchaseData.setPrice(flight.getPrice() * rate);
    		}
    	});
    	
    	Airline cheapest = foundFlights.stream().min(Comparator.comparing(Airline::getPrice)).get();
		purchaseData.setPrice(cheapest.getPrice());
		
        return purchaseData;
    }
}
