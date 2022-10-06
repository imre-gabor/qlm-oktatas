package hu.qlm.currency.web;

import hu.qlm.currency.api.CurrencyApi;
import hu.qlm.currency.service.CurrencyService;
import hu.qlm.currency.service.RateDescriptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CurrencyController implements CurrencyApi {

    @Autowired
    private CurrencyService currencyService;
    
    @Override
    public double getRate(String from, String to) {
        return currencyService.getRate(new RateDescriptor(from, to));
    }
}
