package Task2;

public class CurrencyConverterController {
    private CurrencyConverterModel model;

    public CurrencyConverterController(CurrencyConverterModel model) {
        this.model = model;
    }

    public double convert(double amount, String sourceCurrency, String targetCurrency) {
        return model.convert(amount, sourceCurrency, targetCurrency);
    }

    public String[] getAvailableCurrencies() {
        return model.getAvailableCurrencies();
    }
    public static void main(String[]args) {
        Task2.CurrencyConverterView.launch(Task2.CurrencyConverterView.class, args);
    }
}
