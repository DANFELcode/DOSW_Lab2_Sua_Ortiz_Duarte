package edu.eci.dosw.challenge4;


import java.util.Map;

public class FixedExchangeRate implements ExchangeRate{
    private final Map<String, Double> rates;

    public FixedExchangeRate(){
        this.rates = Map.of(
                "USD", 1.0,
                "EUR", 0.86,
                "JPY", 159.23,
                "COP", 3130.97
        );
    }
    @Override
    public Double getRate(String origin, String destination) {
        Double originRate = rates.get(origin);
        Double destinationRate = rates.get(destination);

        if (originRate == null || destinationRate == null){
            throw new IllegalArgumentException("arguments cannot be null");
        }
        return destinationRate/originRate;
    }
}
