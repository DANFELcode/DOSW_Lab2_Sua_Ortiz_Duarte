import java.util.*;

/**
 * This is Don Pepe's store system allowing him to have an organized store.
 * 
 * @author Daniel Felipe Sua Siempira
 * @author Juan Pablo Duarte Silva
 * @author David Felipe Ortiz Salcedo
 */

interface discountInterface {
    double discountCalculation(int productPrice);
}

public class newCustomerDiscount implements discountInterface {
    @Override
    public double discountCalculation(int productPrice) {
        return productPrice * 0.5;
    }
}

public class frequentCustomerDiscount implements discountInterface {
    @Override
    public double discountCalculation(int productPrice) {
        return productPrice * 0.10;
    }
}

public class receipt {
    private final List<String> productsList;
    private final int totalPrice;
    private final double totalDiscount;
    private final double finalAmount;

    public receipt(List<String> productsList, int totalPrice, double totalDiscount, double finalAmount) {
        this.productsList = productsList;
        this.totalPrice = totalPrice;
        this.totalDiscount = totalDiscount;
        this.finalAmount = finalAmount;
    }

    public List<String> getProductsList() {
        return productsList;
    }
}

public class Challenge1 {
    
}