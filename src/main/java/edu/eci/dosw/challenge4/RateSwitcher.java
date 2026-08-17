package edu.eci.dosw.challenge4;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class RateSwitcher {
    private ExchangeRate rate;


    public RateSwitcher(ExchangeRate rate){
        this.rate = rate;
    }

    public Transaction convert(Double amount, String source, String destination){
        Double conversion = amount * rate.getRate(source, destination);
        return new Transaction(amount, source, conversion, destination);

    }

    public List<Transaction> convert(Double amount, String source, List<String> destinations){

        return destinations.stream()
                .map(destination -> this.convert(amount, source, destination))
                .toList();

    }


}
