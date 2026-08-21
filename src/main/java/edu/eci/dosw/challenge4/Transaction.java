package edu.eci.dosw.challenge4;

public class Transaction {
    private final Double originalAmount;
    private final String sourceCurrency;
    private final Double convertedAmount;
    private final String destinationCurrency;

    public Transaction(Double originalAmount, String sourceCurrency, Double convertedAmount, String destinationCurrency) {
        this.originalAmount = originalAmount;
        this.sourceCurrency = sourceCurrency;
        this.convertedAmount = convertedAmount;
        this.destinationCurrency = destinationCurrency;
    }

    public Double getOriginalAmount(){
        return originalAmount;
    }
    public String getSourceCurrency(){
        return sourceCurrency;
    }
    public Double getConvertedAmount(){
        return convertedAmount;
    }
    public String getDestinationCurrency(){
        return destinationCurrency;
    }

}