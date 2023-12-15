package Task2.controller;

import Task2.model.CurrencyConverterModel;
import Task2.dao.CurrencyDao;
import Task2.view.CurrencyConverterView;

public class CurrencyConverterController {
    private CurrencyConverterModel model;
    private CurrencyDao currencyDao;

    public CurrencyConverterController(CurrencyConverterModel model, CurrencyDao currencyDao) {
        this.model = model;
        this.currencyDao = currencyDao;
    }

    public double convert(double amount, String sourceCurrency, String targetCurrency) {
        double sourceRate = currencyDao.getExchangeRate(sourceCurrency);
        double targetRate = currencyDao.getExchangeRate(targetCurrency);
        return (amount / sourceRate) * targetRate;
    }

    public String[] getAvailableCurrencies() {
        return model.getAvailableCurrencies();
    }
    public static void main(String[]args) {
        CurrencyConverterView.launch(CurrencyConverterView.class, args);
    }
}
