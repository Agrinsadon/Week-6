package Task2.dao;

import Task2.datasource.MariaDbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyDao {

    public double getExchangeRate(String currencyAbbreviation) {
        double exchangeRate = 0.0;

        try (Connection connection = MariaDbConnection.getConnection()) {
            String sql = "SELECT conversion_rate FROM currency WHERE abbreviation = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, currencyAbbreviation);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        exchangeRate = resultSet.getDouble("conversion_rate");
                    }
                }
            }
        } catch (SQLException e) {
            // Handle database-related errors (e.g., connection issues)
            e.printStackTrace();
        }

        return exchangeRate;
    }
}
