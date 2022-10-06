package hu.qlm.flights.web;

import hu.qlm.flights.api.FlightsApi;
import hu.qlm.flights.dto.Airline;
import hu.qlm.flights.service.AirlineService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FlightsController implements FlightsApi {

    @Autowired
    private AirlineService airlineService;
    
    @Override
    public List<Airline> searchFlight(String from, String to) {
        return airlineService.search(from, to);
    }
}
