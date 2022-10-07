package hu.qlm.flights.web;

import hu.qlm.flights.api.FlightsApi;
import hu.qlm.flights.dto.Airline;
import hu.qlm.flights.service.AirlineService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @PreAuthorize("hasAuthority('CREATE_EMP')")
    public List<Airline> searchFlight(String from, String to) {
    	//System.out.println(request.getHeader("x-jwt-username"));
    	System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        return airlineService.search(from, to);
    }
    
    
    @GetMapping("/flight2/{from}/{to}")
    public List<Airline> searchFlight2(@PathVariable String from, @PathVariable String to, @AuthenticationPrincipal UserDetails currentUser) {
    	System.out.println(currentUser.getUsername());
        return airlineService.search(from, to);
    }
}
