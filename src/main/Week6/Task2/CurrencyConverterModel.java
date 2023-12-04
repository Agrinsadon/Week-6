package Task2;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverterModel {
    private Map<String, Double> conversionRates;

    public CurrencyConverterModel() {
        conversionRates = new HashMap<>();
        conversionRates.put("USD", 1.0);
        conversionRates.put("EUR", 0.85);
        conversionRates.put("GBP", 0.75);
    }

    public double convert(double amount, String sourceCurrency, String targetCurrency) {
        double sourceRate = conversionRates.get(sourceCurrency);
        double targetRate = conversionRates.get(targetCurrency);

        return (amount / sourceRate) * targetRate;
    }

    public String[] getAvailableCurrencies() {
        return conversionRates.keySet().toArray(new String[0]);
    }
}
