package edu.eci.dosw;

import edu.eci.dosw.challenge1.Challenge1PepeStore;
import edu.eci.dosw.challenge2.Challenge2FiveStarChef;
import edu.eci.dosw.challenge3.Challenge3TheKingdomOfVehicles;
import edu.eci.dosw.challenge4.Challenge4CurrencyExchangeScam;
import edu.eci.dosw.challenge5.Challenge5CustomizedCoffee;
import edu.eci.dosw.challenge6.Challenge6TechnicalSupport;
import edu.eci.dosw.challenge7.Challenge7MagicRemoteControl;

public class Application {
    public static void main(String[] args) {
        System.out.println("Maven project configured and running correctly.");
        Challenge1PepeStore.run();
        Challenge2FiveStarChef.run();
        Challenge3TheKingdomOfVehicles.run();
        Challenge4CurrencyExchangeScam.run();
        Challenge5CustomizedCoffee.run();
        Challenge6TechnicalSupport.run();
        Challenge7MagicRemoteControl.run();
    }
}