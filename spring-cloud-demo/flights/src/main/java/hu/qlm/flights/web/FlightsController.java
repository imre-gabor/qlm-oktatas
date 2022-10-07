package hu.qlm.flights.web;

import hu.qlm.flights.api.FlightsApi;
import hu.qlm.flights.dto.Airline;
import hu.qlm.flights.service.AirlineService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FlightsController implements FlightsApi {

    @Autowired
    private AirlineService airlineService;
    
    @Autowired
    HttpServletRequest request;
    
    
    @Override
    public List<Airline> searchFlight(String from, String to) {
    	System.out.println(request.getHeader("x-jwt-username"));
        return airlineService.search(from, to);
    }
}
