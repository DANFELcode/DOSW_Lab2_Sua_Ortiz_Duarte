package edu.eci.dosw;

import edu.eci.dosw.challenge1.Challenge1PepeStore;
import edu.eci.dosw.challenge4.Challenge4CurrencyExchangeScam;
import edu.eci.dosw.challenge6.Challenge6TechnicalSupport;

public class Application {
    public static void main(String[] args) {
        System.out.println("Maven project configured and running correctly.");
        Challenge1PepeStore.run();
        Challenge4CurrencyExchangeScam.run();
        Challenge6TechnicalSupport.run();
    }
}